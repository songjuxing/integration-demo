package com.example.demo.rpc.dto;

import com.example.demo.dto.common.BaseRequest;

public class TestService2ReqDto extends BaseRequest {

    private String mchId;

    private String outTradeNo;

    private String amount;

    private String mchName;

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMchName() {
        return mchName;
    }

    public void setMchName(String mchName) {
        this.mchName = mchName;
    }

    @Override
    public String toString() {
        return "TestService2ReqDto{" +
                "mchId='" + mchId + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", amount='" + amount + '\'' +
                ", mchName='" + mchName + '\'' +
                "} " + super.toString();
    }
}
