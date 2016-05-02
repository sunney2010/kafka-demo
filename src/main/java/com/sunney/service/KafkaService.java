/*
 * Copyright 1999-2024 Colotnet.com All right reserved. This software is the
 * confidential and proprietary information of Colotnet.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Colotnet.com.
 */
package com.sunney.service;

/**
 * 类KafkaService.java的实现描述：TODO 类实现描述 
 * @author Sunney 2016年4月30日 上午11:30:53
 */
public interface KafkaService {
    public void sendUserInfo(String topic, Object obj);
}
