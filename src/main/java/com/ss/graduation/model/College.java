package com.ss.graduation.model;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ss
 * @Date: 2021/01/14/10:39
 * @Description:
 */
@Data
public class College {

    private Integer collegeId;//学院id

    private String collegeName;//学院name

    private String collegeSlogan;//学院口号

    private String counselorIds;//辅导员们

    private String teacherIds;//老师们

    private String tutorIds;//导师们

    private String professionalIds;//包括的专业

    private Timestamp createTime;//创建时间

    private Timestamp updateTime;//更新时间

    private Integer status;//状态：0存在1删除




}
