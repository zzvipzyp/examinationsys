package com.xct.examinationsys.entity;

import lombok.Data;

/**
 * 题目类型
 */
@Data
public class QuestionType {
    private Integer typeId;
    private String typeName;
    private Integer score;
    private String remark;
}
