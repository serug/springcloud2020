package top.serug.springcloud.alibabanacos.serivce.impl;

import org.springframework.stereotype.Component;
import top.serug.payment.Payment;
import top.serug.responseentity.CommonResponse;
import top.serug.springcloud.alibabanacos.serivce.PaymentFeignService;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/29  16:59
 */
@Component
public class PaymentFeignFallbackServiceImpl implements PaymentFeignService {

    @Override
    public CommonResponse<Payment> paymentSQL(Long id) {
        return new CommonResponse(666, "Feign接口调用异常，服务降级返回============",false) ;
    }


}
