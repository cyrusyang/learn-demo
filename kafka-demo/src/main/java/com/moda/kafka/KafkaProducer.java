package com.moda.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.moda.pojo.User;
import lombok.extern.java.Log;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Log
@Component
public class KafkaProducer {
    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendUserMessage(User user) {
        Gson gson = new Gson();
        user = new User();
        user.setName("张三");
        user.setAge(2);
        String message = gson.toJson(user);
        kafkaTemplate.send("sun", message);
        log.info("\n生产消息至Kafka\n" + message);
    }
}
