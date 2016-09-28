/*
 * Copyright 1999-2024 Colotnet.com All right reserved. This software is the confidential and proprietary information of
 * Colotnet.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with Colotnet.com.
 */
package com.sunney.service;

import java.util.Map;

/**
 * 类KafkaConsumerService.java的实现描述：TODO 类实现描述
 * 
 * @author Sunney 2016年5月6日 上午11:33:46
 */
public interface KafkaConsumerService {

    public void processMessage(Map<String, Map<Integer, String>> msgs);

}
