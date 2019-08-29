package com.xct.examinationsys.service;

import com.xct.examinationsys.entity.Resource;
import com.xct.examinationsys.entity.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {
    List<Role> findAllRoles(Map<String, Integer> pageMap);

    Role selectRole(Integer id);

    void addRole(Role role);

    void updateRole(Role role);

    void delete(int[] id);

    List<Resource> getAccessedResources(Integer roleId);

    void authorise(Integer[] ids, Integer roleId);
}
