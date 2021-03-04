package com.ss.graduation.service.impl;

import com.ss.graduation.mapper.CourseMapper;
import com.ss.graduation.model.Course;
import com.ss.graduation.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ss
 * @Date: 2021/03/04/12:03
 * @Description:
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;


    @Override
    public List<Course> selectList() {
        return courseMapper.selectList(null);
    }
}
