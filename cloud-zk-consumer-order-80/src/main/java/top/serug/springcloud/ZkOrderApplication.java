package top.serug.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/4/27  10:24
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZkOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZkOrderApplication.class, args);
    }
}
