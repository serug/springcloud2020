package top.serug.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/7  17:39
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulPaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulPaymentApplication.class, args);
    }
}
