package com.wjd.lr.expr;

import com.wjd.lr.expr.adapter.*;
import com.wjd.lr.expr.antlr.ExprLexer;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.error.ExprParseErrorHandler;
import com.wjd.lr.expr.error.ExprParseErrorListener;
import com.wjd.lr.expr.handler.ExprHandler;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

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
    private String exprText;
    /**
     * 表达式处理器
     */
    protected final List<ExprHandler<?>> handlers = new ArrayList<>();

    public ExprBuilder(String exprText) {
        this.exprText = exprText;
    }

    /**
     * 构建表达式树
     *
     * @return 表达式树
     */
    public Expr build() {
        return buildVisitor().visit(parse());
    }

    /**
     * 构建指定表达式字符串为表达式树
     *
     * @param exprText 指定表达式字符串
     * @return 表达式树
     */
    public Expr build(String exprText) {
        this.exprText = exprText;
        return build();
    }

    /**
     * 测试表达式是否可以正常解析
     *
     * @throws Exception 有异常时表示表达式语法有问题
     */
    public void test() throws Exception {
        parse();
    }

    /**
     * 解析表达式
     * <p>
     * 说明：尽量不要对外开放第三方的类
     *
     * @return 语法树
     */
    private ParseTree parse() {
        CharStream input = CharStreams.fromString(exprText);
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        parser.setErrorHandler(new ExprParseErrorHandler());
        parser.addErrorListener(new ExprParseErrorListener());
        return parser.parse();
    }

    /**
     * 构建访问者
     * <p>
     * 说明：尽量不要对外开放第三方的类
     *
     * @return 访问者
     */
    private ExprVisitor buildVisitor() {
        ExprVisitor visitor = new ExprVisitor();
        visitor.addAdapter(new ColumnRefAdapter(this, visitor));
        visitor.addAdapter(new TemplateAdapter(this, visitor));
        visitor.addAdapter(new GeneralFuncAdapter(this, visitor));
        visitor.addAdapter(new CaseWhenAdapter(this, visitor));
        visitor.addAdapter(new BetweenAdapter(this, visitor));
        visitor.addAdapter(new InAdapter(this, visitor));
        visitor.addAdapter(new NativeFuncAdapter(this, visitor));
        visitor.addAdapter(new WrapExprAdapter(this, visitor));
        visitor.addAdapter(new UnaryAdapter(this, visitor));
        visitor.addAdapter(new ArithmeticAdapter(this, visitor));
        visitor.addAdapter(new CompareAdapter(this, visitor));
        visitor.addAdapter(new LogicalAdapter(this, visitor));
        visitor.addAdapter(new LiteralAdapter(this, visitor));
        visitor.addAdapter(new TextAdapter(this, visitor));
        return visitor;
    }

    /**
     * 获取表达式处理器
     *
     * @return 表达式处理器
     */
    public List<ExprHandler<?>> getHandlers() {
        return handlers;
    }

    /**
     * 添加表达式处理器
     *
     * @param handler 表达式处理器
     */
    public void addHandler(ExprHandler<?> handler) {
        handlers.add(handler);
    }

}
