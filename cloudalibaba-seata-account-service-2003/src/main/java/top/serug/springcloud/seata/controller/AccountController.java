package top.serug.springcloud.seata.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.serug.responseentity.CommonResponse;
import top.serug.springcloud.seata.service.AccountService;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/31  12:59
 */
@RestController
@Slf4j
public class AccountController {
    @Resource
    private AccountService accountService;

    @RequestMapping("/account/decrease")
    public CommonResponse decrease(Long userId,  BigDecimal money){
        accountService.decrease(userId,money);
        return new CommonResponse(200,"acount调用成功",true);
    }

}
