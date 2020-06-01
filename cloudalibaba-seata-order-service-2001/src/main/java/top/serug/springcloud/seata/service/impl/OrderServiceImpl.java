package top.serug.springcloud.seata.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.serug.seata.Order;
import top.serug.springcloud.seata.dao.OrderDao;
import top.serug.springcloud.seata.service.AccountService;
import top.serug.springcloud.seata.service.OrderService;
import top.serug.springcloud.seata.service.StorageService;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/31  11:20
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;


    @Override
    @GlobalTransactional(name = "my-insert-order", rollbackFor = Exception.class)
    public void insert(Order order) {
        log.info("==============1.新建订单");
        orderDao.insert(order);

        log.info("==============2.库存扣减count");
        storageService.decrease(order.getProductId(),order.getCount());

        log.info("==============3.账号扣减Money");
        accountService.decrease(order.getUserId(), order.getMoney());

        log.info("==============4.修改订单状态");
        order.setStatus(1);
        orderDao.update(order);

        log.info("==============完成下订单的流程");

    }

    @Override
    public void update(Order order) {

    }
}













