package com.wjd.lr.expr;

import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.antlr.ExprParserBaseVisitor;
import com.wjd.lr.expr.handler.ColumnRefHandler;
import com.wjd.lr.expr.handler.GeneralFuncHandler;
import com.wjd.lr.expr.handler.NativeFuncHandler;
import com.wjd.lr.expr.handler.TemplateHandler;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * 表达式语法树访问者
 *
 * @author weijiaduo
 * @since 2023/3/7
 */
public class ExprVisitor extends ExprParserBaseVisitor<String> {

    /**
     * 列引用处理器
     */
    private ColumnRefHandler columnRefHandler;
    /**
     * 模板处理器
     */
    private TemplateHandler templateHandler;
    /**
     * 通用函数处理器
     */
    private GeneralFuncHandler generalFuncHandler;
    /**
     * 本地函数处理器
     */
    private NativeFuncHandler nativeFuncHandler;

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

    @Override
    public String visitTemplate(ExprParser.TemplateContext ctx) {
        return templateHandler.handle(ctx);
    }

    @Override
    public String visitColumnRef(ExprParser.ColumnRefContext ctx) {
        return columnRefHandler.handle(ctx);
    }

    @Override
    public String visitGeneralFunc(ExprParser.GeneralFuncContext ctx) {
        return generalFuncHandler.handle(ctx);
    }

    @Override
    public String visitNativeFunc(ExprParser.NativeFuncContext ctx) {
        return nativeFuncHandler.handle(ctx);
    }

    /**
     * @param columnRefHandler columnRefHandler
     */
    public void setColumnRefHandler(ColumnRefHandler columnRefHandler) {
        this.columnRefHandler = columnRefHandler;
    }

    /**
     * @param templateHandler templateHandler
     */
    public void setTemplateHandler(TemplateHandler templateHandler) {
        this.templateHandler = templateHandler;
    }

    /**
     * @param generalFuncHandler generalFuncHandler
     */
    public void setGeneralFuncHandler(GeneralFuncHandler generalFuncHandler) {
        this.generalFuncHandler = generalFuncHandler;
    }

    /**
     * @param nativeFuncHandler nativeFuncHandler
     */
    public void setNativeFuncHandler(NativeFuncHandler nativeFuncHandler) {
        this.nativeFuncHandler = nativeFuncHandler;
    }

}
