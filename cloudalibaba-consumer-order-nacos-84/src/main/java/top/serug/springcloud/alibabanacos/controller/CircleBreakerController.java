package top.serug.springcloud.alibabanacos.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.serug.payment.Payment;
import top.serug.responseentity.CommonResponse;
import top.serug.springcloud.alibabanacos.serivce.PaymentFeignService;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/25  16:50
 */
@RestController
@Slf4j
public class CircleBreakerController {
    @Value("${server.port}")
    private String serverPort;

    @Value("${server-url.nacos-user-service}")
    private String serverURL;

    @Resource
    private RestTemplate restTemplate;

    public CommonResponse handlerFallback(@PathVariable("id") Long id, Throwable throwable){
        return new CommonResponse(444,"handlerFallback，运行时异常兜底方法",false,null);
    }

    public CommonResponse handlerBlocker(@PathVariable("id") Long id, Throwable throwable){
        return new CommonResponse(555,"handlerBlocker，控制台兜底方法",false,null);
    }

    //1：java 异常
    //@SentinelResource(value = "fallback", fallback = "handlerFallback")
    //2：Sentinel控制台的配置违规配置
    //@SentinelResource(value = "fallback", blockHandler = "handlerBlocker")
    //3：Sentinel控制台的配置违规、Java异常配置：控制台配置规则优先级高于运行时异常
    //@SentinelResource(value = "fallback", blockHandler = "handlerBlocker", fallback = "handlerFallback")
    //4：Sentinel控制台的配置违规、Java异常配置：控制台配置规则优先级高于运行时异常，添加忽略属性
    @SentinelResource(value = "fallback", blockHandler = "handlerBlocker", fallback = "handlerFallback", exceptionsToIgnore = IllegalArgumentException.class)
    @RequestMapping("/consumer/fallback/{id}")
    public CommonResponse<Payment> fallback(@PathVariable("id") Long id){
        CommonResponse<Payment> response = restTemplate.getForObject(serverURL+"/paymentSQL/"+id, CommonResponse.class);
        if (id == 4){
            throw new IllegalArgumentException("非法参数异常");
        }else if(response.getData() == null){
            throw new NullPointerException("没有该ID的记录。");
        }

        return response;
    }


    //============feign sentinel
    @Resource
    private PaymentFeignService paymentFeignService;

    @RequestMapping("/consumer/paymentSQL/{id}")
    public CommonResponse<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentFeignService.paymentSQL(id);
    }


}
