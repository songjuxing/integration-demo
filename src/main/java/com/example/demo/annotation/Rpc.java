package com.example.demo.annotation;

import java.lang.annotation.*;
/**
 * @author songjuxing
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE})
@Inherited
public @interface Rpc {

    String name();

    Method[] method();
}
