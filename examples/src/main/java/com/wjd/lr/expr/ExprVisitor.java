package com.wjd.lr.expr;

import com.wjd.lr.expr.adapter.RuleAdapter;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.antlr.ExprParserBaseVisitor;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 表达式语法树访问者
 *
 * @author weijiaduo
 * @since 2023/3/7
 */
public class ExprVisitor extends ExprParserBaseVisitor<String> {

    /**
     * 适配器
     */
    private final List<RuleAdapter> adapters = new ArrayList<>();

    /**
     * 添加适配器
     *
     * @param adapter 适配器
     */
    public void addAdapter(RuleAdapter adapter) {
        adapters.add(adapter);
    }

    private String build(RuleNode ruleNode) {
        for (RuleAdapter adapter : adapters) {
            if (adapter.accept(ruleNode)) {
                return adapter.build(adapter.adapt(ruleNode));
            }
        }
        return ruleNode.getText();
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
        return build(ctx);
    }

    @Override
    public String visitUnary(ExprParser.UnaryContext ctx) {
        return build(ctx);
    }

    @Override
    public String visitAnyName(ExprParser.AnyNameContext ctx) {
        return build(ctx);
    }

    @Override
    public String visitTemplate(ExprParser.TemplateContext ctx) {
        return build(ctx);
    }

    @Override
    public String visitColumnRef(ExprParser.ColumnRefContext ctx) {
        return build(ctx);
    }

    @Override
    public String visitGeneralFunc(ExprParser.GeneralFuncContext ctx) {
        return build(ctx);
    }

    @Override
    public String visitNativeFunc(ExprParser.NativeFuncContext ctx) {
        return build(ctx);
    }

}
