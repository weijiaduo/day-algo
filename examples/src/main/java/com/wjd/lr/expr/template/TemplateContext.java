package com.wjd.lr.expr.template;

import com.wjd.lr.expr.template.fucntion.FunctionContext;
import com.wjd.lr.expr.template.variable.VariableContext;
import org.mvel2.ParserContext;
import org.mvel2.util.MethodStub;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 模板上下文
 *
 * @author weijiaduo
 * @since 2023/3/8
 */
public class TemplateContext {

    /**
     * 执行上下文
     */
    protected Map<String, Object> executeContext;
    /**
     * 解析上下文
     */
    private ParserContext parserContext;
    /**
     * 函数上下文
     */
    private FunctionContext functionContext;
    /**
     * 变量上下文
     */
    private VariableContext variableContext;

    /**
     * @return 解析上下文
     */
    public ParserContext getParseContext() {
        if (parserContext != null) {
            return parserContext;
        }

        parserContext = new ParserContext();
        Map<String, Object> functions = getFunctionContext().getFunctions();
        for (String name : functions.keySet()) {
            Object m = functions.get(name);
            if (m instanceof Method) {
                parserContext.addImport(name, new MethodStub((Method) m));
            }
        }
        return parserContext;
    }

    /**
     * @return 运行上下文
     */
    public Map<String, Object> getExecuteContext() {
        if (executeContext != null) {
            return executeContext;
        }

        executeContext = new HashMap<>();
        executeContext.putAll(getVariableContext().getVariables());
        return executeContext;
    }

    /**
     * @return 函数上下文
     */
    public FunctionContext getFunctionContext() {
        if (functionContext == null) {
            functionContext = new FunctionContext();
        }
        return functionContext;
    }

    /**
     * @return 变量上下文
     */
    public VariableContext getVariableContext() {
        if (variableContext == null) {
            variableContext = new VariableContext();
        }
        return variableContext;
    }

    /**
     * @param functionContext 函数上下文
     */
    public void setFunctionContext(FunctionContext functionContext) {
        this.functionContext = functionContext;
    }

    /**
     * @param variableContext 变量上下文
     */
    public void setVariableContext(VariableContext variableContext) {
        this.variableContext = variableContext;
    }

}
