package com.xct.examinationsys.controller;


import com.github.pagehelper.Page;
import com.xct.examinationsys.entity.User;
import com.xct.examinationsys.service.UserService;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> listUsers(Integer page, Integer limit, User user) {
        Map<String, Integer> pageMap = new HashMap<>();
        pageMap.put("page", page);
        pageMap.put("limit", limit);

        List<User> list = userService.findAllUsers(pageMap, user);



        long total = ((Page) list).getTotal();

        return PageUtil.pubPage(total, list);
    }
}
