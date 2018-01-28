package com.lvzu.dao;

import com.lvzu.entity.GroupBannerEntity;
import com.lvzu.entity.GroupEntity;
import java.util.List;
import java.util.Map;

import com.lvzu.entity.UserGroupEntity;
import com.lvzu.entity.UserGroupMemberEntity;
import org.apache.ibatis.annotations.*;

/**
 * Created by zhibinglv on 2018/1/17.
 */
public interface GroupMapper {
    @Select("SELECT * FROM classgroup")
    List<GroupEntity> getAll();

    @Select("SELECT * FROM classgroup WHERE groupId = #{id}")
    GroupEntity getOne(Integer id);

    @Select("SELECT * FROM classgroup WHERE groupName = #{groupName}")
    Integer exist(String groupName);

    @Select("SELECT * FROM classgroup WHERE groupId = #{groupId}")
    Integer existGroupID(Integer groupId);

    @Insert("INSERT INTO classgroup(classId,groupName,groupStartTime,groupEndTime,classPrice,className,groupCount,groupType,groupFavourablePrice,groupPayCount,groupAvatarUrl,groupIntro) VALUES(#{classId},#{groupName},#{groupStartTime},#{groupEndTime},#{classPrice},#{className},#{groupCount},#{groupType},#{groupFavourablePrice},#{groupPayCount},#{groupAvatarUrl},#{groupIntro})")
    Integer insert(GroupEntity groupEntity);

    @Update("Update classgroup set groupDetail=#{groupDetail} WHERE groupId =#{groupId}")
    Integer setDetail(@Param("groupId") Integer groupId,@Param("groupDetail") String groupDetail);

    @Update("Update classgroup set groupIsEnd=1 WHERE groupId =#{groupId}")
    Integer setEnd(@Param("groupId") Integer groupId);

    @Update("Update classgroup set className=#{groupEntity.className},groupName=#{groupEntity.groupName},groupStartTime=#{groupEntity.groupStartTime},groupEndTime=#{groupEntity.groupEndTime},classPrice=#{groupEntity.classPrice},classStartTime=#{groupEntity.className},classEndTime=#{groupEntity.groupCount},classPrice=#{groupEntity.groupType},groupFavourablePrice=#{groupEntity.groupFavourablePrice},groupPayCount=#(groupEntity.groupPayCount) WHERE groupId =#{groupEntity.groupId}")
    Integer update(@Param("groupEntity") GroupEntity groupEntity);

    @Delete("DELETE FROM classgroup WHERE groupId =#{id}")
    Integer delete(Integer id);

    @Insert("INSERT INTO group_banner(groupId,bannerUrl) VALUES(#{groupId},#{bannerUrl})")
    Integer insertGroupBanner(@Param("groupId") Integer groupId,@Param("bannerUrl") String bannerUrl);

    @Select("SELECT * FROM group_banner where groupId = #{groupId}")
    List<GroupBannerEntity> getGroupBanners(Integer groupId);

    @Delete("DELETE FROM group_banner WHERE groupBannerId =#{groupBannerId}")
    Integer deleteGroupBanner(Integer groupBannerId);

    @Select("SELECT * from user_group where groupId=#{groupId} and userId=#{userId}")
    List<Map<String,String>> checkGrouped(@Param("groupId") Integer groupId,@Param("userId") Integer userId);

    @Insert("INSERT INTO user_group(userId,groupId,userGroupStartTime,userName,className) values(#{userId},#{groupId},#{userGroupStartTime},#{userName},#{className})")
    @Options(useGeneratedKeys=true, keyProperty="userId")
    Integer setUpUserGroup(@Param("userId") Integer userId,@Param("groupId") Integer groupId,@Param("userGroupStartTime") String userGroupStartTime,@Param("userName") String userName,@Param("className") String className);

    @Select("SELECT * FROM user_group_member where userGroupId=#{userGroupId}")
    List<UserGroupMemberEntity> getUserGroupMember(@Param("userGroupId") Integer userGroupId);

    @Select("SELECT * FROM user_group where userId=#{userId} and groupId = #{groupId}")
    Integer getUserGroupId(@Param("userId") Integer userId,@Param("groupId") Integer groupId);

    @Insert("INSERT INTO user_group_member(userGroupId,userId,userName,attendUserId,attendUserName,attendTime,attendUserAvatarUrl,className) VALUES(#{userGroupId},#{userId},#{userName},#{attendUserId},#{attenUserName},#{attendTime},#{attendUserAvatarUrl},#{className})")
    Integer attendUserGroup(@Param("userGroupId") Integer userGroupId,@Param("userId") Integer userId,@Param("userName") String userName,@Param("attendUserId") Integer attendUserId,@Param("attenUserName") String attenUserName,@Param("attendTime") String attendUser,@Param("attendUserAvatarUrl") String attendUserAvatarUrl,@Param("className") String className);

    @Select("SELECT * FROM user_group where userGroupId=#{userGroupId}")
    List<Map> getCreatorId(@Param("userGroupId") Integer userGroupId);

    @Select("SELECT * FROM user_group_member where userGroupId=#{userGroupId} and attendUserId=#{attendUserId}")
    Integer existAttender(@Param("userGroupId") Integer userGroupId,@Param("attendUserId") Integer attendUserId);
}
