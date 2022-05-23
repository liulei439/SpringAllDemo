package com.learning.springbootaoplog.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    String value() default "";

    /**
     * 操作日志类型
     *
     * @return （1查询，2添加，3修改，4删除）
     */
    String operateType() default "0";
}
