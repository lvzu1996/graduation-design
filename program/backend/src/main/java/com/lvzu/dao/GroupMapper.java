package com.lvzu.dao;

import com.lvzu.entity.GroupBannerEntity;
import com.lvzu.entity.GroupEntity;
import java.util.List;
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
    Integer setDetail(Integer groupId,String groupDetail);

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
}
