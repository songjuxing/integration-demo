package com.example.demo.dto.order;

import com.example.demo.annotation.Integration;
import com.example.demo.annotation.Method;
import com.example.demo.annotation.Rpc;
import com.example.demo.dto.common.BaseRequest;
import com.example.demo.dto.common.ResultCode;
import com.example.demo.dto.exception.CommonException;
import com.example.demo.rpc.dto.TestService1ReqDto;
import com.example.demo.rpc.dto.TestService1RespDto;
import com.example.demo.rpc.dto.TestService2ReqDto;
import com.example.demo.rpc.dto.TestService2RespDto;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ConcurrentHashMap;

@Integration(api = "createOrder",
    service = {
        @Rpc(name = "testService1",
                method = {
                @Method(name = "test1", inDtoType = TestService1ReqDto.class, outDtoType = TestService1RespDto.class)}),
        @Rpc(name = "testService2",
                method = {
                        @Method(name = "test2", inDtoType = TestService2ReqDto.class, outDtoType = TestService2RespDto.class)})
    })
public class CreateOrderReq extends BaseRequest {

    private String mchId;

    private String outTradeNo;

    private String amount;

    private String currency;

    public CreateOrderReq() {
        // 初始化存放服务调用的中间结果集
        this.setIntegrateTempResp(new ConcurrentHashMap<>());
    }

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public TestService1ReqDto genInParam(TestService1ReqDto dto) {
        dto.setMchId(this.mchId);
        return dto;
    }

    public void genOutParam(TestService1RespDto dto) {
        if (!StringUtils.isNotBlank(dto.getMchName())) {
            throw new CommonException(ResultCode.UNKWON_EXP);
        }
    }

    public TestService2ReqDto genInParam(TestService2ReqDto dto) {
        dto.setOutTradeNo(this.outTradeNo);
        dto.setMchId(this.mchId);
        dto.setAmount(this.amount);
        TestService1RespDto beforeRes = (TestService1RespDto)this.getIntegrateTempResp().get(this.genMapKey(TestService1ReqDto.class.getName(), "testService1", "test1"));
        dto.setMchName(beforeRes.getMchName());
        return dto;
    }

    public void genOutParam(TestService2RespDto dto) {
        CreateOrderResp createOrderResp = new CreateOrderResp();
        createOrderResp.setTradeNo(dto.getTradeNo());
        TestService1RespDto beforeRes = (TestService1RespDto)this.getIntegrateTempResp().get(this.genMapKey(TestService1ReqDto.class.getName(), "testService1", "test1"));
        createOrderResp.setMchName(beforeRes.getMchName());
        this.setFinalRes(createOrderResp);
    }

    @Override
    public String toString() {
        return "CreateOrderReq{" +
                "mchId='" + mchId + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                "} " + super.toString();
    }

}
