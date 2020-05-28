package top.serug.springcloud.payment.service.impl;

import org.springframework.stereotype.Service;
import top.serug.payment.Payment;
import top.serug.springcloud.payment.service.IPaymentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/4/23  19:28
 */
@Service
public class PaymentServiceImpl implements IPaymentService {

    //@Autowired
    //private PaymentMapper paymentMapper;

    @Override
    public long addPayment(Payment bo) {
        //long id = paymentMapper.addPayment(bo);
        //return id;
        return 123L;
    }

    @Override
    public List<Payment> getPaymentList(Map<String, Object> params) {
        //List<Payment> list = paymentMapper.getPaymentList(params);
        //return list;
        return new ArrayList<Payment>();
    }

    @Override
    public Payment getPaymentByPayId(Long payId) {
        //Payment bo = paymentMapper.getPaymentByPayId(payId);
        //return bo;
        return new Payment();
    }


}
