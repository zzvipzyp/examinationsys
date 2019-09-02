package com.xct.examinationsys.service;

import com.xct.examinationsys.entity.User;

/**
 * @author ZZzz
 * @version 1.0
 * @className UserService
 * @description TODO
 * @date 2019/8/29 20:21
 */
public interface UserService {

    /**
     * 用户登录
     *
     * @param userName 传入的是一个用户的账户
     * @return 返回的是 User类对象
     */
    public User loginByUserName(String userName);

    /**
     * 用户注册
     *
     * @param user User类对象
     */
    public void registerUser(User user);

    /**
     * 查询用户的总数
     *
     * @return 返回的是用户的总数
     */
    public String totalQuantity();

}
