package com.lvzu.controller;


import com.lvzu.dao.CourseMapper;
import com.lvzu.entity.CourseEntity;
import com.lvzu.entity.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class CourseController {

    @Resource
    private CourseMapper courseMapper;

    private ResponseEntity responseEntity;
    @RequestMapping(value= "/api/courses",method = RequestMethod.GET)
    public ResponseEntity getCourses() {
        List<CourseEntity> courses= courseMapper.getAll();
        responseEntity = new ResponseEntity();
        responseEntity = responseEntity.success(courses);
        return responseEntity;
    }

//    @RequestMapping(value = "/api/courses/{id}", method = RequestMethod.GET)
//    public CourseEntity getOne(@PathVariable("id") Integer id) {
//        CourseEntity course= courseMapper.getOne(id);
//        return course;
//    }

    @RequestMapping(value ="/api/courses", method = RequestMethod.POST)
    public ResponseEntity AddOne(@RequestBody Map<String, String> requestData) {
        responseEntity = new ResponseEntity();
        String courseName = requestData.get("courseName");
        if(courseMapper.exist(courseName)==null){
            Integer influenced = courseMapper.insert(courseName);
            if(influenced == 1){
                responseEntity = responseEntity.success();
            }else{
                responseEntity = responseEntity.fail(10002);
            }
        }else{
            responseEntity = responseEntity.fail(10001);
        }
        return responseEntity;
    }

    @RequestMapping(value ="/api/courses", method = RequestMethod.PATCH)
    public ResponseEntity Revice(@RequestBody Map<String, String> requestData) {
        responseEntity = new ResponseEntity();
        String oldCourseName = requestData.get("oldCourseName");
        String newCourseName = requestData.get("newCourseName");
        if(courseMapper.exist(oldCourseName) != null){
            if(courseMapper.exist(newCourseName) == null){
                Integer influenced = courseMapper.update(oldCourseName,newCourseName);
                if(influenced == 1){
                    responseEntity = responseEntity.success();
                }else {
                    responseEntity = responseEntity.fail(10004);
                }
            }else {
                responseEntity = responseEntity.fail(10001);
            }
        }else {
            responseEntity = responseEntity.fail(10003);
        }
        return responseEntity;
    }

    @RequestMapping(value ="/api/courses/{courseName}", method = RequestMethod.DELETE)
    public ResponseEntity Delete(@PathVariable("courseName") String courseName) {
        responseEntity = new ResponseEntity();
        if(courseMapper.exist(courseName) != null){
            Integer influenced = courseMapper.delete(courseName);
            if(influenced == 1){
                responseEntity = responseEntity.success();
            }else{
                responseEntity = responseEntity.fail(10005);
            }
        }else{
            responseEntity = responseEntity.fail(10003);
        }
        return responseEntity;
    }
}
