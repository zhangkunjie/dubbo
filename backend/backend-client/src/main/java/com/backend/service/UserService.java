package com.backend.service;


import com.common.model.PageModel;
import com.common.model.User;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;

/**
 * Created by kunjie.zhang on 2018/5/23.
 */
public interface UserService {
    public List<User> findUserList(User user);

    public PageModel<User> findPage(User user, int pageSize, int pageNo);

}
