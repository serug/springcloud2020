package top.serug.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/19  14:39
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashboardHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(DashboardHystrixApplication.class, args);
    }

}
