package com.lvzu.entity;

public class CourseEntity {

    private Integer courseId;
    private String courseName;

    public CourseEntity(Integer courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public CourseEntity() {
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
}
