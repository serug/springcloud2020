package top.serug.springcloud.seata.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.serug.responseentity.CommonResponse;
import top.serug.seata.Order;
import top.serug.springcloud.seata.service.OrderService;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/31  12:09
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping("/order/insert")
    public CommonResponse insert(Order order){
        orderService.insert(order);
        return new CommonResponse(200,"订单创建成功",true);
    }
}
