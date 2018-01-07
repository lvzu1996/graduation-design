package com.lvzu.controller.requestBody;

/**
 * Created by zhibinglv on 2018/1/6.
 */
public class LoginRequest {
    private String managerTelephone;
    private String managerPassword;

    public LoginRequest() {
    }

    public LoginRequest(String managerTelephone, String managerPassword) {
        this.managerTelephone = managerTelephone;
        this.managerPassword = managerPassword;
    }

    public String getManagerTelephone() {
        return managerTelephone;
    }

    public String getManagerPassword() {
        return managerPassword;
    }
}
