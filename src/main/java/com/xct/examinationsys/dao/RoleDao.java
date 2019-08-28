package com.xct.examinationsys.dao;


import com.xct.examinationsys.entity.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findAllRoles();

    Role selectRole(Integer id);

    void addRole(Role role);

    void updateRole(Role role);

    void delete(int[] id);
}
