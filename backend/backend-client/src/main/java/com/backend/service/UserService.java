package com.backend.service;


import com.model.User;

import java.util.List;

/**
 * Created by kunjie.zhang on 2018/5/23.
 */
public interface UserService {
    public List<User> findUserList(User user);

}
