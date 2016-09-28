package com.sunney;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

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

    }

}
