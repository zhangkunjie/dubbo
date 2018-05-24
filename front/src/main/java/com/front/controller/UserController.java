package com.front.controller;

import com.backend.common.JsonCallBack;
import com.backend.model.User;
import com.backend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by kunjie.zhang on 2018/5/24.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/findUserList", method = RequestMethod.GET)
    @ResponseBody
    public JsonCallBack findAllStudents(User user) {
        logger.info("findAllStudents called");
        JsonCallBack jsonCallBack = new JsonCallBack(true);
        Map<String, Object> pairs = jsonCallBack.getPairs();
        try {
            List<User> list = userService.findUserList(user);
            pairs.put("dat", list);
        } catch (Exception e) {
            jsonCallBack.setSuccess(false);
            jsonCallBack.setMessage(e.getMessage());
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return jsonCallBack;
    }


}
