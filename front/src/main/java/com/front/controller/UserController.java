package com.front.controller;

import com.backend.service.UserService;
import com.common.model.PageModel;
import com.common.utils.JsonCallBack;
import com.common.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/findPage/{pageNo}/{pageSize}", method = RequestMethod.POST)
    @ResponseBody
    public JsonCallBack findPage(@RequestBody User user,
                                 @PathVariable int pageNo, @PathVariable int pageSize) {
        logger.info("findAllStudents called");
        JsonCallBack jsonCallBack = new JsonCallBack(true);
        Map<String, Object> pairs = jsonCallBack.getPairs();
        try {
            PageModel<User> studentModel = userService.findPage(user, pageNo, pageSize);
            pairs.put("dat", studentModel);
        } catch (Exception e) {
            jsonCallBack.setSuccess(false);
            jsonCallBack.setMessage(e.getMessage());
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return jsonCallBack;
    }


}
