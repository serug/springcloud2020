package top.serug.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/6  20:43
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZkPaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZkPaymentApplication.class, args);
    }
}
