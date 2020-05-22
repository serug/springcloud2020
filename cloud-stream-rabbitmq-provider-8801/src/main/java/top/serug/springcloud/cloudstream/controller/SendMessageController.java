package top.serug.springcloud.cloudstream.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.serug.springcloud.cloudstream.service.IMessageProvider;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/22  16:02
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @RequestMapping("/sendMessage")
    public String sendMessage(){
        return iMessageProvider.send();
    }
}
