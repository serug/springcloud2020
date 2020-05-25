package top.serug.springcloud.alibabanacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/25  16:50
 */
@RestController
@Slf4j
public class OrderController {
    @Value("${server.port}")
    private String serverPort;

    @Value("${server-url.nacos-user-service}")
    private String serverURL;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/payment/nacos")
    public String paymentNacos(){
        return restTemplate.getForObject(serverURL+"/payment/nacos", String.class);
    }

}
