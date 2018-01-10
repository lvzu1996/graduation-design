package com.lvzu.controller;

import com.lvzu.dao.ClassMapper;
import com.lvzu.dao.CourseMapper;
import com.lvzu.entity.ClassEntity;
import com.lvzu.entity.ResponseEntity;
import com.lvzu.service.CourseService;
import com.lvzu.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
public class ClassController {

    @Resource
    private ClassMapper classMapper;
    @Resource
    private CourseMapper courseMapper;

    private ResponseEntity responseEntity;

    @Autowired
    private CourseService courseService;

    private static CommonUtil commonUtil;
    @RequestMapping(value= "/api/classes",method = RequestMethod.GET)
    public ResponseEntity getClasses() {
        List<ClassEntity> classes= classMapper.getAll();
        responseEntity = new ResponseEntity();
        responseEntity = responseEntity.success(classes);
        return responseEntity;
    }

    @RequestMapping(value = "/api/classes/{id}", method = RequestMethod.GET)
    public ClassEntity getOne(@PathVariable("id") Integer id) {
        ClassEntity aClass= classMapper.getOne(id);
        return aClass;
    }

    @RequestMapping(value ="/api/classes", method = RequestMethod.POST)
    public ResponseEntity AddOne(@RequestBody Map<String, String> requestData) {
        responseEntity = new ResponseEntity();
        Integer courseId = Integer.valueOf(requestData.get("courseId"));
        String className = requestData.get("className");
        Date classStartTime = commonUtil.StringToDate(requestData.get("classStartTime"));
        Date classEndTime = commonUtil.StringToDate(requestData.get("classEndTime"));
        String courseName = courseService.getCourceNameById(courseId);
        ClassEntity classEntity = new ClassEntity(className,courseId,courseName,classStartTime,classEndTime);
        Integer influenced = classMapper.insert(classEntity);
        if(influenced == 1){
            responseEntity = responseEntity.success();
        }else {
            responseEntity = responseEntity.fail(30001);
        }
        return responseEntity;
    }

    @RequestMapping(value ="/revice/{id}", method = RequestMethod.PUT)
    public ClassEntity Revice(@PathVariable("id") Integer id,@RequestBody ClassEntity aClass) {
        classMapper.update(id,aClass);
        return aClass;
    }

    @RequestMapping(value ="/delete/{id}", method = RequestMethod.DELETE)
    public void Delete(@PathVariable("id") Integer id) {
        classMapper.delete(id);
    }
}
