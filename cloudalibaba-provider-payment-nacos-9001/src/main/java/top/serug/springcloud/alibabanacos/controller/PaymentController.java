package top.serug.springcloud.alibabanacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/25  16:50
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/nacos")
    public String paymentNacos(){
        return "cloud alibaba nacos as discovery ："+serverPort;
    }

}
