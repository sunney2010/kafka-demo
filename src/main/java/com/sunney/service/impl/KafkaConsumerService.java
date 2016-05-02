/*
 * Copyright 1999-2024 Colotnet.com All right reserved. This software is the confidential and proprietary information of
 * Colotnet.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Colotnet.com.
 */
package com.sunney.service.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.sunney.service.UserDto;

/**
 * 类KafkaConsumerService.java的实现描述：TODO 类实现描述
 * 
 * @author Sunney 2016年4月30日 上午11:46:14
 */
public class KafkaConsumerService {

    static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    public void processMessage(Map<String, Map<Integer, String>> msgs) {
        logger.info("===============================================processMessage===============");
        for (Map.Entry<String, Map<Integer, String>> entry : msgs.entrySet()) {
            logger.info("============Topic:" + entry.getKey());
            LinkedHashMap<Integer, String> messages = (LinkedHashMap<Integer, String>) entry.getValue();
            Set<Integer> keys = messages.keySet();
            for (Integer i : keys)
                logger.info("======Partition:" + i);
            Collection<String> values = messages.values();
            for (Iterator<String> iterator = values.iterator(); iterator.hasNext();) {
                String message = "["+iterator.next()+"]";
                logger.info("=====message:" + message);
                List<UserDto> userList = JSON.parseArray(message, UserDto.class);  
                logger.info("=====userList.size:" + userList.size());

            }

        }
    }

}
