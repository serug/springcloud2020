package top.serug.springcloud.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.serug.payment.Payment;
import top.serug.responseentity.CommonResponse;
import top.serug.springcloud.payment.service.IPaymentService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/4/23  19:56
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("/add")
    public CommonResponse addPayment(@RequestBody Payment bo){
        long result = paymentService.addPayment(bo);
        return result>0L?new CommonResponse(200, "插入数据库成功, 调用的服务为："+serverPort, true, result):new CommonResponse(444, "插入数据库失败", false, null);
    }

    @RequestMapping("/list")
    public CommonResponse getPaymentListByParams(HttpServletRequest request){
        Map<String, Object> params = new HashMap<String, Object>();
        List<Payment> list = paymentService.getPaymentList(params);
        return (list!=null && list.size()>0)?new CommonResponse(200, "查询列表成功, 调用的服务为："+serverPort, true, list):new CommonResponse(444, "查询列表记录为空", false, null);

    }

    @RequestMapping("/{id}")
    public CommonResponse getPaymentById(@PathVariable("id") Long id){
        Payment bo = paymentService.getPaymentByPayId(id);
        return bo != null?new CommonResponse(200, "查询成功, 调用的服务为："+serverPort, true, bo):new CommonResponse(444, "查询对应记录为空", false, null);
    }

    @RequestMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("******** service ******："+service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("******** instance ******："+instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }
}

