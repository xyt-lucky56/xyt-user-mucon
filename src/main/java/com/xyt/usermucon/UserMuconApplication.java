package com.xyt.usermucon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserMuconApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserMuconApplication.class, args);
    }

}
