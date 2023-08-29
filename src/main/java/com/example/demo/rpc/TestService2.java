package com.example.demo.rpc;

import com.example.demo.dto.common.Result;
import com.example.demo.rpc.dto.TestService2ReqDto;
import com.example.demo.rpc.dto.TestService2RespDto;

/**
 * @author songjuxing
 */
public interface TestService2 {

    /**
     * 测试服务2
     * @param testService2ReqDto TestService2ReqDto
     * @return Result<TestService2RespDto>
     */
    Result<TestService2RespDto> test2(TestService2ReqDto testService2ReqDto);
}
