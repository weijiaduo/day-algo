package com.wjd.thinking.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义 SQL 字符串类型
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLString {
    /**
     * 字符串最大长度
     * @return
     */
    int value() default 0;

    /**
     * 字符串值
     * @return
     */
    String name() default "";

    /**
     * 约束条件
     * @return
     */
    Constraints constraints() default @Constraints;
}
