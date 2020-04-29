package top.serug.springcloud.payment.service;

import top.serug.payment.Payment;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/4/23  13:44
 */
public interface IPaymentService {

    public long addPayment(Payment bo);

    public List<Payment> getPaymentList(Map<String, Object> params);

    public Payment getPaymentByPayId(Long payId);

}
