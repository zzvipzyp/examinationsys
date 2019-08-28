package com.xct.examinationsys.service;

import com.xct.examinationsys.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> findAllUsers(Map<String, Integer> pageMap, User user);

    User selectUser(Integer id);

    void addUser(User user);

    void updateUser(User user);

    void delete(int[] id);
}
