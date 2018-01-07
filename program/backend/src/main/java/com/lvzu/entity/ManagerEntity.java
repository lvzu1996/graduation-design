package com.lvzu.entity;

/**
 * Created by zhibinglv on 2018/1/6.
 */
public class ManagerEntity {
    private Integer managerId;
    private String managerName;
    private String managerTelephone;
    private String managerPassword;
    private String managerAvatarUrl;

    public ManagerEntity(Integer managerId, String managerName, String managerTelephone, String managerPassword, String managerAvatarUrl) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.managerTelephone = managerTelephone;
        this.managerPassword = managerPassword;
        this.managerAvatarUrl = managerAvatarUrl;
    }

    public ManagerEntity() {
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerTelephone() {
        return managerTelephone;
    }

    public void setManagerTelephone(String managerTelephone) {
        this.managerTelephone = managerTelephone;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getManagerAvatarUrl() {
        return managerAvatarUrl;
    }

    public void setManagerAvatarUrl(String managerAvatarUrl) {
        this.managerAvatarUrl = managerAvatarUrl;
    }
}
