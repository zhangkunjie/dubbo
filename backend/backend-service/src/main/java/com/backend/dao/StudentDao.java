package com.backend.dao;

import com.common.model.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by user on 2018/1/8.
 */
public interface StudentDao extends BaseDao<Student, Long> {
    public List<Student> findAll(Student studentModel);

    public List<Map<String, String>> findAllMapList(Student studentModel);

    public Student findStudentById(Map<String, Integer> param);

}
