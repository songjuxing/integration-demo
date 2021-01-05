package com.example.demo.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE})
@Inherited
public @interface Rpc {

    String name();

    Method[] method();
}
