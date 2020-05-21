package top.serug.springcloud.configclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/21  11:36
 */
@RestController
@Slf4j
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @Value("${test.info}")
    private String testInfo;


    @RequestMapping("/config/getInfo")
    public String getConfigInfo(){
        return configInfo+"\t"+testInfo;
    }


}
