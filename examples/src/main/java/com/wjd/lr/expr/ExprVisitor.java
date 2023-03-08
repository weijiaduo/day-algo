package com.wjd.lr.expr;

import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.antlr.ExprParserBaseVisitor;
import com.wjd.lr.expr.handler.ColumnRefHandler;
import com.wjd.lr.expr.handler.GeneralFuncHandler;
import com.wjd.lr.expr.handler.NativeFuncHandler;
import com.wjd.lr.expr.handler.TemplateHandler;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 表达式语法树访问者
 *
 * @author weijiaduo
 * @since 2023/3/7
 */
public class ExprVisitor extends ExprParserBaseVisitor<String> {

    /**
     * 规则节点处理器
     */
    private final Map<String, RuleHandler<?, String>> ruleHandlers = new HashMap<>();

    /**
     * 获取默认的访问者
     *
     * @return 访问者
     */
    public static ExprVisitor getDefaultVisitor() {
        ExprVisitor visitor = new ExprVisitor();
        visitor.registerHandler("template", new TemplateHandler(visitor));
        visitor.registerHandler("general_func", new GeneralFuncHandler(visitor));
        visitor.registerHandler("native_func", new NativeFuncHandler(visitor));
        visitor.registerHandler("column_ref", new ColumnRefHandler(visitor));
        return visitor;
    }

    /**
     * 注册处理器
     *
     * @param name        处理器名称
     * @param ruleHandler 规则处理器
     */
    public void registerHandler(String name, RuleHandler<?, String> ruleHandler) {
        ruleHandlers.put(name, ruleHandler);
    }

    /**
     * 获取指定名称的规则处理器
     *
     * @param name 名称
     * @return 规则处理器/null
     */
    public RuleHandler<?, String> getRuleHandler(String name) {
        return ruleHandlers.get(name);
    }

    @Override
    protected String aggregateResult(String aggregate, String nextResult) {
        StringBuilder sb = new StringBuilder();
        if (aggregate != null) {
            sb.append(aggregate);
        }
        if (nextResult != null && !nextResult.isEmpty()) {
            if (!sb.isEmpty()) {
                sb.append(" ");
            }
            sb.append(nextResult);
        }
        return sb.toString();
    }

    @Override
    public String visitTerminal(TerminalNode node) {
        String expr = node.getText();
        if ("<EOF>".equals(expr)) {
            return "";
        }
        return expr;
    }

    @Override
    public String visitLiteral(ExprParser.LiteralContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitUnary(ExprParser.UnaryContext ctx) {
        String expr = visit(ctx.expr());
        return ctx.children.get(0).getText() + expr;
    }

    @Override
    public String visitAnyName(ExprParser.AnyNameContext ctx) {
        return ctx.getText();
    }

    @SuppressWarnings("unchecked")
    @Override
    public String visitTemplate(ExprParser.TemplateContext ctx) {
        RuleHandler<ExprParser.TemplateContext, String> handler =
                (RuleHandler<ExprParser.TemplateContext, String>) getRuleHandler("template");
        return handler.handle(ctx);
    }

    @SuppressWarnings("unchecked")
    @Override
    public String visitColumnRef(ExprParser.ColumnRefContext ctx) {
        RuleHandler<ExprParser.ColumnRefContext, String> handler =
                (RuleHandler<ExprParser.ColumnRefContext, String>) getRuleHandler("column_ref");
        return handler.handle(ctx);
    }

    @SuppressWarnings("unchecked")
    @Override
    public String visitGeneralFunc(ExprParser.GeneralFuncContext ctx) {
        RuleHandler<ExprParser.GeneralFuncContext, String> handler =
                (RuleHandler<ExprParser.GeneralFuncContext, String>) getRuleHandler("general_func");
        return handler.handle(ctx);
    }

    @SuppressWarnings("unchecked")
    @Override
    public String visitNativeFunc(ExprParser.NativeFuncContext ctx) {
        RuleHandler<ExprParser.NativeFuncContext, String> handler =
                (RuleHandler<ExprParser.NativeFuncContext, String>) getRuleHandler("native_func");
        return handler.handle(ctx);
    }

}
