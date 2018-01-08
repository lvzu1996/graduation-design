package com.lvzu.controller;


import com.lvzu.controller.requestBody.AddCourseRequest;
import com.lvzu.dao.ClassMapper;
import com.lvzu.dao.CourseMapper;
import com.lvzu.entity.ClassEntity;
import com.lvzu.entity.CourseEntity;
import com.lvzu.entity.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public ResponseEntity AddOne(@RequestBody AddCourseRequest addCourseRequest) {
        responseEntity = new ResponseEntity();
        String courseName = addCourseRequest.getCourseName();
        if(courseMapper.exist(courseName)==null){
            Integer influencedCount = courseMapper.insert(courseName);
            if(influencedCount == 1){
                responseEntity = responseEntity.success();
            }else{
                responseEntity = responseEntity.fail(10002);
            }
        }else{
            responseEntity = responseEntity.fail(10001);
        }
        return responseEntity;
    }

    @RequestMapping(value ="/api/reviceCourses", method = RequestMethod.POST)
    public ResponseEntity Revice(@RequestBody Map<String, String> requestData) {
        responseEntity = new ResponseEntity();
        String oldCourseName = requestData.get("oldCourseName");
        String newCourseName = requestData.get("newCourseName");
        if(courseMapper.exist(oldCourseName) != null){
            if(courseMapper.exist(newCourseName) == null){
                int influenced = courseMapper.update(oldCourseName,newCourseName);
                if(influenced == 1){
                    responseEntity.success();
                }else {
                    responseEntity.fail(10004);
                }
            }else {
                responseEntity.fail(10001);
            }
        }else {
            responseEntity.fail(10003);
        }
        return responseEntity;
    }

    @RequestMapping(value ="/api/courses/{id}", method = RequestMethod.DELETE)
    public void Delete(@PathVariable("id") Integer id) {
        courseMapper.delete(id);
    }
}
