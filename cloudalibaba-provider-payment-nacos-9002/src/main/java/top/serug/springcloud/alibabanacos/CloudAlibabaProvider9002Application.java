package top.serug.springcloud.alibabanacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/25  16:49
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaProvider9002Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaProvider9002Application.class, args);
    }
}
