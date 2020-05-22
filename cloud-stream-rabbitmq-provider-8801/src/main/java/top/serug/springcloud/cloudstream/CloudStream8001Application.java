package top.serug.springcloud.cloudstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/22  15:52
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudStream8001Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudStream8001Application.class, args);
    }
}
