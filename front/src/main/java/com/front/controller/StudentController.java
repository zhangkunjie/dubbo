package com.front.controller;

import com.backend.service.StudentService;
import com.common.model.Student;
import com.common.utils.JsonCallBack;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    private Logger logger = LoggerFactory.getLogger(StudentController.class);


    @RequestMapping(value = "/findAllStudents", method = RequestMethod.GET)
    @ResponseBody
    public JsonCallBack findAllStudents(Student studentModel) {
        logger.info("findAllStudents called");
        JsonCallBack jsonCallBack = new JsonCallBack(true);
        try {
            Map<String, Object> pairs = jsonCallBack.getPairs();
            List<Student> list = studentService.findAllStudnts(studentModel);
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
    public JsonCallBack findPage(@RequestBody Student student,
                                 @PathVariable int pageNo, @PathVariable int pageSize) {
        logger.info("findAllStudents called");
        JsonCallBack jsonCallBack = new JsonCallBack(true);
        Map<String, Object> pairs = jsonCallBack.getPairs();
        try {
            PageInfo<Student> studentModel = studentService.findPage(student, pageNo, pageSize);
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
