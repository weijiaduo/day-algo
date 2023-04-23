package com.wjd.lr.sql;

import java.util.*;

import static com.wjd.lr.expr.type.ValueType.*;

/**
 * SQL 函数集合
 *
 * @author weijiaduo
 * @since 2023/4/5
 */
public final class SqlFunctions {

    /**
     * 函数声明集合
     */
    private static final Map<String, FunctionDescriptor> FUNCTION_MAP = new HashMap<>();

    static {
        // FIXME: 先这样写，后面应该改成读取文件

        // 聚合
        add("avg", new FunctionDescriptor("avg", List.of(NUMERIC), NUMERIC));
        add("count", new FunctionDescriptor("ceiling", List.of(NUMERIC), NUMERIC));
        add("max", new FunctionDescriptor("max", List.of(NUMERIC), NUMERIC));
        add("min", new FunctionDescriptor("min", List.of(NUMERIC), NUMERIC));
        add("sum", new FunctionDescriptor("sum", List.of(NUMERIC), NUMERIC));

        // 数值
        add("abs", new FunctionDescriptor("abs", List.of(NUMERIC), NUMERIC));
        add("ceiling", new FunctionDescriptor("ceiling", List.of(NUMERIC), NUMERIC));
        add("floor", new FunctionDescriptor("floor", List.of(NUMERIC), NUMERIC));
        add("round", new FunctionDescriptor("round", List.of(NUMERIC), NUMERIC));
        add("sign", new FunctionDescriptor("sign", List.of(NUMERIC), NUMERIC));

        // 字符串
        add("lower", new FunctionDescriptor("lower", List.of(STRING), STRING));
        add("replace", new FunctionDescriptor("replace",
                List.of(STRING, STRING, STRING), STRING));
        add("substring", new FunctionDescriptor("substring",
                List.of(STRING, NUMERIC, NUMERIC), STRING));
        add("upper", new FunctionDescriptor("upper", List.of(STRING), STRING));

        // 日期
        add("day", new FunctionDescriptor("day", List.of(DATETIME), STRING));
        add("month", new FunctionDescriptor("month", List.of(DATETIME), STRING));
        add("year", new FunctionDescriptor("year", List.of(DATETIME), STRING));
        add("getdate", new FunctionDescriptor("getdate", Collections.emptyList(), STRING));

        // 选择
        add("nullif", new FunctionDescriptor("nullif",
                List.of(ANY, ANY), ANY));

        // 特殊方法
        add("casewhen", new FunctionDescriptor("casewhen",  List.of(), ANY));
        add("between", new FunctionDescriptor("between",  List.of(), ANY));
        add("in", new FunctionDescriptor("in",  List.of(), ANY));
    }

    /**
     * 添加函数签名
     *
     * @param funcName   函数名称
     * @param descriptor 函数签名
     */
    public static void add(String funcName, FunctionDescriptor descriptor) {
        FUNCTION_MAP.put(funcName, descriptor);
    }

    /**
     * 获取指定函数名称的函数签名
     *
     * @param funcName 函数名称
     * @return 函数签名
     */
    public static FunctionDescriptor get(String funcName) {
        return FUNCTION_MAP.get(funcName);
    }

    /**
     * 获取所有的函数签名
     *
     * @return 函数签名集合
     */
    public static List<FunctionDescriptor> getAll() {
        return new ArrayList<>(FUNCTION_MAP.values());
    }

}
