package com.wjd.annotations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(RepeatableContainer.class)
public @interface RepeatableAnnotation {
}