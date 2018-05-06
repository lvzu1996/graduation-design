package com.lvzu.controller;

import com.aliyuncs.exceptions.ClientException;
import com.lvzu.controller.requestBody.GroupRequest;
import com.lvzu.dao.GroupMapper;
import com.lvzu.entity.*;
import com.lvzu.utils.Message;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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

    @RequestMapping(value= "/api/group",method = RequestMethod.GET)
    public ResponseEntity GetOne(@RequestParam("groupId") Integer groupId) {
        GroupEntity group= groupMapper.getOne(groupId);
        responseEntity = new ResponseEntity();
        responseEntity = responseEntity.success(group);
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

    @RequestMapping(value ="/api/groups/detail", method = RequestMethod.PATCH)
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

    @RequestMapping(value ="/api/groups/end", method = RequestMethod.PATCH)
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

    @RequestMapping(value= "/api/group/banners",method = RequestMethod.GET)
    public ResponseEntity GetBanners(@RequestParam("groupId") Integer groupId) {
        List<GroupBannerEntity> groupBannerEntities= groupMapper.getGroupBanners(groupId);
        responseEntity = new ResponseEntity();
        responseEntity = responseEntity.success(groupBannerEntities);
        return responseEntity;
    }

    @RequestMapping(value= "/api/group/banners",method = RequestMethod.POST)
    public ResponseEntity AddBanner(@RequestBody Map<String, String> requestData) {
        responseEntity = new ResponseEntity();
        Integer groupId = Integer.valueOf(requestData.get("groupId"));
        String bannerUrl = requestData.get("bannerUrl");
        Integer influenced = groupMapper.insertGroupBanner(groupId,bannerUrl);
        if(influenced == 1){
            responseEntity = responseEntity.success();
        }else{
            responseEntity = responseEntity.fail(40007);
        }
        return responseEntity;
    }

    @RequestMapping(value= "/api/group/banners/{groupBannerId}",method = RequestMethod.DELETE)
    public ResponseEntity deleteBanner(@PathVariable("groupBannerId") Integer groupBannerId) {
        responseEntity = new ResponseEntity();
        Integer influenced = groupMapper.deleteGroupBanner(groupBannerId);
        if(influenced == 1){
            responseEntity = responseEntity.success();
        }else{
            responseEntity = responseEntity.fail(40008);
        }
        return responseEntity;
    }

    @RequestMapping(value= "/api/group/user_group",method = RequestMethod.POST)
    public ResponseEntity setUpUserGroup(@RequestBody Map<String, String> requestData) {
        responseEntity = new ResponseEntity();
        Integer userId = Integer.valueOf(requestData.get("userId"));
        Integer groupId = Integer.valueOf(requestData.get("groupId"));
        String userName = requestData.get("userName");
        String className = requestData.get("className");
        List data = groupMapper.checkGrouped(groupId,userId);
        String attendUserAvatarUrl = requestData.get("attendUserAvatarUrl");
        // 判断该用户未发起这个拼团
        if(data.isEmpty()){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String userGroupStartTime = df.format(new Date());
            Integer influenced = groupMapper.setUpUserGroup(userId,groupId,userGroupStartTime,userName,className);
            if (influenced == 1){
                Integer userGroupId = groupMapper.getUserGroupId(userId,groupId);
                //该用户自身加入拼团
                groupMapper.attendUserGroup(userGroupId,userId,userName,userId,userName,userGroupStartTime,attendUserAvatarUrl,className);
                responseEntity = responseEntity.success(userGroupId);
            }else{
                responseEntity = responseEntity.fail(40010);
            }
        }else {
            responseEntity = responseEntity.fail(40009);
        }

        return responseEntity;
    }

    @RequestMapping(value= "/api/group/user_group",method = RequestMethod.GET)
    public ResponseEntity getUserGroup(@RequestParam("userGroupId") Integer userGroupId){
        responseEntity = new ResponseEntity();
        List<UserGroupMemberEntity> UserGroupMemberEntityList = groupMapper.getUserGroupMember(userGroupId);
        return responseEntity.success(UserGroupMemberEntityList);
    }

    @RequestMapping(value= "/api/group/user_group_member",method = RequestMethod.POST)
    public ResponseEntity attendUserGroup(@RequestBody Map<String, String> requestData) {
        responseEntity = new ResponseEntity();
        Integer attendUserId = Integer.valueOf(requestData.get("attendUserId"));
        Integer userGroupId = Integer.valueOf(requestData.get("userGroupId"));
        String attendUserAvatarUrl = requestData.get("attendUserAvatarUrl");
        String attendUserName = requestData.get("attendUserName");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String attendTime = df.format(new Date());
        //判断该拼团是否已经加入
        if(groupMapper.existAttender(userGroupId,attendUserId) != null){
            return ResponseEntity.fail(40012);
        }
        String userName = groupMapper.getCreatorId(userGroupId).get(0).get("userName").toString();
        Integer userId = Integer.valueOf(groupMapper.getCreatorId(userGroupId).get(0).get("userId").toString());
        String className = groupMapper.getCreatorId(userGroupId).get(0).get("className").toString();
        Integer influenced = groupMapper.attendUserGroup(userGroupId,userId,userName,attendUserId,attendUserName,attendTime,attendUserAvatarUrl,className);
        Message message = new Message();
        try {
            message.sendSms(groupMapper.getUserTelephone(userId),2);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        if (influenced == 1){
            responseEntity = responseEntity.success();
        }else {
            responseEntity = responseEntity.fail(40011);
        }
        return responseEntity;
    }


}
