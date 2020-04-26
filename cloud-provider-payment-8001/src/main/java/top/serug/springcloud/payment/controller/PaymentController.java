package top.serug.springcloud.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.serug.payment.Payment;
import top.serug.springcloud.payment.service.IPaymentService;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/list")
    public List<Payment> getPaymentListByParams(HttpServletRequest request){
        Map<String, Object> params = new HashMap<String, Object>();
        List<Payment> list = paymentService.getPaymentList(params);
        return list;

    }
}

