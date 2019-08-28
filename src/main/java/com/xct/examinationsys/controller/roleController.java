package com.xct.examinationsys.controller;


import com.github.pagehelper.Page;
import com.xct.examinationsys.entity.Role;
import com.xct.examinationsys.service.RoleService;
import com.xct.examinationsys.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/role")
public class roleController {

    @Autowired
    private RoleService roleService;

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
}
