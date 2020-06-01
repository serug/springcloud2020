package top.serug.springcloud.seata.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.serug.responseentity.CommonResponse;
import top.serug.springcloud.seata.dao.AccountDao;
import top.serug.springcloud.seata.service.AccountService;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/31  11:20
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;
    @Override
    public CommonResponse decrease(Long userId,  BigDecimal money) {
        accountDao.decrease(userId, money);
        System.out.println("123");
        if(userId == 3L){
            int a = 10/0;
        }
        return new CommonResponse(200,"调用 accountDao 成功",true);
    }
}













