package com.xct.examinationsys.entity;

import lombok.Data;

@Data
public class User {
    private Integer userId;
    private String userName;
    private String userPwd;
    private Integer gradeId;
    private String grade;
    private Integer userTypeId;
    private String userType;
    private Integer userStateId;
    private String userState;
    private String email;
    private String telephone;
    private String address;
    private String remark;
}
