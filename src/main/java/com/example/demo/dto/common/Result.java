package com.example.demo.dto.common;

import com.example.demo.dto.exception.CommonException;

import java.io.Serializable;

public class Result<T extends BaseResponse> implements Serializable {

    private boolean success;

    private String code;

    private String desc;

    private T response;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                ", response=" + response +
                '}';
    }

    public static <T extends BaseResponse> Result<T> createBySuccess(T response) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setDesc(ResultCode.SUCCESS.getDesc());
        result.setResponse(response);
        return result;
    }

    public static <T extends BaseResponse> Result<T> createByError(CommonException e) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setCode(e.getCode());
        result.setDesc(e.getLocalizedMessage());
        return result;
    }
}
