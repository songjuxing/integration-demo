package com.example.demo.service.impl;

import com.example.demo.annotation.Integration;
import com.example.demo.annotation.Method;
import com.example.demo.annotation.Rpc;
import com.example.demo.dto.common.BaseRequest;
import com.example.demo.dto.common.BaseResponse;
import com.example.demo.dto.common.Result;
import com.example.demo.dto.integration.IntegrationDto;
import com.example.demo.service.IntegrationManager;
import com.example.demo.service.RpcManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * @author songjuxing
 */
@Service("integrationManager")
public class IntegrationManagerImpl implements IntegrationManager {

    @Resource
    private RpcManager rpcManager;
    /**
     * 服务编排
     *
     * @param dto 服务请求对象
     * @return 服务返回对象
     */
    @Override
    public <T extends IntegrationDto> T execute(T dto) throws Exception {
        Integration integration = dto.getClass().getAnnotation(Integration.class);
        for (Rpc rpc : integration.service()) {
            for (Method method : rpc.method()) {
               BaseRequest request =  (BaseRequest)dto.genInParam(method.inDtoType(), rpc.name(), method.name());
               Result<? extends BaseResponse> result =  rpcManager.invoke(rpc.name(), method.name(), request);
               if (result == null) {
                   throw new Exception("a");
               }
               if (!result.isSuccess()) {
                   throw new Exception("b");
               }
                dto.genOutParam(method.outDtoType(), result.getResponse());
            }
        }
        return dto;
    }
}
