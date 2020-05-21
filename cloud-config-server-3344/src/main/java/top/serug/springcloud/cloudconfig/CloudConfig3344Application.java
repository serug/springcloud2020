package top.serug.springcloud.cloudconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/21  10:58
 */
@SpringBootApplication
@EnableConfigServer
public class CloudConfig3344Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfig3344Application.class, args);
    }
}
