package com.lvzu.entity;

import java.sql.Date;

/**
 * Created by zhibinglv on 2018/1/27.
 */
public class UserGroupEntity {
    private Integer userGroupId;
    private Integer userId;
    private String userName;
    private String className;
    private Integer groupId;
    private String groupType;
    private Integer groupFavourablePrice;
    private Integer groupPayCount;
    private Date userGroupStartTime;
    private Date userGroupEndTime;
    private Integer groupCount;
    private String groupEndType;

    public UserGroupEntity(Date userGroupStartTime, Integer groupId, Integer userId) {
        this.userGroupStartTime = userGroupStartTime;
        this.groupId = groupId;
        this.userId = userId;
    }

    public Integer getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public Integer getGroupFavourablePrice() {
        return groupFavourablePrice;
    }

    public void setGroupFavourablePrice(Integer groupFavourablePrice) {
        this.groupFavourablePrice = groupFavourablePrice;
    }

    public Integer getGroupPayCount() {
        return groupPayCount;
    }

    public void setGroupPayCount(Integer groupPayCount) {
        this.groupPayCount = groupPayCount;
    }

    public Date getUserGroupStartTime() {
        return userGroupStartTime;
    }

    public void setUserGroupStartTime(Date userGroupStartTime) {
        this.userGroupStartTime = userGroupStartTime;
    }

    public Date getUserGroupEndTime() {
        return userGroupEndTime;
    }

    public void setUserGroupEndTime(Date userGroupEndTime) {
        this.userGroupEndTime = userGroupEndTime;
    }

    public Integer getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(Integer groupCount) {
        this.groupCount = groupCount;
    }

    public String getGroupEndType() {
        return groupEndType;
    }

    public void setGroupEndType(String groupEndType) {
        this.groupEndType = groupEndType;
    }

    public UserGroupEntity(Integer userGroupId, Integer userId, String userName, String className, Integer groupId, String groupType, Integer groupFavourablePrice, Integer groupPayCount, Date userGroupStartTime, Date userGroupEndTime, Integer groupCount, String groupEndType) {

        this.userGroupId = userGroupId;
        this.userId = userId;
        this.userName = userName;
        this.className = className;
        this.groupId = groupId;
        this.groupType = groupType;
        this.groupFavourablePrice = groupFavourablePrice;
        this.groupPayCount = groupPayCount;
        this.userGroupStartTime = userGroupStartTime;
        this.userGroupEndTime = userGroupEndTime;
        this.groupCount = groupCount;
        this.groupEndType = groupEndType;
    }
}
