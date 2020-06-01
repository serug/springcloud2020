package top.serug.springcloud.seata.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.serug.responseentity.CommonResponse;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/31  11:20
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @RequestMapping("/storage/decrease")
    public CommonResponse decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
