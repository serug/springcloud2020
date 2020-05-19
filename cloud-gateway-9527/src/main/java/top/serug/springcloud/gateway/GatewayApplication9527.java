package top.serug.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import top.serug.springcloud.gateway.filter.ExampleGatewayFilterFactory;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/19  21:00
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication9527 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication9527.class, args);
    }


}
