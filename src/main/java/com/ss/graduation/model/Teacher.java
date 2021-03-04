package com.ss.graduation.model;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ss
 * @Date: 2021/01/14/10:30
 * @Description:
 */
@Data
public class Teacher {

    private Integer teacherId;//教师id

    private String teacherName;//教师名字

    private Integer teacherAge;//教师年龄

    private String qqNumber;//qq号码

    private String phoneNumber;//手机号码

    private Integer identify;//身份0教师1辅导员

    private Timestamp entryTime;//入职时间

    private Timestamp retirementTime;//退休时间

    private String courseIds;//教授课程id

    private Integer collegeId;//学院id

    private String officeLocation;//办公室

    private Timestamp createTime;//创建时间

    private Timestamp updateTime;//更新时间

    private Integer status;//状态0存在1删除

}
