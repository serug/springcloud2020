package top.serug.springcloud.alibabanacos.serivce;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.serug.payment.Payment;
import top.serug.responseentity.CommonResponse;
import top.serug.springcloud.alibabanacos.serivce.impl.PaymentFeignFallbackServiceImpl;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/29  16:47
 */
@FeignClient(value = "nacos-provider-payment", fallback = PaymentFeignFallbackServiceImpl.class)
public interface PaymentFeignService {

    @RequestMapping("/paymentSQL/{id}")
    public CommonResponse<Payment> paymentSQL(@PathVariable("id") Long id);
}
