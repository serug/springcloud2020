package top.serug.springcloud.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/21  20:07
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClient3366Application {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3366Application.class, args);
    }
}
