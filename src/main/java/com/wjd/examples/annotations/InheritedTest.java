package com.wjd.examples.annotations;

import java.lang.annotation.Annotation;

/**
 * @since 2022/1/1
 */
public class InheritedTest {

    public static void main(String[] args) {
        Annotation[] annotations = SubClass.class.getAnnotations();
        for (Annotation an : annotations) {
            System.out.println(an);
        }
    }

}
