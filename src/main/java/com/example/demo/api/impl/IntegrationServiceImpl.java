package com.example.demo.api.impl;

import com.example.demo.api.IntegrationService;
import com.example.demo.dto.common.Result;
import com.example.demo.dto.common.ResultCode;
import com.example.demo.dto.exception.CommonException;
import com.example.demo.dto.order.CreateOrderReq;
import com.example.demo.dto.order.CreateOrderResp;
import com.example.demo.service.IntegrationManager;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
/**
 * @author songjuxing
 */
@DubboService(group = "${dubbo.provider.group}", version = "${dubbo.provider.verion}")
public class IntegrationServiceImpl implements IntegrationService {

    @Resource
    private IntegrationManager integrationManager;

    /**
     * 收单-预下单
     *
     * @param req 下单请求
     * @return 下单返回
     */
    @Override
    public Result<CreateOrderResp> createOrder(CreateOrderReq req) {
        try {
            return Result.createBySuccess(integrationManager.execute(req).getFinalRes());
        } catch (Exception e) {
            return Result.createByError(new CommonException(ResultCode.UNKNOWN_EXP));
        }
    }
}
