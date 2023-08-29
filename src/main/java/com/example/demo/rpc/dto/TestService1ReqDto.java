package com.example.demo.rpc.dto;

import com.example.demo.dto.common.BaseRequest;
/**
 * @author songjuxing
 */
public class TestService1ReqDto extends BaseRequest {

    private String mchId;

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    @Override
    public String toString() {
        return "TestService1ReqDto{" +
                "mchId='" + mchId + '\'' +
                "} " + super.toString();
    }
}
