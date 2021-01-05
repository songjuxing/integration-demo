package com.example.demo.rpc.impl;

import com.example.demo.dto.common.Result;
import com.example.demo.rpc.TestService1;
import com.example.demo.rpc.dto.TestService1ReqDto;
import com.example.demo.rpc.dto.TestService1RespDto;
import org.springframework.stereotype.Service;

@Service("testService1")
public class TestService1Impl implements TestService1 {


    @Override
    public Result<TestService1RespDto> test1(TestService1ReqDto testService1ReqDto) {
        TestService1RespDto respDto = new TestService1RespDto();
        respDto.setMchId(testService1ReqDto.getMchId());
        respDto.setMchName("DCEP");
        return Result.createBySuccess(respDto);
    }
}
