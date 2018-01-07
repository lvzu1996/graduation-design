package com.lvzu.controller;

import com.lvzu.controller.requestBody.LoginRequest;
import com.lvzu.dao.ManagerMapper;
import com.lvzu.entity.ClassEntity;
import com.lvzu.entity.ManagerEntity;
import com.lvzu.entity.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhibinglv on 2018/1/6.
 */
@RestController
public class LoginController {

    @Resource
    private ManagerMapper managerMapper;

    private ResponseEntity responseEntity;

    @RequestMapping(value ="/api/login", method = RequestMethod.POST)
    public ResponseEntity Login(@RequestBody LoginRequest loginRequest,HttpSession session,HttpServletResponse response) {
        String managerTelephone =  loginRequest.getManagerTelephone();
        ManagerEntity managerEntity = managerMapper.getOne(managerTelephone);
        responseEntity = new ResponseEntity();
        if(loginRequest.getManagerPassword().equals(managerEntity.getManagerPassword())){
            session.setAttribute("managerTelephone",managerTelephone);
            Cookie cookie = new Cookie("JSESSIONID",session.getId());
            cookie.setMaxAge(30 * 60);// 设置为30min
            cookie.setPath("/");
            response.addCookie(cookie);
            response.setHeader("Access-Control-Allow-Credentials","true");
            response.setHeader("Access-Control-Allow-Origin","http://localhost:8084");
            Map<String,String> dataMap = new HashMap<>();
            dataMap.put("managerAvatarUrl",managerEntity.getManagerAvatarUrl());
            dataMap.put("managerName",managerEntity.getManagerName());
;           responseEntity.setMsg("success");
            responseEntity.setData(dataMap);
            responseEntity.setError_num(0);
            return responseEntity;
        }else {
            responseEntity.setMsg("error");
            responseEntity.setData(new ArrayList());
            responseEntity.setError_num(1);
            return responseEntity;
        }
    }
}
