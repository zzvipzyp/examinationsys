package com.xct.examinationsys.dao;

import com.xct.examinationsys.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author ZZzz
 * @version 1.0
 * @className UserDao
 * @description TODO
 * @date 2019/8/29 20:09
 */
public interface UserDao {

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
    public Integer totalQuantity();


}
