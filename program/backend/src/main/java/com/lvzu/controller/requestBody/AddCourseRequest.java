package com.lvzu.controller.requestBody;

public class AddCourseRequest {
    private String courseName;

    public AddCourseRequest() {
    }

    public AddCourseRequest(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
