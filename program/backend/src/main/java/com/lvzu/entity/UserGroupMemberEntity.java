package com.lvzu.entity;

/**
 * Created by zhibinglv on 2018/1/28.
 */
public class UserGroupMemberEntity {
    private Integer groupMemberId;
    private Integer userGroupId;
    private String userName;
    private Integer userId;
    private Integer attendUserId;
    private String attendUserName;
    private String attendTime;
    private String attendUserAvatarUrl;
    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public UserGroupMemberEntity(Integer groupMemberId, Integer userGroupId, String userName, Integer userId, Integer attendUserId, String attendUserName, String attendTime, String attendUserAvatarUrl, String className) {

        this.groupMemberId = groupMemberId;
        this.userGroupId = userGroupId;
        this.userName = userName;
        this.userId = userId;
        this.attendUserId = attendUserId;
        this.attendUserName = attendUserName;
        this.attendTime = attendTime;
        this.attendUserAvatarUrl = attendUserAvatarUrl;
        this.className = className;
    }

    public String getAttendUserAvatarUrl() {
        return attendUserAvatarUrl;
    }

    public void setAttendUserAvatarUrl(String attendUserAvatarUrl) {
        this.attendUserAvatarUrl = attendUserAvatarUrl;
    }

    public UserGroupMemberEntity(Integer groupMemberId, Integer userGroupId, String userName, Integer userId, Integer attendUserId, String attendUserName, String attendTime, String attendUserAvatarUrl) {

        this.groupMemberId = groupMemberId;
        this.userGroupId = userGroupId;
        this.userName = userName;
        this.userId = userId;
        this.attendUserId = attendUserId;
        this.attendUserName = attendUserName;
        this.attendTime = attendTime;
        this.attendUserAvatarUrl = attendUserAvatarUrl;
    }

    public UserGroupMemberEntity(Integer userGroupId, String userName, String attendUserName, Integer attendUserId, String attendTime) {
        this.userGroupId = userGroupId;
        this.userName = userName;
        this.attendUserName = attendUserName;
        this.attendUserId = attendUserId;
        this.attendTime = attendTime;
    }

    public UserGroupMemberEntity(Integer groupMemberId, Integer userGroupId, String userName, Integer userId, Integer attendUserId, String attendUserName, String attendTime) {

        this.groupMemberId = groupMemberId;
        this.userGroupId = userGroupId;
        this.userName = userName;
        this.userId = userId;
        this.attendUserId = attendUserId;
        this.attendUserName = attendUserName;
        this.attendTime = attendTime;
    }

    public UserGroupMemberEntity() {
    }

    public Integer getGroupMemberId() {
        return groupMemberId;
    }

    public void setGroupMemberId(Integer groupMemberId) {
        this.groupMemberId = groupMemberId;
    }

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}
