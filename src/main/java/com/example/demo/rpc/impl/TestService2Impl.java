package com.example.demo.rpc.impl;

import com.example.demo.dto.common.Result;
import com.example.demo.rpc.TestService2;
import com.example.demo.rpc.dto.TestService2ReqDto;
import com.example.demo.rpc.dto.TestService2RespDto;
import org.springframework.stereotype.Service;
/**
 * @author songjuxing
 */
@Service("testService2")
public class TestService2Impl implements TestService2 {
    @Override
    public Result<TestService2RespDto> test2(TestService2ReqDto testService2ReqDto) {
        TestService2RespDto respDto = new TestService2RespDto();
        respDto.setTradeNo("223153489871325888515");
        return Result.createBySuccess(respDto);
    }
}
