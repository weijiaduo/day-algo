package com.wjd.lr.expr.template.variable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 环境变量上下文
 *
 * @author weijiaduo
 * @since 2023/3/8
 */
public class VariableContext {

    /**
     * 系统变量集合（不可修改）
     */
    private static volatile Map<String, Object> sysVariables;
    /**
     * 变量集合
     */
    private Map<String, Object> variables;

    /**
     * 获取所有变量
     *
     * @return 变量集合
     */
    public Map<String, Object> getVariables() {
        if (variables == null) {
            if (sysVariables == null) {
                loadSysVariables();
            }
            variables = new HashMap<>();
        }

        // TODO: need more variables, like parameters
        return variables;
    }

    /**
     * 注册变量
     *
     * @param name  变量名
     * @param value 变量值
     */
    public void register(String name, Object value) {
        getVariables().put(name, value);
    }

    /**
     * 按照路径注册变量值
     *
     * @param path  路径
     * @param value 值
     */
    public void registerByPath(String path, Object value) {
        String[] keys = path.split("\\.");
        Map<String, Object> cur = variables;
        for (int i = 0; i < keys.length - 1; i++) {
            @SuppressWarnings("unchecked")
            Map<String, Object> next = (Map<String, Object>) cur.get(keys[i]);
            if (next == null) {
                next = new HashMap<>();
                cur.put(keys[i], next);
            }
            cur = next;
        }
        cur.put(keys[keys.length - 1], value);
    }

    /**
     * 加载系统环境变量
     */
    private static synchronized void loadSysVariables() {
        if (sysVariables != null) {
            return;
        }

        Map<String, Object> varMap = new HashMap<>();
        varMap.putAll(loadUserProps());
        sysVariables = Collections.unmodifiableMap(varMap);
    }

    /**
     * 获取用户属性
     *
     * @return 用户属性映射
     */
    private static Map<String, Object> loadUserProps() {
        // FIXME: just test
        Map<String, Object> props = new HashMap<>();
        props.put("userId", "admin");
        props.put("userName", "test");
        return props;
    }

}
