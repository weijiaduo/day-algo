package com.wjd.thinking.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据库表约束条件
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {
    /**
     * 是否是主键
     * @return
     */
    boolean primaryKey() default false;

    /**
     * 是否允许为空
     * @return
     */
    boolean allowNull() default true;

    /**
     * 是否唯一
     * @return
     */
    boolean unique() default false;
}
