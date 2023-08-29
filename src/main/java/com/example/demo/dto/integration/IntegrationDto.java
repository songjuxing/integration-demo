package com.example.demo.dto.integration;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
/**
 * @author songjuxing
 */

public class IntegrationDto implements Serializable {

    private static final String FINAL_RES = "FINAL_RES";

    private Map<String, IntegrationDto> integrateTempResp;

    public void setIntegrateTempResp(Map<String, IntegrationDto> integrateTempResp) {
        this.integrateTempResp = integrateTempResp;
    }

    public Map<String, IntegrationDto> getIntegrateTempResp() {
        return integrateTempResp;
    }


    private final static String GEN_INPUT_METHOD_NAME = "genInParam";

    private final static String GEN_OUTPUT_METHOD_NAME = "genOutParam";

    @SuppressWarnings("unchecked")
    public <T extends IntegrationDto> T genInParam(Class<T> clazz, String serviceName, String methodName) {
        T t = null;
        try {
            Method genInParamMethod = this.getClass().getMethod(GEN_INPUT_METHOD_NAME, clazz);
            t = (T) genInParamMethod.invoke(this, new Object[]{clazz.getConstructor(new Class[]{}).newInstance()});
            integrateTempResp.put(genMapKey(clazz.getName(), serviceName, methodName), t);
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

    public <T extends IntegrationDto> void genOutParam(Class<T> clazz, IntegrationDto dto) {
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

    public String genMapKey(String objectName, String serviceName, String methodName) {
        return objectName + "#" + serviceName + "#" + methodName;
    }

    public <T extends IntegrationDto> T getFinalRes() {
        return (T)integrateTempResp.get(FINAL_RES);
    }

    public <T extends IntegrationDto> void setFinalRes(T t) {
        integrateTempResp.put(FINAL_RES, t);
    }

}
