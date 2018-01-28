package com.lvzu.controller;

import com.alibaba.fastjson.JSON;
import com.lvzu.controller.requestBody.LoginRequest;
import com.lvzu.dao.LoginMapper;
import com.lvzu.dao.TestMapper;
import com.lvzu.entity.ManagerEntity;
import com.lvzu.entity.ResponseEntity;
import com.lvzu.entity.UserGroupEntity;
import com.lvzu.utils.HttpRequestUtil;
import com.lvzu.utils.SHA1;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by zhibinglv on 2018/1/6.
 */
@RestController
public class LoginController {

    private final long TEN_MINUTES = 1800000;

    @Resource
    private LoginMapper loginMapper;

    @Resource
    private TestMapper testMapper;

    private com.lvzu.entity.ResponseEntity responseEntity;

    private final String appId = "wx541c9f9e0536e17b";
    private final String appSecrete = "aadb4ea2f08ebb7541fd11471a313fed";

    @RequestMapping(value ="/api/login", method = RequestMethod.POST)
    public ResponseEntity Login(@RequestBody LoginRequest loginRequest, HttpSession session, HttpServletResponse response) {
        String managerTelephone =  loginRequest.getManagerTelephone();
        ManagerEntity managerEntity = loginMapper.getOne(managerTelephone);
        responseEntity = new com.lvzu.entity.ResponseEntity();
        if(loginRequest.getManagerPassword().equals(managerEntity.getManagerPassword())){
            session.setAttribute("managerTelephone",managerTelephone);
            Cookie cookie = new Cookie("JSESSIONID",session.getId());
            cookie.setMaxAge(30 * 60);// 设置为30min
            cookie.setPath("/");
            response.addCookie(cookie);
//            response.setHeader("Access-Control-Allow-Credentials","true");
//            response.setHeader("Access-Control-Allow-Origin","http://localhost:8081");
            Map<String,String> dataMap = new HashMap<>();
            dataMap.put("managerAvatarUrl",managerEntity.getManagerAvatarUrl());
            dataMap.put("managerName",managerEntity.getManagerName());
            responseEntity =responseEntity.success(dataMap);
            return responseEntity;
        }else {
            responseEntity=responseEntity.fail(20001);
            return responseEntity;
        }
    }

    @RequestMapping(value ="/api/wxlogin", method = RequestMethod.POST)
    public String WxLogin(@RequestBody Map<String, String> requestData){
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret=" + appSecrete + "&grant_type=authorization_code&js_code=";
        url += requestData.get("code");
        String responseStr = HttpRequestUtil.sendGet(url, null);
        Map<String,String> maps = (Map) JSON.parse(responseStr);
        String session_key = maps.get("session_key");
        String userOpenid = maps.get("openid");
        String userId = loginMapper.existUser(userOpenid);
        maps.put("userId",userId);
        responseStr = JSON.toJSONString(maps);
        long expire = new Date().getTime()+TEN_MINUTES;
        if(loginMapper.exist(session_key) != null){
            loginMapper.update(session_key,expire);
        }else {
            loginMapper.insert(session_key,expire);
        }
        return responseStr;
    }

    @RequestMapping(value ="/api/user", method = RequestMethod.POST)
    public ResponseEntity Register(@RequestBody Map<String, String> requestData){
        String userTelephone = requestData.get("userTelephone");
        String userOpenid = requestData.get("userOpenid");
        String userName = requestData.get("userName");
        String userGender = requestData.get("userGender");
        Integer influened = loginMapper.register(userTelephone,userOpenid,userName,userGender);
        if (influened == 1){
            responseEntity = responseEntity.success();
        }else {
            responseEntity = responseEntity.fail(20002);
        }
        return responseEntity;
    }

    @RequestMapping(value ="/api/user/judge", method = RequestMethod.POST)
    public ResponseEntity UserJudge(@RequestBody Map<String, String> requestData){
        String userOpenid = requestData.get("userOpenid");
        if(loginMapper.existUser(userOpenid) != null){
            responseEntity = responseEntity.success();
        }else {
            responseEntity = responseEntity.fail();
        }
        return responseEntity;
    }

    @RequestMapping(value ="/api/test", method = RequestMethod.GET)
    public Object Test(){
       List<Map> temp = testMapper.test(7);
        return temp.get(0).get("userId");
    }
}
