package com.example.demo.service;

import com.example.demo.dto.integration.IntegrationDto;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author songjuxing
 */
public interface Integratable {

    final static String GEN_INPUT_METHOD_NAME = "genInParam";

    final static String GEN_OUTPUT_METHOD_NAME = "genOutParam";

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
