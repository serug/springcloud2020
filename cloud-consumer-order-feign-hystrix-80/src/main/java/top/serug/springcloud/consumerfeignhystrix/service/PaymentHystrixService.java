package top.serug.springcloud.consumerfeignhystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/18  21:23
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE-HYSTRIX")
public interface PaymentHystrixService {

    @RequestMapping("/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id);

    @RequestMapping("/payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id);
}
