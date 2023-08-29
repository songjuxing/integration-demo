package com.example.demo.rpc;

import com.example.demo.dto.common.Result;
import com.example.demo.rpc.dto.TestService1ReqDto;
import com.example.demo.rpc.dto.TestService1RespDto;

/**
 * @author sngjuxing
 */
public interface TestService1 {

    /**
     * test1 测试服务1
     * @param testService1ReqDto TestService1ReqDto
     * @return Result<TestService1RespDto>
     */
    Result<TestService1RespDto> test1(TestService1ReqDto testService1ReqDto);
}
