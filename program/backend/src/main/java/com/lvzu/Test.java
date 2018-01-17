package com.lvzu;

import com.lvzu.dao.CourseMapper;
import com.lvzu.entity.CourseEntity;
import com.lvzu.entity.ResponseEntity;
import com.lvzu.service.CourseService;

import javax.annotation.Resource;

/**
 * Created by zhibinglv on 2018/1/6.
 */
public class Test {

    public static void main(String[] args) {

        System.out.println(System.currentTimeMillis());
    }
    public static class TTEST{
        private CourseMapper courseMapper;
        TTEST(){

        };
        public Integer ttestthis(){
            return courseMapper.insert("hahahs");
        }
    }
}


