package top.serug.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.serug.responseentity.CommonResponse;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/9  22:08
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface IPaymentFeignService {

    @RequestMapping("/payment/get/{id}")
    public CommonResponse getPaymentById(@PathVariable("id") Long id);

    @RequestMapping("/payment/timeout")
    public String paymentFeignTimeout();

    @RequestMapping("/payment/lb")
    public String lb();
}
