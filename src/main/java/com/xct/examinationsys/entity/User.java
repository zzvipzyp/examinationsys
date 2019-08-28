package com.xct.examinationsys.entity;

import lombok.Data;

@Data
public class User {
    private String userId;
    private String userName;
    private String userPwd;
    private Integer gradeId;
    private String grade;
    private Integer roleId;
    private String roleName;
    private Integer userStateId;
    private String userState;
    private String email;
    private String telephone;
    private String address;
    private String remark;
}
