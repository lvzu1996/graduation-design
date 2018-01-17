package com.lvzu.dao;

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

    @Insert("INSERT INTO classgroup(classId,groupName,groupStartTime,groupEndTime,classPrice,className,groupCount,groupType,groupFavourablePrice,groupPayCount) VALUES(#{classId},#{groupName},#{groupStartTime},#{groupEndTime},#{classPrice},#{className},#{groupCount},#{groupType},#{groupFavourablePrice},#{groupPayCount})")
    Integer insert(GroupEntity groupEntity);

    @Update("Update classgroup set className=#{groupEntity.className},groupName=#{groupEntity.groupName},groupStartTime=#{groupEntity.groupStartTime},groupEndTime=#{groupEntity.groupEndTime},classPrice=#{groupEntity.classPrice},classStartTime=#{groupEntity.className},classEndTime=#{groupEntity.groupCount},classPrice=#{groupEntity.groupType},groupFavourablePrice=#{groupEntity.groupFavourablePrice},groupPayCount=#(groupEntity.groupPayCount) WHERE groupId =#{groupEntity.groupId}")
    Integer update(@Param("groupEntity") GroupEntity groupEntity);

    @Delete("DELETE FROM classgroup WHERE groupId =#{id}")
    void delete(Integer id);
}
