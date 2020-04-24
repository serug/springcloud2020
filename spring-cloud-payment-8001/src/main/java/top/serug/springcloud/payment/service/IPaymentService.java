package top.serug.springcloud.payment.service;

import top.serug.payment.Payment;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/4/23  13:44
 */
public interface IPaymentService {

    public long addPayment(Payment bo);
}
