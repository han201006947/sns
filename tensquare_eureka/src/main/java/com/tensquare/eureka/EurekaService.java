package com.tensquare.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Administrator on 2019/6/3.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaService {

    public static void main(String[] args) {
        SpringApplication.run(EurekaService.class);
    }
}
