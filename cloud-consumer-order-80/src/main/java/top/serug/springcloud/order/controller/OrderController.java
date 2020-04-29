package top.serug.springcloud.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.serug.payment.Payment;
import top.serug.responseentity.CommonResponse;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/4/27  10:36
 */
@RestController
@Slf4j
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/add")
    public CommonResponse<Payment> add(Payment bo){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/add", bo, CommonResponse.class);
    }

    @GetMapping("/consumer/payment/{id}")
    public CommonResponse<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/"+id, CommonResponse.class);
    }

}
