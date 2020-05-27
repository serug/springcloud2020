package top.serug.springcloud.sentinelservice.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/27  22:09
 */
@RestController
@Slf4j
public class FlowLimitController {

    @RequestMapping("/testA")
    public String testA(){
        return "========= test A =========";
    }

    @RequestMapping("/testB")
    public String testB(){
        return "========= test B =========";
    }

    /**
     * @Description: 使用jmeter压测，RT、异常比例
     * @Param:
     * @return:
     */
    @RequestMapping("/testD")
    public String testD(){

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return "========= test D =========";
    }


    /**
     * @Description: 异常数：一分钟内，异常数达到阈值，就降级
     * @Param:
     * @return:
     */
    @RequestMapping("/testE")
    public String testE(){
        log.info("testD 测试异常数");
        int a = 10/0;
        return "========= test E  测试异常数 =========";
    }


    /**
     * @Description: 热点限流测试
     * 热点限流需要配置 blockHandler, 否则就会进入Error page的不友好提示页面
     * @Param:
     * @return:
     */
    @RequestMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(String p1,String p2){
        return "========= testHotKey  热点限流测试 =========";
    }

    public String deal_testHotKey(String p1, String p2, BlockException e){
        return "========= deal_testHotKey  热点限流兜底方法 =========";
    }


}
