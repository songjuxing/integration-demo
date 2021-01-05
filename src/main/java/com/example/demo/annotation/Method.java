package com.example.demo.annotation;

import com.example.demo.dto.integration.IntegrationDto;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE})
@Inherited
public @interface Method {

    String name();

    Class<? extends IntegrationDto> inDtoType();

    Class<? extends IntegrationDto> outDtoType();

}
