package com.front.controller;

import com.backend.service.StudentService;
import com.common.model.Student;
import com.common.utils.JsonCallBack;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * Created by user on 2018/1/8.
 */
@Controller
@RequestMapping("/student/")
public class StudentController {
    @Autowired
    private StudentService studentService;
    private Logger logger = LoggerFactory.getLogger(StudentController.class);


    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public JsonCallBack insert(@RequestBody Student student) {
        logger.info("insert called");
        JsonCallBack jsonCallBack = new JsonCallBack(true);
        try {
            studentService.insert(student);
        } catch (Exception e) {
            jsonCallBack.setSuccess(false);
            jsonCallBack.setMessage(e.getMessage());
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return jsonCallBack;
    }

    @RequestMapping(value = "/insertBatch", method = RequestMethod.POST)
    @ResponseBody
    public JsonCallBack insertBatch(@RequestBody List<Student> studentList) {
        logger.info("insertBatch called");
        JsonCallBack jsonCallBack = new JsonCallBack(true);
        try {
            studentService.insertBatch(studentList);
        } catch (Exception e) {
            jsonCallBack.setSuccess(false);
            jsonCallBack.setMessage(e.getMessage());
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return jsonCallBack;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public JsonCallBack delete(@RequestBody Student student) {
        logger.info("delete called");
        JsonCallBack jsonCallBack = new JsonCallBack(true);
        try {
            studentService.delete(student);
        } catch (Exception e) {
            jsonCallBack.setSuccess(false);
            jsonCallBack.setMessage(e.getMessage());
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return jsonCallBack;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public JsonCallBack update(@RequestBody Student student) {
        logger.info("findAllStudents called");
        JsonCallBack jsonCallBack = new JsonCallBack(true);
        try {
            studentService.update(student);
        } catch (Exception e) {
            jsonCallBack.setSuccess(false);
            jsonCallBack.setMessage(e.getMessage());
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return jsonCallBack;
    }

    @RequestMapping(value = "/getById", method = RequestMethod.POST)
    @ResponseBody
    public JsonCallBack getById(@RequestBody Student student) {
        logger.info("getById called");
        JsonCallBack jsonCallBack = new JsonCallBack(true);
        Map<String, Object> pairs = jsonCallBack.getPairs();
        try {
            student = studentService.getById(student);
            pairs.put("dat", student);
        } catch (Exception e) {
            jsonCallBack.setSuccess(false);
            jsonCallBack.setMessage(e.getMessage());
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return jsonCallBack;
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    @ResponseBody
    public JsonCallBack findAll(@RequestBody Student student) {
        logger.info("findAllStudents called");
        JsonCallBack jsonCallBack = new JsonCallBack(true);
        Map<String, Object> pairs = jsonCallBack.getPairs();
        try {
            List<Student> studentList = studentService.findAll(student);
            pairs.put("dat", studentList);
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
    public JsonCallBack findPage(@RequestBody Student student,
                                 @PathVariable int pageNo, @PathVariable int pageSize) {
        logger.info("findAllStudents called");
        JsonCallBack jsonCallBack = new JsonCallBack(true);
        Map<String, Object> pairs = jsonCallBack.getPairs();
        try {
            PageInfo<Student> pageInfo = studentService.findPage(student, pageNo, pageSize);
            pairs.put("dat", pageInfo);
        } catch (Exception e) {
            jsonCallBack.setSuccess(false);
            jsonCallBack.setMessage(e.getMessage());
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return jsonCallBack;
    }

}
