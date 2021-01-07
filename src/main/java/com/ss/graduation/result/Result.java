package com.ss.graduation.result;

import com.ss.graduation.enums.StatusCodeEnum;


import java.io.Serializable;

public class Result<T> implements Serializable {

    private static final Result SUCCESS;

    private static final Result ERROR;

    private boolean success = true;//请求成功true，请求失败false

    private String message;//保留字段

    private String code;//状态码

    private T content;//返回的内容

    public Result() {
    }

    public static Result buildSuccessResult() {
        return SUCCESS;
    }

    public static Result buildErrorResult() {
        return ERROR;
    }

    public static <T> Result<T> buildSuccessResult(T result) {
        Result bizResult = new Result();
        bizResult.setSuccess(true);
        bizResult.setCode(StatusCodeEnum.SUCCESS_OK.getCode());
        bizResult.setContent(result);
        return bizResult;
    }

    public static <T> Result<T> buildErrorResult(String errorCode, T result) {
        Result bizResult = new Result();
        bizResult.setCode(errorCode);
        bizResult.setContent(result);
        bizResult.setSuccess(false);
        return bizResult;
    }

    public static <T> Result<T> buildErrorResult(StatusCodeEnum errorCode,T result) {
        Result bizResult = new Result();
        bizResult.setCode(errorCode.getCode());
        bizResult.setContent(result);
        bizResult.setSuccess(false);
        return bizResult;
    }

    public static <T> Result<T> buildErrorResult(StatusCodeEnum statusCodeEnum) {
        Result bizResult = new Result();
        bizResult.setCode(statusCodeEnum.getCode());
        bizResult.setMessage(statusCodeEnum.getMsg());
        bizResult.setSuccess(false);
        return bizResult;
    }

    public static <T> Result<T> buildErrorResult(T result) {
        Result bizResult = new Result();
        bizResult.setContent(result);
        bizResult.setSuccess(false);
        return bizResult;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getContent() {
        return this.content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public static <T> Result<T> empty() {
        return buildSuccessResult(null);
    }

    static {
        new Result<>();
        SUCCESS = buildSuccessResult(null);
        new Result();
        ERROR = buildErrorResult(StatusCodeEnum.SYS_ERROR, "系统错误");
    }
}
