package com.xct.examinationsys.entity;

import lombok.Data;

@Data
public class Grade {
    private Integer gradeId;
    private String gradeName;
    private Integer courseId;
    private String course;
}
