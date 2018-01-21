package com.lvzu.controller.requestBody;

import java.sql.Date;

/**
 * Created by zhibinglv on 2018/1/17.
 */
public class GroupRequest {
    private Integer classId;
    private String groupName;
    private Date groupStartTime;
    private Date groupEndTime;
    private String className;
    private Integer classPrice;
    private Integer groupCount;
    private Integer groupType;
    private Integer groupFavourablePrice;
    private Integer groupPayCount;
    private String groupAvatarUrl;
    private String groupIntro;

    public GroupRequest(Integer classId, String groupName, Date groupStartTime, Date groupEndTime, String className, Integer classPrice, Integer groupCount, Integer groupType, Integer groupFavourablePrice, Integer groupPayCount, String groupAvatarUrl, String groupIntro) {
        this.classId = classId;
        this.groupName = groupName;
        this.groupStartTime = groupStartTime;
        this.groupEndTime = groupEndTime;
        this.className = className;
        this.classPrice = classPrice;
        this.groupCount = groupCount;
        this.groupType = groupType;
        this.groupFavourablePrice = groupFavourablePrice;
        this.groupPayCount = groupPayCount;
        this.groupAvatarUrl = groupAvatarUrl;
        this.groupIntro = groupIntro;
    }

    public String getGroupIntro() {

        return groupIntro;
    }

    public void setGroupIntro(String groupIntro) {
        this.groupIntro = groupIntro;
    }

    public String getGroupAvatarUrl() {
        return groupAvatarUrl;
    }

    public void setGroupAvatarUrl(String groupAvatarUrl) {
        this.groupAvatarUrl = groupAvatarUrl;
    }

    public GroupRequest(Integer classId, String groupName, Date groupStartTime, Date groupEndTime, String className, Integer classPrice, Integer groupCount, Integer groupType, Integer groupFavourablePrice, Integer groupPayCount, String groupAvatarUrl) {

        this.classId = classId;
        this.groupName = groupName;
        this.groupStartTime = groupStartTime;
        this.groupEndTime = groupEndTime;
        this.className = className;
        this.classPrice = classPrice;
        this.groupCount = groupCount;
        this.groupType = groupType;
        this.groupFavourablePrice = groupFavourablePrice;
        this.groupPayCount = groupPayCount;
        this.groupAvatarUrl = groupAvatarUrl;
    }

    public GroupRequest(Integer classId, String groupName, Date groupStartTime, Date groupEndTime, String className, Integer classPrice, Integer groupCount, Integer groupType, Integer groupFavourablePrice, Integer groupPayCount) {
        this.classId = classId;
        this.groupName = groupName;
        this.groupStartTime = groupStartTime;
        this.groupEndTime = groupEndTime;
        this.className = className;
        this.classPrice = classPrice;
        this.groupCount = groupCount;
        this.groupType = groupType;
        this.groupFavourablePrice = groupFavourablePrice;
        this.groupPayCount = groupPayCount;
    }

    public Integer getClassPrice() {

        return classPrice;
    }

    public void setClassPrice(Integer classPrice) {
        this.classPrice = classPrice;
    }

    public GroupRequest() {
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
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
