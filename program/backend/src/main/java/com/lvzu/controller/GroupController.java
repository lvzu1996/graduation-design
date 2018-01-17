package com.lvzu.controller;

import com.lvzu.controller.requestBody.GroupRequest;
import com.lvzu.dao.CourseMapper;
import com.lvzu.dao.GroupMapper;
import com.lvzu.entity.CourseEntity;
import com.lvzu.entity.GroupEntity;
import com.lvzu.entity.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.acl.Group;
import java.util.List;
import java.util.Map;


/**
 * Created by zhibinglv on 2018/1/17.
 */
@RestController
public class GroupController {

    @Resource
    private GroupMapper groupMapper;

    private ResponseEntity responseEntity;
    @RequestMapping(value= "/api/groups",method = RequestMethod.GET)
    public ResponseEntity Get() {
        List<GroupEntity> groups= groupMapper.getAll();
        responseEntity = new ResponseEntity();
        responseEntity = responseEntity.success(groups);
        return responseEntity;
    }

    @RequestMapping(value ="/api/groups", method = RequestMethod.POST)
    public ResponseEntity Add(@RequestBody GroupRequest groupRequest) {
        responseEntity = new ResponseEntity();
        Integer influenced = 0;
        String groupName = groupRequest.getGroupName();
        if(groupMapper.exist(groupName)!=null){
            responseEntity = responseEntity.fail(40001);
            return responseEntity;
        }
        if(groupRequest.getGroupType() == 101){
            groupRequest.setGroupPayCount(0);
            GroupEntity groupEntity = new GroupEntity(groupRequest);
            influenced = groupMapper.insert(groupEntity);
        }else if(groupRequest.getGroupType() == 102){
            groupRequest.setGroupFavourablePrice(0);
            GroupEntity groupEntity = new GroupEntity(groupRequest);
            influenced = groupMapper.insert(groupEntity);
        }
        if(influenced == 1){
            responseEntity = responseEntity.success();
        }else{
            responseEntity = responseEntity.fail(40002);
        }
        return responseEntity;
    }

    @RequestMapping(value ="/api/groups", method = RequestMethod.PATCH)
    public ResponseEntity Revice(@RequestBody GroupEntity groupEntity) {
        responseEntity = new ResponseEntity();
        Integer influenced = groupMapper.update(groupEntity);
        if(influenced == 1){
            responseEntity = responseEntity.success();
        }else {
            responseEntity = responseEntity.fail(40002);
        }
        return responseEntity;
    }



}
