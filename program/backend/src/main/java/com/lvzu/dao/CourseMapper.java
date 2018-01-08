package com.lvzu.dao;

import com.lvzu.entity.CourseEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by zhibinglv on 2018/1/5.
 */
public interface CourseMapper {

    @Select("SELECT * FROM course")
    List<CourseEntity> getAll();

    @Select("SELECT * FROM course WHERE courseId = #{id}")
    CourseEntity getOne(Integer id);

    @Select("SELECT * FROM course WHERE courseName = #{courseName}")
    Integer exist(String courseName);

    @Insert("INSERT INTO course(courseName) VALUES(#{courseName})")
    Integer insert(String courseName);

    @Update("Update course set courseName=#{newCourseName} WHERE courseName =#{oldCourseName}")
    Integer update(@Param("oldCourseName") String oldCourseName, @Param("newCourseName") String newCourseName);

    @Delete("DELETE FROM course WHERE courseName =#{courseName}")
    Integer delete(String courseName);

}
