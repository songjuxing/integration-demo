package com.example.demo.service;

import com.example.demo.dto.common.BaseRequest;
import com.example.demo.dto.common.BaseResponse;
import com.example.demo.dto.common.Result;

public interface RpcManager {

    Result<? extends BaseResponse> invoke(String rpcName, String rpcMethod, BaseRequest request);
}
