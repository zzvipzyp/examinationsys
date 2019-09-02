package com.xct.examinationsys.controller;


import com.github.pagehelper.Page;
import com.xct.examinationsys.common.JsonResult;
import com.xct.examinationsys.entity.Resource;
import com.xct.examinationsys.entity.Role;
import com.xct.examinationsys.service.ResourceService;
import com.xct.examinationsys.service.RoleService;
import com.xct.examinationsys.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class roleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private ResourceService resourceService;

    @RequestMapping("/list.do")
    @ResponseBody
    public Map<String, Object> listRoles(Integer page, Integer limit) {
        Map<String, Integer> pageMap = new HashMap<>();
        pageMap.put("page", page);
        pageMap.put("limit", limit);

        List<Role> list = roleService.findAllRoles(pageMap);

        long total = ((Page) list).getTotal();

        return PageUtil.pubPage(total, list);
    }

    @RequestMapping("/authorise.do")
    public void authorise(Integer[] ids, Integer roleId) {
        roleService.authorise(ids, roleId);

    }

    @RequestMapping("/getPermission")
    public Map<String , List<Resource>> getPermission(Integer roleId) {
        Map<String, Integer> map = new HashMap<>();
        map.put("page", 1);
        map.put("limit", 65535);
        List<Resource> allResources = resourceService.findAllResources(map);
        List<Resource> roleResources = roleService.getAccessedResources(roleId);

        Map<String , List<Resource>> resultMap = new HashMap<>();
        resultMap.put("allResources", allResources);
        resultMap.put("roleResources", roleResources);
        return resultMap;
    }

    @RequestMapping("/query")
    public JsonResult<Object> queryRole(Integer roleId) {
        if (roleId == null) {
            return new JsonResult<Object>(0, "ID为空");
        }

        return new JsonResult<>(1, roleService.selectRole(roleId));
    }

    @RequestMapping(value = "/addOrUpdate")
    public JsonResult<String> addOrUpdateRole(Role role) {
        if (role.getRoleId() == null) {
            roleService.addRole(role);
        } else {
            roleService.updateRole(role);
        }
        return new JsonResult<>(1, "保存成功");
    }

    @RequestMapping("/delete")
    public JsonResult<String> delete(int[] id) {
        roleService.delete(id);
        return new JsonResult<>(1, "删除成功");
    }
}
