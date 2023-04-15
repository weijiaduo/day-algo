package com.wjd.annotations;

import java.lang.annotation.Annotation;

/**
 * @since 2022/1/1
 */
@UnRepeatableAnnotation
public class RepeatableTest {

    public static void main(String[] args) {
        // 多个重复注解时，通过原注解类找不到注解了
        RepeatableAnnotation a = SubClass.class.getAnnotation(RepeatableAnnotation.class);
        System.out.println(a);
        // 多个重复注解，需要通过注解的容器类找
        RepeatableContainer container = SubClass.class.getAnnotation(RepeatableContainer.class);
        for (Annotation an : container.value()) {
            System.out.println(an);
        }
    }

}
