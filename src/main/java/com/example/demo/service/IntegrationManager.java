package com.example.demo.service;

import com.example.demo.dto.integration.IntegrationDto;
/**
 * @author songjuxing
 */
public interface IntegrationManager {

    /**
     * 服务编排
     * @param dto 服务请求对象
     * @param <T> 所有服务请求与返回继承于IntegrationDto一个基类
     * @return    服务返回对象
     * @throws Exception 服务异常
     */
    <T extends IntegrationDto> T execute(T dto) throws Exception;
}
