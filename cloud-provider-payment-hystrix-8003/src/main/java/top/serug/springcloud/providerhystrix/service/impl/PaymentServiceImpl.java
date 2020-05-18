package top.serug.springcloud.providerhystrix.service.impl;

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
}
