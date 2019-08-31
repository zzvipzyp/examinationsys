package com.xct.examinationsys.entity;

import lombok.Data;

/**
 * 题目类型
 */
@Data
public class QuestionType {
    private int typeId;
    private String typeName;
    private int score;
    private String remark;
}
