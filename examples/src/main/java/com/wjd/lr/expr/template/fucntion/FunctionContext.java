package com.wjd.lr.expr.template.fucntion;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 函数上下文
 *
 * @author weijiaduo
 * @since 2023/3/8
 */
public class FunctionContext {

    /**
     * 类文件拓展名
     */
    public static final String CLASS_FILE_EXT_NAME = ".class";
    /**
     * 系统函数列表（不可修改）
     */
    private static volatile Map<String, Object> sysFunctions;
    /**
     * 所有函数集合
     */
    private Map<String, Object> functions;

    /**
     * 获取所有函数
     *
     * @return 函数集合
     */
    public Map<String, Object> getFunctions() {
        if (functions == null) {
            if (sysFunctions == null) {
                loadSysFunctions();
            }
            functions = new HashMap<>(sysFunctions);
        }
        return functions;
    }

    /**
     * 注册函数
     *
     * @param name   函数名
     * @param method 函数方法
     */
    public void register(String name, Method method) {
        getFunctions().put(name, method);
    }

    /**
     * 注册整个类的所有 public static 方法
     *
     * @param clazz 指定类
     */
    public void registerAll(Class<?> clazz) {
        for (Method m : clazz.getDeclaredMethods()) {
            if (registrable(m)) {
                getFunctions().put(m.getName(), m);
            }
        }
    }

    /**
     * 加载函数
     */
    private static synchronized void loadSysFunctions() {
        if (sysFunctions != null) {
            return;
        }
        try {
            Class<?>[] classes = collectClassesInDirectory(FunctionContext.class);
            Map<String, Object> funcMap = Arrays.stream(classes)
                    .flatMap(c -> Arrays.stream(c.getDeclaredMethods())
                            .filter(FunctionContext::registrable))
                    .collect(Collectors.toMap(Method::getName, m -> m));
            sysFunctions = Collections.unmodifiableMap(funcMap);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 验证函数是否可以注册
     * <p>
     * 暂时只支持 public static 方法
     *
     * @param m 函数
     * @return true/false
     */
    private static boolean registrable(Method m) {
        return Modifier.isPublic(m.getModifiers())
                && Modifier.isStatic(m.getModifiers());
    }

    /**
     * 遍历类所在目录下的所有接口测试类.
     *
     * @param entryClass 入口类
     * @return 接口测试类
     */
    private static Class<?>[] collectClassesInDirectory(Class<?> entryClass) throws Exception {
        List<Class<?>> classes = new ArrayList<>();
        String basePath = resolveBasePath(entryClass);
        File classFile = getClassFile(entryClass);
        // 收集类所在目录和子目录的所有类文件
        List<File> classFiles = collectClassFiles(classFile.getParentFile());
        for (File item : classFiles) {
            // 根据类文件路径解析出类名
            String className = resolveClassName(basePath, item.getCanonicalPath());
            Class<?> clazz = Class.forName(className);
            if (clazz.equals(entryClass)) {
                continue;
            }
            classes.add(clazz);
        }
        return classes.toArray(new Class[0]);
    }

    /**
     * 解析出类文件所在的编译目录
     *
     * @param clazz 类
     * @return 编译目录
     * @throws IOException e
     */
    private static String resolveBasePath(Class<?> clazz) throws IOException {
        File classFile = getClassFile(clazz);
        String basePath = classFile.getCanonicalPath();
        // 去除类文件拓展名
        basePath = removeClassFileExtName(basePath);
        // 将包名转成路径
        String packagePath = String.join(File.separator, clazz.getName().split("\\."));
        // 去除包名和类名
        basePath = basePath.substring(0, basePath.length() - packagePath.length());
        return basePath;
    }

    /**
     * 从类文件路径中解析出类名
     *
     * @param basePath      基础路径
     * @param classFilePath class文件路径
     * @return 类名
     */
    private static String resolveClassName(String basePath, String classFilePath) {
        String className = classFilePath.replace(basePath, "");
        className = className.replace(File.separator, ".");
        // 去除class拓展名
        className = removeClassFileExtName(className);
        return className;
    }

    /**
     * 移除类文件路径的拓展名
     *
     * @param classFilePath 类文件路径
     * @return 去除拓展名后的路径
     */
    private static String removeClassFileExtName(String classFilePath) {
        int length = classFilePath.length() - CLASS_FILE_EXT_NAME.length();
        return classFilePath.substring(0, length);
    }

    /**
     * 扫描当前目录以及子目录的类文件(忽略文件名带$符的内部类)
     *
     * @param dir 当前目录
     * @return 类文件集合
     */
    private static List<File> collectClassFiles(File dir) {
        List<File> classFiles = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        queue.offer(dir);
        while (queue.size() > 0) {
            File file = queue.poll();
            String fileName = file.getName();
            // 收集class文件,跳过内部类(文件名包含$符)
            if (file.isFile() && fileName.endsWith(CLASS_FILE_EXT_NAME) && !fileName.contains("$")) {
                classFiles.add(file);
            } else if (file.isDirectory()) {
                for (File item : Objects.requireNonNull(file.listFiles())) {
                    queue.offer(item);
                }
            }
        }
        return classFiles;
    }

    /**
     * 获取类对应的 .class 文件
     *
     * @param clazz 类
     * @return .class 文件
     */
    private static File getClassFile(Class<?> clazz) {
        // 将url路径转成文件路径
        String filePath = getClassFileURL(clazz).getFile();
        // url中的中文被编码过，需要先解码再使用
        filePath = URLDecoder.decode(filePath, StandardCharsets.UTF_8);
        return new File(filePath);
    }

    /**
     * 获取类的 URL 地址
     *
     * @param clazz 类
     * @return URL 地址
     */
    private static URL getClassFileURL(Class<?> clazz) {
        // 将包名中的 . 转成url路径的 /
        String classFilePath = clazz.getName().replaceAll("\\.", "/");
        // 路径以 / 开头,以 .class 结尾
        classFilePath = "/" + classFilePath + CLASS_FILE_EXT_NAME;
        return clazz.getResource(classFilePath);
    }

}
