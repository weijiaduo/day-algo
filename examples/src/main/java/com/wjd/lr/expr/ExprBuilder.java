package com.wjd.lr.expr;

import com.wjd.lr.expr.antlr.ExprLexer;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.handler.ColumnRefHandler;
import com.wjd.lr.expr.handler.GeneralFunctionHandler;
import com.wjd.lr.expr.handler.NativeFunctionHandler;
import com.wjd.lr.expr.handler.TemplateHandler;
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
     * 表达式语法树访问者
     */
    private ExprVisitor visitor;

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
        return getVisitor().visit(parseTree);
    }

    private ExprVisitor getVisitor() {
        if (visitor != null) {
            return visitor;
        }
        visitor = getDefaultVisitor();
        return visitor;
    }

    /**
     * 默认访问者
     */
    private ExprVisitor getDefaultVisitor() {
        ExprVisitor visitor = new ExprVisitor();
        visitor.registerHandler("template", new TemplateHandler(visitor));
        visitor.registerHandler("general_func", new GeneralFunctionHandler(visitor));
        visitor.registerHandler("native_func", new NativeFunctionHandler(visitor));
        visitor.registerHandler("column_ref", new ColumnRefHandler(visitor));
        return visitor;
    }

    /**
     * 自定义访问者
     *
     * @param visitor 表达式访问者
     * @return this
     */
    public ExprBuilder visitor(ExprVisitor visitor) {
        this.visitor = visitor;
        return this;
    }

}
