package com.tensquare.test;

import com.tensquare.rabbit.RabbitApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2019/5/26.
 */

/**
 * RunWith替代junit原生的运行器
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitApplication.class)
public class productTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSend1(){
        //convertAndSend
        rabbitTemplate.convertAndSend("itcast","我要红包");
    }
    /**
     * 分列模式
     */
    @Test
    public void testSend2(){
        //convertAndSend
        rabbitTemplate.convertAndSend("chuanzhi","","分列模式");
    }

    /**
     * 主题模式
     */
    @Test
    public void testSend3(){
        //convertAndSend
        rabbitTemplate.convertAndSend("topit84","good.log","主题模式");
    }
}
