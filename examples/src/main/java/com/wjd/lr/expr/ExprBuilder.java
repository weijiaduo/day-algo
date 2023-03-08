package com.wjd.lr.expr;

import com.wjd.lr.expr.antlr.ExprLexer;
import com.wjd.lr.expr.antlr.ExprParser;
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
        visitor = ExprVisitor.getDefaultVisitor();
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
