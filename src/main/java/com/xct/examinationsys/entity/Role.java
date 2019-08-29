package com.xct.examinationsys.entity;

import lombok.Data;

import java.security.Permission;
import java.util.List;

@Data
public class Role {
    private Integer roleId;
    private String roleName;
    private List<Permission> permissions;

}
