package top.serug.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/4/29  14:14
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7003Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7003Application.class, args);
    }
}
