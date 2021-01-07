package com.ss.graduation.runner;

import com.ss.graduation.model.Student;
import com.ss.graduation.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class TestRunner implements ApplicationRunner {
    @Autowired
    private StudentService studentService;

    @Override
    public void run(ApplicationArguments args){
        getStudentList();
    }

    private void getStudentList(){
        List<Student> list = studentService.getStudentList();
        for(Student student:list){
            log.info(student.toString());
        }
    }
}
