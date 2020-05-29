package top.serug.springcloud.alibabanacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.serug.payment.Payment;
import top.serug.responseentity.CommonResponse;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/25  16:50
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L, new Payment(1L, new BigDecimal(111)));
        hashMap.put(2L, new Payment(2L, new BigDecimal(222)));
        hashMap.put(3L, new Payment(3L, new BigDecimal(333)));
    }


    @RequestMapping("/paymentSQL/{id}")
    public CommonResponse<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        CommonResponse<Payment> response = new CommonResponse(200,"from paymentSQL, serverPort："+serverPort,true,payment);
        return response;
    }

}
