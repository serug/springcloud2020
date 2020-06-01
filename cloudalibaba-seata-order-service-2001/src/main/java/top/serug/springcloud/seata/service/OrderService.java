package top.serug.springcloud.seata.service;

import top.serug.seata.Order;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/31  11:10
 */
public interface OrderService {
    public void insert(Order order);
    public void update(Order order);
}
