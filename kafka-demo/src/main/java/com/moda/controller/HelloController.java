package com.moda.controller;

import com.moda.kafka.KafkaProducer;
import com.moda.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
    @Autowired
    private User user;
    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping("/{name}")
    public String hello (@PathVariable String name){
        return "hello " + name;
    }

    @RequestMapping("/createMsg")
    public void createMsg() {
        kafkaProducer.sendUserMessage(user);
    }
}
