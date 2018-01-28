package com.lvzu.dao;

import com.lvzu.entity.UserGroupEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhibinglv on 2018/1/25.
 */
public interface TestMapper {
//    @Select("SELECT * from course where 1=1")
//    List<Map<String,String>> test();

    @Select("SELECT * FROM user_group where userGroupId=#{userGroupId}")
    List<Map> test(@Param("userGroupId") Integer userGroupId);
}
