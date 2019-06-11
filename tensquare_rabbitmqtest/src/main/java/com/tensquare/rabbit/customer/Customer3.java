package com.tensquare.rabbit.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/5/26.
 * RabbitListener:监听消费者
 * Component：将消费者放入容器中
 */
@Component
@RabbitListener(queues = "kudingyu")
public class Customer3 {

    @RabbitHandler
    public void getMsg(String msg){
        System.out.println("kudingyu："+msg);
    }
}
