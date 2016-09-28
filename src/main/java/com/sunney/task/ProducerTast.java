/*
 * Copyright 1999-2024 Colotnet.com All right reserved. This software is the confidential and proprietary information of
 * Colotnet.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Colotnet.com.
 */
package com.sunney.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.sunney.service.KafkaService;
import com.sunney.service.UserDto;
import com.wanrong.common.share.dto.EmailDto;
import com.wanrong.common.share.enums.EmailTypeEnum;
import com.wanrong.common.share.enums.TopicEnum;

/**
 * 类ProducerTasl.java的实现描述：TODO 类实现描述
 * 
 * @author Sunney 2016年5月6日 上午11:42:50
 */
@Component
public class ProducerTast {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    KafkaService     kafkaService;

    @Scheduled(fixedRate = 5000)
    public void taskStart() {
        EmailDto email = new EmailDto();
        email.setTitle("sunney");
        email.setAsync(false);
        email.setEmailType(EmailTypeEnum.SEND_PASSWORD);
        Map<String, String> paraMap = new HashMap<String, String>();
        paraMap.put("userName", "admin");
        paraMap.put("password", "password");
        paraMap.put("merchantId", "88888888888888888");
        paraMap.put("merchantName", "深圳市前海万融科技有限公司");
        email.setParaMap(paraMap);
        email.setReceiver("sunney888@qq.com");

        kafkaService.sendUserInfo(TopicEnum.EMAILTOPIC.getKey(), JSON.toJSONString(email));
        System.out.println("=============================:email");
    }

    /**
     * 随机获取发送邮箱
     * 
     * @return
     */
    private String getemailSender() {
        String[] sender = new String[] { "mytopic", "sunneytopic" };
        Random ra = new Random();
        int val = ra.nextInt(sender.length);
        return sender[val];
    }

}
