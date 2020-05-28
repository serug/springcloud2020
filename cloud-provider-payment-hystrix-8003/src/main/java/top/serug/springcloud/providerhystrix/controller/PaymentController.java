package top.serug.springcloud.providerhystrix.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.serug.springcloud.providerhystrix.service.IPaymentService;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/18  20:51
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private IPaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        String result = paymentService.payment_ok(id);
        return result;
    }

    @RequestMapping("/payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id){
        String result = paymentService.payment_timeout(id);
        return result;
    }

    //服务熔断
    @RequestMapping("/payment/hystrix/circuitBreaker/{id}")
    public String payment_circuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        return result;
    }



}
