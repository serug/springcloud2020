package top.serug.springcloud.consumerfeignhystrix.service.hystrix;

import org.springframework.stereotype.Component;
import top.serug.springcloud.consumerfeignhystrix.service.PaymentHystrixService;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/19  10:55
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String payment_ok(Integer id) {
        return "通配服务降级  PaymentHystrixServiceImpl: payment_ok，CLOUD-PAYMENT-SERVICE-HYSTRIX服务异常或超时";
    }

    @Override
    public String payment_timeout(Integer id) {
        return "通配服务降级  PaymentHystrixServiceImpl：payment_timeout，CLOUD-PAYMENT-SERVICE-HYSTRIX服务异常或超时";
    }
}
