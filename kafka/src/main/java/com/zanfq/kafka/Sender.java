package com.zanfq.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zanfq.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * Author:      皮聪
 * Date:        2017/5/31
 * Description:
 */
@Component
public class Sender {

    @Autowired
    private KafkaTemplate kafkaTemplate;
    private Gson gson = new GsonBuilder().create();

    public void senMessage(){
        Message m = new Message();
        m.setId(System.currentTimeMillis());
        m.setMsg(UUID.randomUUID().toString());
        m.setSendTime(new Date());
        kafkaTemplate.send("test",gson.toJson(m));
    }
}
