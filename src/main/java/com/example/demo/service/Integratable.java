package com.example.demo.service;

import com.example.demo.dto.integration.IntegrationDto;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author songjuxing
 */
public interface Integratable {

    String GEN_INPUT_METHOD_NAME = "genInParam";

    String GEN_OUTPUT_METHOD_NAME = "genOutParam";

    /**
     * 获取入参
     * @param clazz Class<T>
     * @param <T> IntegrationDto
     * @return IntegrationDto
     */
    @SuppressWarnings("unchecked")
    public default <T extends IntegrationDto> T genInParam(Class<T> clazz) {
        T t = null;
        try {
            Method genInParamMethod = this.getClass().getMethod(GEN_INPUT_METHOD_NAME, clazz);
            t = (T) genInParamMethod.invoke(this, new Object[]{clazz.getConstructor(new Class[]{}).newInstance()});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 获取出参
     * @param clazz Class<T>
     * @param dto IntegrationDto
     * @param <T> IntegrationDto
     */
    default <T extends IntegrationDto> void genOutParam(Class<T> clazz, IntegrationDto dto) {
        try {
            Method genInParamMethod = this.getClass().getMethod(GEN_OUTPUT_METHOD_NAME, clazz);
            genInParamMethod.invoke(this, dto);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
