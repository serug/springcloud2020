package top.serug.springcloud.sentinelservice.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.serug.payment.Payment;
import top.serug.responseentity.CommonResponse;
import top.serug.springcloud.sentinelservice.blockhandler.CustomerBlockHandler;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/28  22:03
 */
@RestController
public class RateLimitController {

    /**
     * @Description: 按资源名称限流测试
     * @Param:
     * @return:
     */
    @GetMapping("/rateLimit/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResponse byResource(){
        return new CommonResponse(200,"按资源名称限流测试OK",true ,new Payment(12L,new BigDecimal(30)));
    }
    public CommonResponse handleException(BlockException e){
        return new CommonResponse(4444,e.getClass().getCanonicalName()+"\t 服务不可用",false);
    }

    /**
     * @Description: 按url限流测试
     * @Param:
     * @return:
     */
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResponse byUrl(){
        return new CommonResponse(200,"按url限流测试OK",true ,new Payment(12L,new BigDecimal(30)));
    }


    /**
     * @Description: 使用自定义的限流处理类
     * @Param:
     * @return:
     */
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "blockHandler_1")
    public CommonResponse customerBlockHandler(){
        return new CommonResponse(200,"使用自定义的限流处理类OK",true ,new Payment(12L,new BigDecimal(30)));
    }


}
