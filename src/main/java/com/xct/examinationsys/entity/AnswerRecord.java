package com.xct.examinationsys.entity;

import lombok.Data;

@Data
public class AnswerRecord {
    private Integer recordId;
    private Integer userId;
    private String user;
    private Integer courseId;
    private String course;
    private Integer gradeId;
    private String grade;
    private String userAnswer;
    private String question;
    private Integer questionId;
    private Integer typeId;
    private String type;
    private String result;
    private String state;
}
