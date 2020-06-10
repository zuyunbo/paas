package com.cloud.annotation;


import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonResultFilter {

    BeanFilter[] value();

}
