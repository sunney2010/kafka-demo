/*
 * Copyright 1999-2024 Colotnet.com All right reserved. This software is the
 * confidential and proprietary information of Colotnet.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Colotnet.com.
 */
package com.sunney.service;

import java.util.Date;
import java.util.List;

/**
 * 类UserDto.java的实现描述：TODO 类实现描述 
 * @author Sunney 2016年4月30日 上午10:53:54
 */
public class UserDto {
    private Integer userId;
    private String userName;
    private List<Long> userList;
    private Date gmtCeate;
    
    /**
     * @return the userId
     */
    public Integer getUserId() {
        return userId;
    }
    
    /**
     * @param userId the userId to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * @return the userList
     */
    public List<Long> getUserList() {
        return userList;
    }
    
    /**
     * @param userList the userList to set
     */
    public void setUserList(List<Long> userList) {
        this.userList = userList;
    }
    
    /**
     * @return the gmtCeate
     */
    public Date getGmtCeate() {
        return gmtCeate;
    }
    
    /**
     * @param gmtCeate the gmtCeate to set
     */
    public void setGmtCeate(Date gmtCeate) {
        this.gmtCeate = gmtCeate;
    }
    

}
