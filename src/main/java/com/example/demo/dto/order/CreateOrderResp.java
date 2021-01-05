package com.example.demo.dto.order;

import com.example.demo.dto.common.BaseResponse;


public class CreateOrderResp extends BaseResponse {

    private String tradeNo;

    private String mchName;

    public CreateOrderResp() {
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getMchName() {
        return mchName;
    }

    public void setMchName(String mchName) {
        this.mchName = mchName;
    }

    @Override
    public String toString() {
        return "CreateOrderResp{" +
                "tradeNo='" + tradeNo + '\'' +
                "mchName='" + mchName + '\'' +
                '}';
    }
}
