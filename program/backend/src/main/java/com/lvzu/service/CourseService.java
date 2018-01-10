package com.lvzu.service;

import com.lvzu.dao.CourseMapper;
import com.lvzu.entity.CourseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhibinglv on 2018/1/10.
 */
@Service
public class CourseService {
    @Resource
    private CourseMapper courseMapper;
    private CourseEntity courseEntity;

    public CourseService(){

    }
    public String getCourceNameById(Integer courseId){
        courseEntity = courseMapper.getOne(courseId);
        return courseEntity.getCourseName();
    }
}
