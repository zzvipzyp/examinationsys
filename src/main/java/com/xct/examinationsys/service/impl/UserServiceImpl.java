package com.xct.examinationsys.service.impl;

import com.xct.examinationsys.dao.UserDao;
import com.xct.examinationsys.entity.User;
import com.xct.examinationsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZZzz
 * @version 1.0
 * @className UserServiceImpl
 * @description TODO
 * @date 2019/8/29 20:21
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User loginByUserName(String userName) {
        return userDao.loginByUserName(userName);
    }

    @Override
    public void registerUser(User user) {

        user.setUserId(totalQuantity());
        System.out.println(user);
        userDao.registerUser(user);
    }

    @Override
    public String totalQuantity() {
        Integer t =  userDao.totalQuantity()+1;
        String total = t.toString();
        return total;
    }
}
