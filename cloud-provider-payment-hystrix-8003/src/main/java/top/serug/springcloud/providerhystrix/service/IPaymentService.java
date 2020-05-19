package top.serug.springcloud.providerhystrix.service;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/18  20:47
 */
public interface IPaymentService {

    public String payment_ok(Integer id);

    public String payment_timeout(Integer id);

    public String paymentCircuitBreaker(Integer id);
}
