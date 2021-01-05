package com.example.demo.rpc;

import com.example.demo.dto.common.Result;
import com.example.demo.rpc.dto.TestService1ReqDto;
import com.example.demo.rpc.dto.TestService1RespDto;

public interface TestService1 {

    Result<TestService1RespDto> test1(TestService1ReqDto testService1ReqDto);
}
