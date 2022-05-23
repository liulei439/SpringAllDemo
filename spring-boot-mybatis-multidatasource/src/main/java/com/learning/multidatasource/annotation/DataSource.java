package com.learning.multidatasource.annotation;
 
import java.lang.annotation.*;
/**
 * 1.多数据源注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "";
}