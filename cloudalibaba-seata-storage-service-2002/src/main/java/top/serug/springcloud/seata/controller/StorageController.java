package top.serug.springcloud.seata.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.serug.responseentity.CommonResponse;
import top.serug.springcloud.seata.service.StorageService;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/31  12:59
 */
@RestController
@Slf4j
public class StorageController {
    @Resource
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonResponse decrease(Long productId, Integer count){
        storageService.decrease(productId,count);
        return new CommonResponse(200,"storage调用成功",true);
    }

}
