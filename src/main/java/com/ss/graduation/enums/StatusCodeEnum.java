package com.ss.graduation.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum StatusCodeEnum {

    SUCCESS_OK("200", "成功"),
    SYS_ERROR("500","系统错误"),
    SYS_GET_ERROR("500","查询错误"),
    SYS_ADD_ERROR("500","新增错误"),
    SYS_DEL_ERROR("500","删除错误"),
    SYS_EDIT_ERROR("500","编辑错误"),
    SYS_FIND_ERROR("500","单个查找错误"),
    FAILED("10001","操作失败"),
    SYS_EXCEPTION("10004","系统异常"),
    SESSION_EXPIRED("4000","sessionID过期"),
    User_NOT_FOUND("201","未找到用户");

    @Getter
    private String code;
    @Getter
    private String msg;





}
