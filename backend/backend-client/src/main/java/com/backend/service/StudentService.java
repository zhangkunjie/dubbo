package com.backend.service;

import com.common.model.Student;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by user on 2018/1/8.
 */
public interface StudentService {
    public void insert(Student student);

    public void insertBatch(List<Student> studentList);

    public void delete(Student student);

    public void update(Student student);

    public Student getById(Student student);

    public List<Student> findAll(Student student);


    public PageInfo<Student> findPage(Student student, int pageSize, int pageNo);


}
