package com.lvzu.entity;

public class GroupBannerEntity {
    private Integer groupBannerId;
    private Integer groupId;
    private String groupBannerUrl;


    public Integer getGroupBannerId() {
        return groupBannerId;
    }

    public void setGroupBannerId(Integer groupBannerId) {
        this.groupBannerId = groupBannerId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupBannerUrl() {
        return groupBannerUrl;
    }

    public void setGroupBannerUrl(String groupBannerUrl) {
        this.groupBannerUrl = groupBannerUrl;
    }

    public GroupBannerEntity(Integer groupBannerId, Integer groupId, String groupBannerUrl) {

        this.groupBannerId = groupBannerId;
        this.groupId = groupId;
        this.groupBannerUrl = groupBannerUrl;
    }
}
