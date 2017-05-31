package com.zanfq.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zanfq.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


/**
 * Author:      皮聪
 * Date:        2017/5/31
 * Description:
 */
@Component
public class Receiver {

    private final static Logger logger = LoggerFactory.getLogger(Receiver.class);

    private Gson gson = new GsonBuilder().create();

    @KafkaListener(topics = "test")
    public void processMessage(String content){
        Message m = gson.fromJson(content,Message.class);
        logger.info("消息发送者发送的信息 m={}",m);
    }

}
