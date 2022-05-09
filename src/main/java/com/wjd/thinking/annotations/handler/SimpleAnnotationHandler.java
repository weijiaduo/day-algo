package com.wjd.thinking.annotations.handler;

import com.wjd.thinking.annotations.Simple;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * 注解 {@link com.wjd.thinking.annotations.Simple} 的处理器
 */
@SupportedAnnotationTypes("com.wjd.learn.annotations.Simple")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class SimpleAnnotationHandler extends AbstractProcessor implements AnnotationHandler {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement el: annotations) {
            System.out.println(el);
        }

        for (Element el: roundEnv.getElementsAnnotatedWith(Simple.class)) {
            display(el);
        }

        return false;
    }

    /**
     * 打印信息
     *
     * @param el 打印元素
     */
    private void display(Element el) {
        System.out.println("==== " + el + " ====");
        System.out.println(el.getKind()
                + " : " + el.getModifiers()
                + " : " + el.getSimpleName()
                + " : " + el.asType());

        if (el.getKind().equals(ElementKind.CLASS)) {
            TypeElement typeElement = (TypeElement) el;
            System.out.println(typeElement.getQualifiedName());
            System.out.println(typeElement.getSuperclass());
            System.out.println(typeElement.getEnclosedElements());
        }

        if (el.getKind().equals(ElementKind.METHOD)) {
            ExecutableElement executableElement = (ExecutableElement) el;
            System.out.print(executableElement.getReturnType() + " ");
            System.out.print(executableElement.getSimpleName() + "(");
            System.out.println(executableElement.getParameters() + ")");
        }
    }
}
