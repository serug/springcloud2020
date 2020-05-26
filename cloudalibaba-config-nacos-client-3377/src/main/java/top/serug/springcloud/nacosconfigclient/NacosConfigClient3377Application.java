package top.serug.springcloud.nacosconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/26  12:12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClient3377Application {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClient3377Application.class, args);
    }
}
