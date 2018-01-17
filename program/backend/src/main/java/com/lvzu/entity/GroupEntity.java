package com.lvzu.entity;

import com.lvzu.controller.requestBody.GroupRequest;

import java.sql.Date;

/**
 * Created by zhibinglv on 2018/1/17.
 */
public class GroupEntity {
    private Integer groupId;
    private Integer classId;
    private Integer classPrice;
    private String groupName;
    private Date groupStartTime;
    private Date groupEndTime;
    private String className;
    private Integer groupCount;
    private Integer groupType;
    private Integer groupFavourablePrice;
    private Integer groupPayCount;

    public GroupEntity() {
    }

    public GroupEntity(GroupRequest groupRequest) {
        this.classId = groupRequest.getClassId();
        this.classPrice = groupRequest.getClassPrice();
        this.groupName = groupRequest.getGroupName();
        this.groupStartTime = groupRequest.getGroupStartTime();
        this.groupEndTime = groupRequest.getGroupEndTime();
        this.className = groupRequest.getClassName();
        this.groupCount = groupRequest.getGroupCount();
        this.groupType = groupRequest.getGroupType();
        this.groupFavourablePrice = groupRequest.getGroupFavourablePrice();
        this.groupPayCount = groupRequest.getGroupPayCount();
    }

    public GroupEntity(Integer classId, Integer classPrice, String groupName, Date groupStartTime, Date groupEndTime, String className, Integer groupCount, Integer groupType, Integer groupFavourablePrice, Integer groupPayCount) {

        this.classId = classId;
        this.classPrice = classPrice;
        this.groupName = groupName;
        this.groupStartTime = groupStartTime;
        this.groupEndTime = groupEndTime;
        this.className = className;
        this.groupCount = groupCount;
        this.groupType = groupType;
        this.groupFavourablePrice = groupFavourablePrice;
        this.groupPayCount = groupPayCount;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getClassPrice() {
        return classPrice;
    }

    public void setClassPrice(Integer classPrice) {
        this.classPrice = classPrice;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getGroupStartTime() {
        return groupStartTime;
    }

    public void setGroupStartTime(Date groupStartTime) {
        this.groupStartTime = groupStartTime;
    }

    public Date getGroupEndTime() {
        return groupEndTime;
    }

    public void setGroupEndTime(Date groupEndTime) {
        this.groupEndTime = groupEndTime;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(Integer groupCount) {
        this.groupCount = groupCount;
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
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
}
