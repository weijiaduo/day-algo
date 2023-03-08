package com.wjd.lr.expr;

import com.wjd.lr.expr.antlr.ExprLexer;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.function.DefaultSQLFunctionBuilder;
import com.wjd.lr.expr.function.FunctionBuilder;
import com.wjd.lr.expr.handler.ColumnRefHandler;
import com.wjd.lr.expr.handler.GeneralFuncHandler;
import com.wjd.lr.expr.handler.NativeFuncHandler;
import com.wjd.lr.expr.handler.TemplateHandler;
import com.wjd.lr.expr.template.DefaultTemplateBuilder;
import com.wjd.lr.expr.template.TemplateBuilder;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * 表达式解析构建器
 *
 * @author weijiaduo
 * @since 2023/3/6
 */
public class ExprBuilder {

    /**
     * 表达式原始字符串
     */
    private final String exprText;
    /**
     * 模板构造器
     */
    private TemplateBuilder templateBuilder;
    /**
     * 通用函数构造器
     */
    private FunctionBuilder generalFuncBuilder;

    public ExprBuilder(String exprText) {
        this.exprText = exprText;
    }

    /**
     * 构建最终的表达式字符串
     *
     * @return 可执行的表达式字符串
     */
    public String build() {
        CharStream input = CharStreams.fromString(exprText);
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        ParseTree parseTree = parser.parse();
        // System.out.println(parseTree.toStringTree(parser));
        return buildVisitor().visit(parseTree);
    }

    /**
     * 构建访问者
     *
     * @return 访问者
     */
    private ExprVisitor buildVisitor() {
        if (templateBuilder == null) {
            templateBuilder = new DefaultTemplateBuilder();
        }
        if (generalFuncBuilder == null) {
            generalFuncBuilder = new DefaultSQLFunctionBuilder();
        }

        ExprVisitor visitor = new ExprVisitor();
        visitor.setTemplateHandler(new TemplateHandler(visitor, templateBuilder));
        visitor.setGeneralFuncHandler(new GeneralFuncHandler(visitor, generalFuncBuilder));
        visitor.setNativeFuncHandler(new NativeFuncHandler(visitor));
        visitor.setColumnRefHandler(new ColumnRefHandler(visitor));
        return visitor;
    }

    public ExprBuilder templateBuilder(TemplateBuilder templateBuilder) {
        this.templateBuilder = templateBuilder;
        return this;
    }

    public ExprBuilder generalFuncBuilder(FunctionBuilder generalFuncBuilder) {
        this.generalFuncBuilder = generalFuncBuilder;
        return this;
    }

}
