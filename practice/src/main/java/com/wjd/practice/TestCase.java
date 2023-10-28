package com.wjd.practice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 测试用例注解
 *
 * @author weijiaduo
 * @since 2023/6/28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface TestCase {

    /**
     * 输入用例
     */
    String[] input() default {};

    /**
     * 输出用例
     */
    String[] output() default {};

}
