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

    @Insert("INSERT INTO class(className,courseId,courseName,classStartTime,classEndTime) VALUES(#{className},#{courseId},#{courseName},#{classStartTime},#{classEndTime})")
    Integer insert(ClassEntity aclass);

    @Update("Update class set classId =#{aclass.classId},className=#{aclass.className},courseId=#{aclass.courseId},courseName=#{aclass.courseName},classStartTime=#{aclass.classStartTime},classEndTime=#{aclass.classEndTime} WHERE classId =#{id}")
    void update(@Param("id") Integer id, @Param("aclass") ClassEntity aclass);

    @Delete("DELETE FROM class WHERE classId =#{id}")
    void delete(Integer id);

}
