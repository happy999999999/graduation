package com.ss.graduation.mapper;

import com.ss.graduation.model.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    List<Student> getStudentList();
}
