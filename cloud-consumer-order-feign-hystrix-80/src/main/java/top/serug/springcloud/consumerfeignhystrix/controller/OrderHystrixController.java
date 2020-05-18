package top.serug.springcloud.consumerfeignhystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.serug.springcloud.consumerfeignhystrix.service.PaymentHystrixService;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/18  21:26
 */
@RestController
@Slf4j
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;


    @RequestMapping("/consumer/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        String result = paymentHystrixService.payment_ok(id);
        return result;
    }

    @HystrixCommand(fallbackMethod = "payment_timeout_fallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    @RequestMapping("/consumer/payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id){
        String result = paymentHystrixService.payment_timeout(id);
        return result;
    }

    public String payment_timeout_fallback(Integer id){
        return "调用支付接口超时或异常，消费者80，服务降级";
    }
}
