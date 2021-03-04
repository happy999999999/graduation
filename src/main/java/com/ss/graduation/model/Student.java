package com.ss.graduation.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Student {

    private Integer studentId;//学生id

    private String studentName;//学生姓名

    private Integer studentAge;//学生年龄

    private String qqNumber;//qq号码

    private String phoneNumber;//手机号码

    private String dormitory;//宿舍位置

    private Timestamp admissionTime;//入学时间

    private Timestamp graduationTime;//毕业时间

    private Integer collegeId;//学院id

    private Integer professionalId;//专业id

    private Integer counselorId;//辅导员id

    private Integer tutorId;//导师id

    private Timestamp createTime;//创建时间

    private Timestamp updateTime;//修改时间

    private Integer status;//状态：0存在，1删除


}
