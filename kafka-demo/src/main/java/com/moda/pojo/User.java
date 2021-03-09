package com.moda.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Configuration
@PropertySource(value="classpath:application.properties")
public class User implements Serializable {

    @Value("${user.name}")
    private String name;
    @Value("${user.age}")
    private int age;
}
