package com.wjd.thinking.annotations.processor;

import com.wjd.thinking.annotations.ExtractInterface;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.util.Elements;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 注解 {@link ExtractInterface} 的处理器
 */
@SupportedAnnotationTypes("com.wjd.learn.annotations.ExtractInterface")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class IfaceExtractorProcessor extends AbstractProcessor {

    /**
     * 接口方法集合
     */
    private ArrayList<Element> interfaceMethods = new ArrayList<>();

    Elements elementUtils;

    /**
     * 处理器环境
     */
    private ProcessingEnvironment processingEnvironment;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        this.processingEnvironment = processingEnv;
        this.elementUtils = processingEnv.getElementUtils();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element el: roundEnv.getElementsAnnotatedWith(ExtractInterface.class)) {
            // 获取生成的接口名称
            String interfaceName = el.getAnnotation(ExtractInterface.class).interfaceName();

            // 查找接口方法
            for (Element enclosed: el.getEnclosedElements()) {
                if (enclosed.getKind().equals(ElementKind.METHOD)
                        && enclosed.getModifiers().contains(Modifier.PUBLIC)
                        && !enclosed.getModifiers().contains(Modifier.STATIC)) {
                    interfaceMethods.add(enclosed);
                }
            }

            // 生成接口
            if (interfaceMethods.size() > 0) {
                writeInterfaceFile(interfaceName);
            }
        }
        return false;
    }

    /**
     * 生成接口源文件
     *
     * @param interfaceName 接口名称
     */
    private void writeInterfaceFile(String interfaceName) {
        try(Writer writer = processingEnvironment.getFiler().createSourceFile(interfaceName).openWriter()) {
            // 包名
            String packageName = elementUtils.getPackageOf(interfaceMethods.get(0)).toString();
            writer.write("package " + packageName + ";\n");

            // 接口声明开始
            writer.write("public interface " + interfaceName + "{\n");
            
            // 接口方法
            for (Element el: interfaceMethods) {
                ExecutableElement method = (ExecutableElement)el;
                String signature = " public ";
                signature += method.getReturnType() + " ";
                signature += method.getSimpleName();
                signature += createArgList(method.getParameters());

                System.out.println(signature);
                writer.write(signature + ";\n");
            }

            // 接口声明结束
            writer.write("}");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成参数字符串
     *
     * @param parameters 参数列表集合
     * @return 参数拼接字符串
     */
    private String createArgList (List<? extends VariableElement> parameters) {
        String args = parameters.stream()
                .map(p -> p.asType() +  " " + p.getSimpleName())
                .collect(Collectors.joining(", "));

        return "(" + args + ")";
    }

}
