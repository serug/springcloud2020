package top.serug.springcloud.sentinelservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/27  22:08
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelService8401Application {

    public static void main(String[] args) {
        SpringApplication.run(SentinelService8401Application.class, args);
    }
}
