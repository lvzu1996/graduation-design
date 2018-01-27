package com.lvzu.dao;

import com.lvzu.entity.ManagerEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

public interface LoginMapper {

    @Select("SELECT * FROM manager WHERE managerTelephone = #{managerTelephone}")
    ManagerEntity getOne(@Param("managerTelephone") String managerTelephone);

    @Insert("INSERT INTO wx_session(session_key,expire) VALUES(#{session_key},#{expire})")
    Integer insert(@Param("session_key") String session_key,@Param("expire") long expire);

    @Select("SELECT * FROM wx_session WHERE session_key = #{session_key}")
    String exist(@Param("session_key") String session_key);

    @Update("Update wx_session set expire=#{expire} WHERE session_key =#{session_key}")
    Integer update(@Param("session_key") String session_key,@Param("expire") long expire);

    @Insert("INSERT INTO user(userTelephone,userOpenid) VALUES(#{userTelephone},#{userOpenid})")
    Integer register(@Param("userTelephone") String userTelephone,@Param("userOpenid") String userOpenid);

    @Select("SELECT * FROM user WHERE userOpenid = #{userOpenid}")
    String existUser(@Param("userOpenid") String userOpenid);

}
