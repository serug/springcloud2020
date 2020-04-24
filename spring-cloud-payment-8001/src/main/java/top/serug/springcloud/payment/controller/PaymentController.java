package top.serug.springcloud.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.serug.payment.Payment;
import top.serug.springcloud.payment.service.IPaymentService;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/4/23  19:56
 */

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @RequestMapping("/add")
    public long addPayment(){
        Payment bo = new Payment();
        bo.setPayMoney(new BigDecimal("22.9"));
        long id = paymentService.addPayment(bo);
        return id;
    }
}
