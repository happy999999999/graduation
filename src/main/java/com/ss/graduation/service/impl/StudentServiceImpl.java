package com.ss.graduation.service.impl;

import com.ss.graduation.mapper.StudentMapper;
import com.ss.graduation.model.Student;
import com.ss.graduation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getStudentList() {
        return studentMapper.getStudentList();
    }
}
