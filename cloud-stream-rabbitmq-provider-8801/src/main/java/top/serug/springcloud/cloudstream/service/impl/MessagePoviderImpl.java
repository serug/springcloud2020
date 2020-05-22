package top.serug.springcloud.cloudstream.service.impl;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import top.serug.springcloud.cloudstream.service.IMessageProvider;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/22  15:54
 */
@EnableBinding(Source.class)
public class MessagePoviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println(serial);
        return null;
    }
}
