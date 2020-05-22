package top.serug.springcloud.cloudstreamconsumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/22  16:25
 */
@Component
@EnableBinding(Sink.class)
public class CloudStreamConsumerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者8802，接收道德消息："+message.getPayload()+"\t port："+serverPort);
    }

}
