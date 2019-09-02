package com.xct.examinationsys.dao;


import com.xct.examinationsys.entity.Resource;
import com.xct.examinationsys.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoleDao {
    List<Role> findAllRoles();

    Role selectRole(Integer id);

    void addRole(Role role);

    void updateRole(Role role);

    void delete(int[] id);

    List<Resource> getAccessedResources(Integer roleId);

    void authorise(List<Map<String, Integer>> list);

    void clearRolePermission(Integer roleId);
}
