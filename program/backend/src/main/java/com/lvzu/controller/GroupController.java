package com.lvzu.controller;

import com.lvzu.controller.requestBody.GroupRequest;
import com.lvzu.dao.GroupMapper;
import com.lvzu.entity.GroupBannerEntity;
import com.lvzu.entity.GroupEntity;
import com.lvzu.entity.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

}
