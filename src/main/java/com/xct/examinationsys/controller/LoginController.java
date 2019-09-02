package com.xct.examinationsys.controller;

import com.xct.examinationsys.common.JsonResult;
import com.xct.examinationsys.entity.User;
import com.xct.examinationsys.service.UserService;
import com.xct.examinationsys.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author ZZzz
 * @version 1.0
 * @className LoginController
 * @description TODO
 * @date 2019/8/29 20:25
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;


    @RequestMapping("/User/login.do")
    public Map<String, Object> login(String userName, String userPwd){
        Map<String, Object> map = new HashMap<>();
        //调用service进行查询用户的信息
        User user = userService.loginByUserName(userName);

        if (user.getUserPwd().equals(userPwd)){

            //根据name生成 token
            String token = MD5Utils.md5(userName + "heihei");
            map.put("token",token);

            // 将 token写到redis中,并设置其有效时间
            redisTemplate.opsForValue().set(token, userName);
            redisTemplate.expire(token, 1800, TimeUnit.SECONDS);

        }
        return map;
    }


    @RequestMapping("/User/register.do")
    public JsonResult registerUser(User user) {

        try {
            userService.registerUser(user);
            return new JsonResult(1, "注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(0, "注册失败");
        }

    }



}
