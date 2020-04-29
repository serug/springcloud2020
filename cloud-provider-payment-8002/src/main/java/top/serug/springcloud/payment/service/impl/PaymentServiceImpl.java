package top.serug.springcloud.payment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.serug.springcloud.payment.dao.PaymentMapper;
import top.serug.springcloud.payment.service.IPaymentService;
import top.serug.payment.Payment;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/4/23  19:28
 */
@Service
public class PaymentServiceImpl implements IPaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public long addPayment(Payment bo) {
        long id = paymentMapper.addPayment(bo);
        return id;
    }

    @Override
    public List<Payment> getPaymentList(Map<String, Object> params) {
        List<Payment> list = paymentMapper.getPaymentList(params);
        return list;
    }

    @Override
    public Payment getPaymentByPayId(Long payId) {
        Payment bo = paymentMapper.getPaymentByPayId(payId);
        return bo;
    }


}
