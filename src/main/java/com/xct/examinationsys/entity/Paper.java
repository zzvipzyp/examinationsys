package com.xct.examinationsys.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Paper {
    private String paperId;
    private String paperName;

    private String courseId;
    private String course;

    private String gradeId;
    private String grade;

    private String userId;
    private String user;

    private String questionId;
    private String question;

    private Date beginTime;
    private String beginTimeStr;
    private Date endTime;
    private String endTimeStr;
    private String allowTime;

    private String score;
    private String paperState;

}
