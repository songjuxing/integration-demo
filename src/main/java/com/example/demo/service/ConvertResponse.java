package com.example.demo.service;

import com.example.demo.dto.common.BaseRequest;
import com.example.demo.dto.common.BaseResponse;

/**
 * @author songjuxing
 */
public interface ConvertResponse {

    /**
     * 设置返回信息
     * @param request BaseRequest
     * @return BaseResponse
     */
    BaseResponse setFinalResponse(BaseRequest request);
}
