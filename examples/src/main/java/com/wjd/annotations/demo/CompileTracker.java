package com.wjd.annotations.demo;

import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Set;

/**
 * @since 2022/1/1
 */
@AutoService(Processor.class)
@SupportedAnnotationTypes({"com.wjd.practice.annotations.demo.UseCase"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class CompileTracker extends AbstractProcessor {

    private Filer filer;
    private Messager messager;
    private int round;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        filer = processingEnv.getFiler();
        messager = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        round++;
        messager.printMessage(Diagnostic.Kind.NOTE, "round = " + round);
        for (TypeElement typeElement : annotations) {
            messager.printMessage(Diagnostic.Kind.NOTE, "annotation: " + typeElement);
            Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(typeElement);
            for (Element el : elements) {
                messager.printMessage(Diagnostic.Kind.NOTE, "target: " + el);
            }
        }
        // String resultPath = "com.wjd.practice.annotations.demo.GenerateSource";
        // generateFile(resultPath);
        return true;
    }


    private void generateFile(String path) {
        BufferedWriter writer = null;
        try {
            JavaFileObject sourceFile = filer.createSourceFile(path);
            int period = path.lastIndexOf('.');
            String clazzPackage = period > 0 ? path.substring(0, period) : null;
            String clazz = path.substring(period + 1);

            writer = new BufferedWriter(sourceFile.openWriter());
            if (clazzPackage != null) {
                writer.write("package " + clazzPackage + ";\n\n");
            }
            writer.write("/** Compile Generated */\n");
            writer.write("public class " + clazz + " {\n");
            writer.write("}\n");
        } catch (IOException e) {
            messager.printMessage(Diagnostic.Kind.ERROR, "Write source file error: " + path);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                }
            }
        }
    }

}
