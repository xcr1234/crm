package com.oraclewdp.crm.persistence;

import java.lang.annotation.*;

/**
 * 表示是一列，当列名称与字段名不同时 或者有外键时可以取
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

    public String value() default "";

    public String foreign() default "";

    public String target() default "";


}
