package com.lvzu.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhibinglv on 2018/1/6.
 */
public class ResponseEntity {

    /**
     *  ****************************
     *  1000x ----- /api/course
     *  10001 duplicated course name
     *  10002 insert fail
     *  10003 course not found
     *  10004 revice fail
     *  10005 delete fail
     *  ****************************
     *  2000x ----- /api/login
     *  20001 telephone password error
     *  ****************************
     *  3000x ----- /api/class
     *  30001 insert fail
     *  30002 update fail
     */
    private String msg;
    private Object data;
    private int error_num;

    public static ResponseEntity success(){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setError_num(0);
        responseEntity.setData(new ArrayList<>());
        responseEntity.setMsg("success");
        return responseEntity;
    }

    public static ResponseEntity success(Object data){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setError_num(0);
        responseEntity.setData(data);
        responseEntity.setMsg("success");
        return responseEntity;
    }


    public static ResponseEntity fail(){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setError_num(1);
        responseEntity.setData(new ArrayList<>());
        responseEntity.setMsg("fail");
        return responseEntity;
    }

    public static ResponseEntity fail(String msg){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setError_num(1);
        responseEntity.setData(new ArrayList<>());
        responseEntity.setMsg(msg);
        return responseEntity;
    }

    public static ResponseEntity fail(int error_num){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setError_num(error_num);
        responseEntity.setData(new ArrayList<>());
        responseEntity.setMsg("fail");
        return responseEntity;
    }

    public static ResponseEntity fail(String msg,int error_num){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setError_num(error_num);
        responseEntity.setData(new ArrayList<>());
        responseEntity.setMsg(msg);
        return responseEntity;
    }

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
