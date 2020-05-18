package top.serug.springcloud.providerhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/18  20:41
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class ProviderHystrixApplication8003 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderHystrixApplication8003.class, args);
    }

}
