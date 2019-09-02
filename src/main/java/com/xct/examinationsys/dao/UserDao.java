package com.xct.examinationsys.dao;


import com.xct.examinationsys.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAllUsers(User user);

    User selectUserById(String userId);

    void addUser(User user);

    void updateUser(User user);

    void delete(int[] id);
}
