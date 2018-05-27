package com.backend.service.impl;

import com.backend.dao.StudentDao;
import com.backend.service.StudentService;
import com.common.model.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2018/1/8.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    public List<Student> findAllStudnts(Student studentModel) {
        return studentDao.findAll(studentModel);
    }

    @Override
    public PageInfo<Student> findPage(Student student, int pageSize, int pageNo) {
        PageHelper.startPage(pageNo, pageSize);
        List<Student> list = studentDao.findPage(student);
        PageInfo<Student> pageInfo = new PageInfo<Student>(list);
        return pageInfo;
    }

    public List<Map<String, String>> findAllStudntsMapList(Student studentModel) {
        return studentDao.findAllMapList(studentModel);
    }

    public Student findStudentById(Map<String, Integer> param) {
        return studentDao.findStudentById(param);
    }

}
