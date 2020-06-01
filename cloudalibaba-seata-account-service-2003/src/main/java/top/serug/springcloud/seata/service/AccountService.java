package top.serug.springcloud.seata.service;

import top.serug.responseentity.CommonResponse;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/31  11:20
 */
public interface AccountService {

    public CommonResponse decrease(Long userId,  BigDecimal money);
}
