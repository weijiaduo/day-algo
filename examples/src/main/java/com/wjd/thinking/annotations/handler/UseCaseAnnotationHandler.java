package com.wjd.thinking.annotations.handler;

import com.wjd.thinking.annotations.UseCase;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 注解 {@link com.wjd.thinking.annotations.UseCase} 的处理器
 */
public class UseCaseAnnotationHandler implements AnnotationHandler {

    /**
     * 注解处理
     *
     * @param useCases 注解器处理对象
     * @param cl 指定要处理的注解类对象
     */
    public static void handle(List<Integer> useCases, Class<?> cl) {
        for (Method m: cl.getDeclaredMethods()) {
            UseCase useCase = m.getAnnotation(UseCase.class);
            if (useCase != null) {
                System.out.println("Found use case: " + useCase.id() + " " + useCase.description());
                useCases.remove(Integer.valueOf(useCase.id()));
            }
        }

        for (int i: useCases) {
            System.out.println("Warning: missing use case-" + i);
        }
    }

}
