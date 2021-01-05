package com.example.demo.rpc;

import com.example.demo.dto.common.Result;
import com.example.demo.rpc.dto.TestService2ReqDto;
import com.example.demo.rpc.dto.TestService2RespDto;

public interface TestService2 {

    Result<TestService2RespDto> test2(TestService2ReqDto testService2ReqDto);
}
