package top.serug.springcloud.alibabanacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/25  16:49
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CloudAlibabaConsumer84Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaConsumer84Application.class, args);
    }
}
