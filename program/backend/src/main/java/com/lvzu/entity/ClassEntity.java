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
    private Integer classRegisteredCount;

    public ClassEntity(String className, Integer courseId, String courseName, Date classStartTime, Date classEndTime, Integer classPrice) {
        this.className = className;
        this.courseId = courseId;
        this.courseName = courseName;
        this.classStartTime = classStartTime;
        this.classEndTime = classEndTime;
        this.classPrice = classPrice;
    }

    public ClassEntity(String className, Integer courseId, String courseName, Date classStartTime, Date classEndTime, Integer classPrice, Integer classRegisteredCount) {
        this.className = className;
        this.courseId = courseId;
        this.courseName = courseName;
        this.classStartTime = classStartTime;
        this.classEndTime = classEndTime;
        this.classPrice = classPrice;
        this.classRegisteredCount = classRegisteredCount;
    }

    public ClassEntity(Integer classId, String className, Integer courseId, String courseName, Date classStartTime, Date classEndTime, Integer classPrice, Integer classRegisteredCount) {

        this.classId = classId;
        this.className = className;
        this.courseId = courseId;
        this.courseName = courseName;
        this.classStartTime = classStartTime;
        this.classEndTime = classEndTime;
        this.classPrice = classPrice;
        this.classRegisteredCount = classRegisteredCount;
    }

    public Integer getClassId() {

        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getClassStartTime() {
        return classStartTime;
    }

    public void setClassStartTime(Date classStartTime) {
        this.classStartTime = classStartTime;
    }

    public Date getClassEndTime() {
        return classEndTime;
    }

    public void setClassEndTime(Date classEndTime) {
        this.classEndTime = classEndTime;
    }

    public Integer getClassPrice() {
        return classPrice;
    }

    public void setClassPrice(Integer classPrice) {
        this.classPrice = classPrice;
    }

    public Integer getClassRegisteredCount() {
        return classRegisteredCount;
    }

    public void setClassRegisteredCount(Integer classRegisteredCount) {
        this.classRegisteredCount = classRegisteredCount;
    }
}
