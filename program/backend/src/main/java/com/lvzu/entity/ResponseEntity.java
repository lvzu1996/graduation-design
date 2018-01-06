package com.lvzu.entity;

import java.util.List;

/**
 * Created by zhibinglv on 2018/1/6.
 */
public class ResponseEntity {
    private String msg;
    private Object data;
    private int error_num;

    public ResponseEntity() {
    }

    public ResponseEntity(String msg, Object data, int error_num) {
        this.msg = msg;
        this.data = data;
        this.error_num = error_num;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setError_num(int error_num) {
        this.error_num = error_num;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public int getError_num() {
        return error_num;
    }
}
