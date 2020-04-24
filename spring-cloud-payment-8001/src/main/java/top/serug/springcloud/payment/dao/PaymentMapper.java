package top.serug.springcloud.payment.dao;

import org.apache.ibatis.annotations.Mapper;
import top.serug.payment.Payment;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/4/22  23:25
 */
@Mapper
public interface PaymentMapper {

    /**
     * @Description: 新增
     * @Param: 
     * @return: 
     */
    public long addPayment(Payment bo);
    
    
    
}
