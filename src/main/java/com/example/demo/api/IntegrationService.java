package com.example.demo.api;

import com.example.demo.dto.common.Result;
import com.example.demo.dto.order.CreateOrderReq;
import com.example.demo.dto.order.CreateOrderResp;

/**
 * 服务编排提供
 * @author songjuxing
 */
public interface IntegrationService {

    /**
     * 收单-预下单
     * @param req 下单请求
     * @return    下单返回
     */
    Result<CreateOrderResp> createOrder(CreateOrderReq req);
}
