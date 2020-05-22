package top.serug.springcloud.cloudstreamconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/22  16:36
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudStreamConsumer8803Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudStreamConsumer8803Application.class, args);
    }
}
