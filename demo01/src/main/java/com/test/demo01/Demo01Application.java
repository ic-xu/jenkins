package com.test.demo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableEurekaClient
public class Demo01Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo01Application.class, args);
    }

}
