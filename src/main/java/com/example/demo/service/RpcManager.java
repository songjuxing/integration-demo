package com.example.demo.service;

import com.example.demo.dto.common.BaseRequest;
import com.example.demo.dto.common.BaseResponse;
import com.example.demo.dto.common.Result;

/**
 * @author songjuxing
 */
public interface RpcManager {

    /**
     * 服务调用
     * @param rpcName 服务名称
     * @param rpcMethod 服务方法名
     * @param request 服务请求体
     * @return 服务响应体
     */
    Result<? extends BaseResponse> invoke(String rpcName, String rpcMethod, BaseRequest request);
}
