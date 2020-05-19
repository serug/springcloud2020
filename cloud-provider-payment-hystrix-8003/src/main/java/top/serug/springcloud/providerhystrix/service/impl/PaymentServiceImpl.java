package top.serug.springcloud.providerhystrix.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import top.serug.springcloud.providerhystrix.service.IPaymentService;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 实现Hystrix服务降级（方法级别的方式）：超时和异常都会进入兜底的降级方法
 * @Author: serug
 * @Date: 2020/5/18  20:50
 */
@Service
public class PaymentServiceImpl implements IPaymentService {

    @Override
    public String payment_ok(Integer id) {
        return "线程池："+Thread.currentThread().getName()+" payment_ok, id："+id+"\t"+"成功调用OK方法";
    }


    //服务降级：这里演示的是当个方法的降级配置，还有全局配置

    @Override
    @HystrixCommand(fallbackMethod = "payment_timeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String payment_timeout(Integer id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //int a = 10/0;

        return "线程池："+Thread.currentThread().getName()+" payment_timeout, id："+id+"\t"+"成功调用OK方法";
    }

    public String payment_timeoutHandler(Integer id){
        return "调用支付接口超时或异常，当前线程池名："+Thread.currentThread().getName();
    }


    //服务熔断：
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期10s
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
            //解释：在10s的时间窗口期内，10次的请求中，有60%是失败的，那就开启断路器
    })
    @Override
    public String paymentCircuitBreaker(Integer id){
        if (id<0) {
            throw new RuntimeException("id 不能为空");
        }

        String serialNumber = IdUtil.simpleUUID();
        return "线程池："+Thread.currentThread().getName()+"  调用成功，流水号为："+serialNumber;

    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "8003 服务提供方出现异常，服务降级，当达到熔断条件时，将会开启断路器。";
    }

}
