package top.serug.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/9  21:07
 */
public interface IMyLoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);
}
