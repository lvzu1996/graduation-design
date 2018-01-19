package com.lvzu.controller;

import com.lvzu.controller.requestBody.GroupRequest;
import com.lvzu.dao.CourseMapper;
import com.lvzu.dao.GroupMapper;
import com.lvzu.entity.CourseEntity;
import com.lvzu.entity.GroupEntity;
import com.lvzu.entity.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if(groupRequest.getGroupType() == 1){
            groupRequest.setGroupPayCount(0);
            GroupEntity groupEntity = new GroupEntity(groupRequest);
            influenced = groupMapper.insert(groupEntity);
        }else if(groupRequest.getGroupType() == 2){
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

    @RequestMapping(value ="/api/groups/groupDetail", method = RequestMethod.PATCH)
    public ResponseEntity ReviceDetail(@RequestBody Map<String, String> requestData) {
        responseEntity = new ResponseEntity();
        Integer groupId = Integer.valueOf(requestData.get("groupId"));
        String groupDetail = requestData.get("groupDetail");
        Integer influenced = groupMapper.setDetail(groupId,groupDetail);
        if(influenced == 1){
            responseEntity = responseEntity.success();
        }else{
            responseEntity = responseEntity.fail(40003);
        }
        return responseEntity;
    }

    @RequestMapping(value ="/api/groups/groupSetEnd", method = RequestMethod.PATCH)
    public ResponseEntity SetEnd(@RequestBody Map<String, String> requestData) {
        responseEntity = new ResponseEntity();
        Integer groupId = Integer.valueOf(requestData.get("groupId"));
        Integer influenced = groupMapper.setEnd(groupId);
        if(influenced == 1){
            responseEntity = responseEntity.success();
        }else{
            responseEntity = responseEntity.fail(40004);
        }
        return responseEntity;
    }

    @RequestMapping(value ="/api/groups/{groupId}", method = RequestMethod.DELETE)
    public ResponseEntity Delete(@PathVariable("groupId") Integer groupId) {
        responseEntity = new ResponseEntity();
        if(groupMapper.existGroupID(groupId) != null){
            Integer influenced = groupMapper.delete(groupId);
            if(influenced == 1){
                responseEntity = responseEntity.success();
            }else{
                responseEntity = responseEntity.fail(40005);
            }
        }else{
            responseEntity = responseEntity.fail(40006);
        }
        return responseEntity;
    }



}
