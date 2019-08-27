package com.xct.examinationsys.entity;

import lombok.Data;

@Data
public class Question {
    private int questionId;
    private String quesName;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answer;
    private String answerDetail;
    private String userAnswer;
    private String courseId;
    private String typeId;
    private int difficulty;
    private String remark;
    private String gradeId;
}
