package top.serug.springcloud.seata.dao;

import org.apache.ibatis.annotations.Mapper;
import top.serug.seata.Order;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/31  10:35
 */
@Mapper
public interface OrderDao {

    /**
     * @Description: 创建订单
     * @Param:
     * @return:
     */
    public void insert(Order order);

    /**
     * @Description: 修改订单状态
     * @Param:
     * @return:
     */
    public void update(Order order);
}
