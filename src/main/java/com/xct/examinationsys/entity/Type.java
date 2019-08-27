package com.xct.examinationsys.entity;

import lombok.Data;

@Data
public class Type {
    private int typeid;
    private String typename;
    private int score;
    private String remark;
}
