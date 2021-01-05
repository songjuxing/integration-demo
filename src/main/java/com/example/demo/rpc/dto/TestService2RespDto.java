package com.example.demo.rpc.dto;

import com.example.demo.dto.common.BaseResponse;

public class TestService2RespDto extends BaseResponse {

    private String tradeNo;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    @Override
    public String toString() {
        return "TestService2RespDto{" +
                "tradeNo='" + tradeNo + '\'' +
                "} " + super.toString();
    }
}
