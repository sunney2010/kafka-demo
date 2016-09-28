/*
 * Copyright 1999-2024 Colotnet.com All right reserved. This software is the confidential and proprietary information of
 * Colotnet.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Colotnet.com.
 */
package com.sunney.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.kafka.support.KafkaHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import com.sunney.service.KafkaService;

/**
 * 类KafkaServiceImpl.java的实现描述：发消息实现类
 * 
 * @author Sunney 2016年4月30日 上午11:31:13
 */
@Service("kafkaService")
public class KafkaServiceImpl implements KafkaService {

    // 默认4个分区
    private static final int numPartitions = 4;
    @Autowired
    @Qualifier("kafkaTopicTest")
    MessageChannel           channel;

    public void sendUserInfo(String topic, Object obj) {
        // 获取messageKey
        String messageKey = String.valueOf(obj.hashCode());
        // 获取分区号
        int partitionId = partition(messageKey, numPartitions);
        channel.send(MessageBuilder.withPayload(obj).setHeader(KafkaHeaders.TOPIC,
                                                               topic).setHeader(KafkaHeaders.MESSAGE_KEY,
                                                                                messageKey).setHeader(KafkaHeaders.PARTITION_ID,
                                                                                                      partitionId).build());
    }

    /**
     * 获取分区号
     * 
     * @param key KEY
     * @param numPartitions 分区数
     * @return
     */
    private int partition(Object key, int numPartitions) {
        try {
            long partitionNum = Long.parseLong((String) key);
            return (int) Math.abs(partitionNum % numPartitions);
        } catch (Exception e) {
            return Math.abs(key.hashCode() % numPartitions);
        }
    }

}
