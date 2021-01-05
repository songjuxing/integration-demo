package com.example.demo.rpc.dto;

import com.example.demo.dto.common.BaseResponse;


public class TestService1RespDto extends BaseResponse {

    private String mchId;

    private String mchName;

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getMchName() {
        return mchName;
    }

    public void setMchName(String mchName) {
        this.mchName = mchName;
    }

    @Override
    public String toString() {
        return "TestService1RespDto{" +
                "mchId='" + mchId + '\'' +
                ", mchName='" + mchName + '\'' +
                "} " + super.toString();
    }
}
