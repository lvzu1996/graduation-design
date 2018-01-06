package com.lvzu.controller;

import com.lvzu.dao.ManagerMapper;
import com.lvzu.entity.ClassEntity;
import com.lvzu.entity.ManagerEntity;
import com.lvzu.entity.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhibinglv on 2018/1/6.
 */
@RestController
public class LoginController {

    @Resource
    private ManagerMapper managerMapper;
    private ResponseEntity response;

    @RequestMapping(value ="/login", method = RequestMethod.POST)
    public ResponseEntity Login(HttpServletRequest request) {
        System.out.println(request.getSession());
        String managerTelephone = request.getParameter("managerTelephone");
        String managerPassword = request.getParameter("managerPassword");
        ManagerEntity managerEntity = managerMapper.getOne(managerTelephone);
        System.out.println("************************");
        System.out.println(managerPassword);
        System.out.println(managerEntity.getManagerPassword());
        System.out.println("************************");
        if(managerPassword == managerEntity.getManagerPassword()){
            response.setMsg("success");
            response.setData(new ArrayList());
            response.setError_num(0);
            return response;
        }else {
            response.setMsg("error");
            response.setData(new ArrayList());
            response.setError_num(1);
            return response;
        }
    }
}
