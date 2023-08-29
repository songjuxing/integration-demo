package com.example.demo.dto.common;

/**
 * @author songjuxing
 */

public enum ResultCode {

    /**
     * 成功
     */
    SUCCESS("000000", "成功"),

    /**
     * 未知异常
     */
    UNKNOWN_EXP("999999", "未知异常"),
    ;

    private String code;

    private String desc;

    ResultCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
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

    @Override
    public String toString() {
        return "ResultCode{" +
                "code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                "} " + super.toString();
    }
}
