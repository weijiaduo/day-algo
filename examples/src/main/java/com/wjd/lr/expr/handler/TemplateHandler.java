package com.wjd.lr.expr.handler;

import com.wjd.lr.expr.ExprVisitor;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.var.fucntion.math.SysMathFunctions;
import com.wjd.lr.expr.var.fucntion.str.SysStrFunctions;
import org.mvel2.MVEL;
import org.mvel2.ParserContext;
import org.mvel2.compiler.CompiledExpression;
import org.mvel2.compiler.ExpressionCompiler;
import org.mvel2.integration.impl.StaticMethodImportResolverFactory;
import org.mvel2.util.MethodStub;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * 模板规则处理器
 *
 * @author weijiaduo
 * @since 2023/3/7
 */
public class TemplateHandler extends BaseRuleHandler<ExprParser.TemplateContext> {

    /**
     * 表达式解析的上下文
     */
    private final ParserContext ctx;
    /**
     * 表达式执行用到的变量
     */
    protected final Map<String, Object> vars;

    public TemplateHandler(ExprVisitor visitor) {
        super(visitor);
        ctx = new ParserContext();
        vars = new HashMap<>();
        registerMethods();
        initEnvironmentVars();
    }

    /**
     * 注册解析可以用的方法
     */
    private void registerMethods() {
        registerMethods(SysStrFunctions.class);
        registerMethods(SysMathFunctions.class);
    }

    /**
     * 注册整个类的所有 public 方法
     *
     * @param clazz 指定类
     */
    private void registerMethods(Class<?> clazz) {
        for (Method m : clazz.getDeclaredMethods()) {
            if (Modifier.isPublic(m.getModifiers())
                    && Modifier.isStatic(m.getModifiers())) {
                ctx.addImport(m.getName(), new MethodStub(m));
            }
        }
    }

    /**
     * 初始化环境变量（基本不会变动的变量）
     */
    private void initEnvironmentVars() {
        // TODO: need collect stable vars
    }

    @Override
    public String handle(ExprParser.TemplateContext tempCtx) {
        // 实时更新
        prepareVars();

        // 解析脚本表达式
        String scriptText = parseScriptText(tempCtx);
        ExpressionCompiler compiler = new ExpressionCompiler(scriptText, ctx);
        CompiledExpression compiledExpr = compiler.compile();

        // 执行模板脚本
        Object result = MVEL.executeExpression(compiledExpr, vars, new StaticMethodImportResolverFactory(ctx));
        return String.valueOf(result);
    }

    /**
     * 解析模板内部的脚本
     *
     * @param ctx 模板上下文
     * @return 模板脚本
     */
    private String parseScriptText(ExprParser.TemplateContext ctx) {
        // No need to visit inner script
        String expr = ctx.getText();
        if (expr != null && expr.length() > 3) {
            // remove template brace ${}
            expr = expr.substring(2, expr.length() - 1);
        } else {
            expr = "";
        }
        return expr;
    }

    /**
     * 更新实时的环境变量
     */
    protected void prepareVars() {
        // TODO: need dynamic collect variable
    }

}
