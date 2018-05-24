package com.backend.service.impl;

import com.backend.dao.UserDao;
import com.backend.service.UserService;

import com.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kunjie.zhang on 2018/5/23.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public List<User> findUserList(User user) {
        return userDao.findAll(user);
    }
}
