package com.lvzu.dao;

import com.lvzu.entity.ManagerEntity;
import org.apache.ibatis.annotations.Select;

/**
 * Created by zhibinglv on 2018/1/6.
 */
public interface ManagerMapper {

    @Select("SELECT * FROM manager WHERE managerTelephone = #{managerTelephone}")
    ManagerEntity getOne(String managerTelephone);

}
