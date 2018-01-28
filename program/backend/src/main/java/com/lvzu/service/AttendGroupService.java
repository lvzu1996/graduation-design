package com.lvzu.service;

import com.lvzu.dao.GroupMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhibinglv on 2018/1/28.
 */
@Service
public class AttendGroupService {

    @Resource
    private GroupMapper groupMapper;

    private Integer userGroupId;
    private String userName;
    private Integer attendUserId;
    private String attendUserName;
    private String attendTime;


    public Integer getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAttendUserId() {
        return attendUserId;
    }

    public void setAttendUserId(Integer attendUserId) {
        this.attendUserId = attendUserId;
    }

    public String getAttendUserName() {
        return attendUserName;
    }

    public void setAttendUserName(String attendUserName) {
        this.attendUserName = attendUserName;
    }

    public String getAttendTime() {
        return attendTime;
    }

    public void setAttendTime(String attendTime) {
        this.attendTime = attendTime;
    }

    public AttendGroupService() {

    }

    public AttendGroupService(Integer userGroupId, String userName, Integer attendUserId, String attendUserName, String attendTime) {

        this.userGroupId = userGroupId;
        this.userName = userName;
        this.attendUserId = attendUserId;
        this.attendUserName = attendUserName;
        this.attendTime = attendTime;
    }
}
