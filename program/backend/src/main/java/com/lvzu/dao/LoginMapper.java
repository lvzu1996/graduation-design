package com.lvzu.dao;

import com.lvzu.entity.ManagerEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface LoginMapper {

    @Select("SELECT * FROM manager WHERE managerTelephone = #{managerTelephone}")
    ManagerEntity getOne(String managerTelephone);

    @Insert("INSERT INTO wx_session(session_key,expire) VALUES(#{session_key},#{expire})")
    Integer insert(@Param("session_key") String session_key,@Param("expire") long expire);
}
