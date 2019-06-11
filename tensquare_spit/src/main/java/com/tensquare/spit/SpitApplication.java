package com.tensquare.spit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * Created by Administrator on 2019/5/25.
 */
@SpringBootApplication
public class SpitApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpitApplication.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
