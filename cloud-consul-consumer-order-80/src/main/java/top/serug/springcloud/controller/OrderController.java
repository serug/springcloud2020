package top.serug.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.serug.payment.Payment;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/4/27  10:36
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymentConsul(Payment bo){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/consul", bo, String.class);
    }



}
