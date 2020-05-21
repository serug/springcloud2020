package top.serug.springcloud.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/21  11:31
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClient3355Application {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3355Application.class, args);
    }
}
