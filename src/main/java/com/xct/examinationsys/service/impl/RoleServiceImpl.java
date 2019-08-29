package com.xct.examinationsys.service.impl;

import com.github.pagehelper.PageHelper;
import com.xct.examinationsys.dao.RoleDao;
import com.xct.examinationsys.entity.Resource;
import com.xct.examinationsys.entity.Role;
import com.xct.examinationsys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAllRoles(Map<String, Integer> pageMap) {
        // 设置页码和每页显示的记录数，该语句后面，紧跟着数据库查询相关的语句
        PageHelper.startPage(pageMap.get("page"), pageMap.get("limit"));
        return roleDao.findAllRoles();
    }

    @Override
    public Role selectRole(Integer id) {
        return roleDao.selectRole(id);
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }

    @Override
    public void delete(int[] id) {
        roleDao.delete(id);
    }

    @Override
    public List<Resource> getAccessedResources(Integer roleId) {
        return roleDao.getAccessedResources(roleId);
    }

    @Override
    public void authorise(Integer[] ids, Integer roleId) {
        roleDao.clearRolePermission(roleId);
        List<Map<String, Integer>> permissionList = new ArrayList<>();
        for (Integer id : ids) {
            Map<String, Integer> map = new HashMap<>();
            map.put("roleId", roleId);
            map.put("resourceId", id);
            permissionList.add(map);
        }
        roleDao.authorise(permissionList);
    }
}
