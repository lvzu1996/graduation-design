package com.lvzu.dao;

import com.lvzu.entity.ClassEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by zhibinglv on 2018/1/5.
 */
public interface ClassMapper {

    @Select("SELECT * FROM class")
    List<ClassEntity> getAll();

    @Select("SELECT * FROM class WHERE classId = #{id}")
    ClassEntity getOne(Integer id);

    @Insert("INSERT INTO class(className,courseId,courseName,classStartTime,classEndTime,classPrice) VALUES(#{className},#{courseId},#{courseName},#{classStartTime},#{classEndTime},#{classPrice})")
    Integer insert(ClassEntity aclass);

    @Update("Update class set className=#{classEntity.className},courseId=#{classEntity.courseId},courseName=#{classEntity.courseName},classStartTime=#{classEntity.classStartTime},classEndTime=#{classEntity.classEndTime},classPrice=#{classEntity.classPrice} WHERE classId =#{id}")
    Integer update(@Param("id") Integer id, @Param("classEntity") ClassEntity classEntity);

    @Delete("DELETE FROM class WHERE classId =#{id}")
    void delete(Integer id);

}
