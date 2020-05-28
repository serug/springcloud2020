package top.serug.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.serug.payment.Payment;
import top.serug.responseentity.CommonResponse;
import top.serug.springcloud.service.IPaymentFeignService;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/9  22:16
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private IPaymentFeignService iPaymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResponse<Payment> getPaymentById(@PathVariable("id") Long id){
        return iPaymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public String paymentFeignTimeout(){
        return iPaymentFeignService.paymentFeignTimeout();
    }

    @GetMapping("/consumer/payment/lb")
    public String lb(){
        return iPaymentFeignService.lb();
    }
}
