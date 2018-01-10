package com.lvzu.controller;

import com.lvzu.dao.ClassMapper;
import com.lvzu.dao.CourseMapper;
import com.lvzu.entity.ClassEntity;
import com.lvzu.entity.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class ClassController {

    @Resource
    private ClassMapper classMapper;
    private CourseMapper courseMapper;

    private ResponseEntity responseEntity;

    @RequestMapping(value= "/api/classes",method = RequestMethod.GET)
    public ResponseEntity getClasses() {
        List<ClassEntity> classes= classMapper.getAll();
        responseEntity = new ResponseEntity();
        responseEntity = responseEntity.success(classes);
        return responseEntity;
    }

    @RequestMapping(value = "/api/getOne/{id}", method = RequestMethod.GET)
    public ClassEntity getOne(@PathVariable("id") Integer id) {
        ClassEntity aClass= classMapper.getOne(id);
        return aClass;
    }

    @RequestMapping(value ="/api/addOne", method = RequestMethod.POST)
    public ClassEntity AddOne(@RequestBody Map<String, String> requestData) {
        String courseName = requestData.get("courseName");
        String className = requestData.get("className");
        ClassEntity aClass = new ClassEntity();
        classMapper.insert(aClass);
        return aClass;
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
