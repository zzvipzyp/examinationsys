package com.xct.examinationsys.entity;

import lombok.Data;

@Data
public class Course {
    private Integer courseId;
    private String courseName;
    private Integer courseStateId;
    private String courseState;
}
