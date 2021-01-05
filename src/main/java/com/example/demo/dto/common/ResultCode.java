package com.example.demo.dto.common;

public enum ResultCode {

    SUCCESS("000000", "成功"),


    UNKWON_EXP("999999", "成功"),
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
