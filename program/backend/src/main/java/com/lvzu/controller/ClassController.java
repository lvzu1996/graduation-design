package com.lvzu.controller;

import com.lvzu.dao.ClassMapper;
import com.lvzu.entity.ClassEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ClassController {

    @Resource
    private ClassMapper classMapper;

    @RequestMapping(value= "/getClasses",method = RequestMethod.GET)
    public List<ClassEntity> getClasses() {
        List<ClassEntity> classes= classMapper.getAll();
        return classes;
    }

    @RequestMapping(value = "/getOne/{id}", method = RequestMethod.GET)
    public ClassEntity getOne(@PathVariable("id") Integer id) {
        ClassEntity aClass= classMapper.getOne(id);
        return aClass;
    }

    @RequestMapping(value ="/addOne", method = RequestMethod.POST)
    public ClassEntity AddOne(@RequestBody ClassEntity aClass) {
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
