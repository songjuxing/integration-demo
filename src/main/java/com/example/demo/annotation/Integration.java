package com.example.demo.annotation;

import java.lang.annotation.*;
/**
 * @author songjuxing
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
public @interface Integration {

    String api();

    Rpc[] service();
}
