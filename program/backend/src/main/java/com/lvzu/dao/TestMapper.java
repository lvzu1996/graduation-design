package com.lvzu.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by zhibinglv on 2018/1/25.
 */
public interface TestMapper {
    @Select("SELECT * from course where 1=1")
    List<Map<String,String>> test();
}
