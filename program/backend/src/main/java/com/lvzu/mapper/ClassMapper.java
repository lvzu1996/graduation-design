package com.lvzu.mapper;

import com.lvzu.tables.Class;
import com.sun.tools.javac.util.List;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhibinglv on 2018/1/5.
 */
public interface ClassMapper {
    @Select("SELECT * FROM class")
    @Results({
            @Result(property = "classId ",  column = "classid"),
            @Result(property = "className", column = "classname")
    })
    List<Class> getAll();
}
