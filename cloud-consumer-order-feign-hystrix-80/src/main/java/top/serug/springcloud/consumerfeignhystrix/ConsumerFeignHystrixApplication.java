package top.serug.springcloud.consumerfeignhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/18  21:22
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class ConsumerFeignHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignHystrixApplication.class, args);
    }
}
