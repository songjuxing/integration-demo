package com.example.demo.service.impl;

import com.example.demo.dto.common.BaseRequest;
import com.example.demo.dto.common.BaseResponse;
import com.example.demo.dto.common.Result;
import com.example.demo.service.RpcManager;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * @author songjuxing
 */
@Service("rpcManager")
public class RpcManagerImpl implements ApplicationContextAware, RpcManager {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public Result<? extends BaseResponse> invoke(String rpcName, String rpcMethod, BaseRequest request) {
        Result<? extends BaseResponse> res = null;
        try {
            Object bean = applicationContext.getBean(rpcName);
            Method method = bean.getClass().getMethod(rpcMethod, BaseRequest.class);
            res = (Result<? extends BaseResponse>)method.invoke(bean, request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }


}
