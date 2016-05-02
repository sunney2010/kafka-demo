package com.sunney;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.alibaba.fastjson.JSON;
import com.sunney.service.KafkaService;
import com.sunney.service.UserDto;


/**
 * Hello world!
 */
@SpringBootApplication
@EnableScheduling
@ComponentScan
@EnableAutoConfiguration
@ServletComponentScan
public class Application {

    public static ApplicationContext applicationContext;
   
    public static void main(String[] args) throws Exception {

        SpringApplication app = new SpringApplication(Application.class);
        app.setWebEnvironment(false);
        Set<Object> set = new HashSet<Object>();
        set.add("classpath:applicationContext.xml");
        app.setSources(set);
        applicationContext = app.run(args);
        send();

    }
    public static void  send(){
        KafkaService kafkaService = Application.applicationContext.getBean("kafkaService", KafkaService.class);
        UserDto user=null;
        for (int i = 1; i < 100; i++) {
            user=new UserDto();
            user.setGmtCeate(new Date());
            user.setUserId(i);
            user.setUserName("sunney");
            List<Long> list=new ArrayList<Long>();
            list.add(10000l);
            list.add(10001l);
            list.add(10002l);
            user.setUserList(list);
           String msg= JSON.toJSONString(user);
           kafkaService.sendUserInfo("sunneytopic",msg);
        }
    }

}
