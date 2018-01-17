package com.lvzu.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by zhibinglv on 2018/1/5.
 */
public class ClassEntity implements Serializable {

    private Integer classId;
    private String className;
    private Integer courseId;
    private String courseName;
    private Date classStartTime;
    private Date classEndTime;
    private Integer classPrice;

    public Integer getClassPrice() {
        return classPrice;
    }

    public void setClassPrice(Integer classPrice) {
        this.classPrice = classPrice;
    }

    public ClassEntity(String className, Integer courseId, String courseName, Date classStartTime, Date classEndTime, Integer classPrice) {
        this.className = className;
        this.courseId = courseId;
        this.courseName = courseName;
        this.classStartTime = classStartTime;
        this.classEndTime = classEndTime;
        this.classPrice = classPrice;
    }


    public ClassEntity(){
        super();
    }

    public ClassEntity(Integer classPrice, Integer courseId, String courseName, Date classStartTime, Date classEndTime, String className) {
        this.classPrice = classPrice;
        this.courseId = courseId;
        this.courseName = courseName;
        this.classStartTime = classStartTime;
        this.classEndTime = classEndTime;
        this.className = className;
    }

    public ClassEntity(Integer classId, String className, Integer courseId, String courseName, Date classStartTime, Date classEndTime) {
        this.classId = classId;
        this.className = className;
        this.courseId = courseId;
        this.courseName = courseName;
        this.classStartTime = classStartTime;
        this.classEndTime = classEndTime;
    }

    public ClassEntity(String className, Integer courseId, String courseName, Date classStartTime, Date classEndTime) {
        this.className = className;
        this.courseId = courseId;
        this.courseName = courseName;
        this.classStartTime = classStartTime;
        this.classEndTime = classEndTime;
    }

    public String getClassName() {
        return className;
    }

    public Integer getClassId() {
        return classId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public Date getClassStartTime() {
        return classStartTime;
    }

    public Date getClassEndTime() {
        return classEndTime;
    }

    public void setClassName(String className) {

        this.className = className;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public void setClassStartTime(Date classStartTime) {
        this.classStartTime = classStartTime;
    }

    public void setClassEndTime(Date classEndTime) {
        this.classEndTime = classEndTime;
    }
}
