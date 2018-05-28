package com.backend.service.impl;

import com.backend.dao.StudentDao;
import com.backend.service.StudentService;
import com.common.model.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by user on 2018/1/8.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    /*物理删除对象*/
    public void delete(Student student) {
        studentDao.delete(student);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    /*更新对象*/
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    /*根据主键id查找单个对象*/
    public Student getById(Student student) {
        return studentDao.getById(student);
    }

    @Override
    /*查询所有对象*/
    public List<Student> findAll(Student student) {
        return studentDao.findAll(student);
    }

    @Override
    /*
    * 插入对象
    * */
    @Transactional(propagation = Propagation.REQUIRED)
    public void insert(Student student) {
        studentDao.insert(student);

    }

    @Override
      /*
    * 批量插入对象
    * */
    @Transactional(propagation = Propagation.REQUIRED)
    public void insertBatch(List<Student> studentList) {
        studentDao.insertBatch(studentList);
    }


    @Override
    /*
    分页查找
    * */
    public PageInfo<Student> findPage(Student student, int pageSize, int pageNo) {
        PageHelper.startPage(pageNo, pageSize);
        List<Student> list = studentDao.findPage(student);
        PageInfo<Student> pageInfo = new PageInfo<Student>(list);
        return pageInfo;
    }


}
