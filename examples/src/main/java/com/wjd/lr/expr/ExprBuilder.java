package com.wjd.lr.expr;

import com.wjd.lr.expr.adapter.*;
import com.wjd.lr.expr.antlr.ExprLexer;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.builder.function.FunctionBuilder;
import com.wjd.lr.expr.builder.ref.ColumnRefBuilder;
import com.wjd.lr.expr.builder.template.TemplateBuilder;
import com.wjd.lr.expr.builder.text.TextItemBuilder;
import com.wjd.lr.expr.builder.unary.UnaryItemBuilder;
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
     * 列引用构造器
     */
    private ColumnRefBuilder columnRefBuilder;
    /**
     * 模板构造器
     */
    private TemplateBuilder templateBuilder;
    /**
     * 通用函数构造器
     */
    private FunctionBuilder generalFuncBuilder;
    /**
     * 本地函数构造器
     */
    private FunctionBuilder nativeFuncBuilder;

    public ExprBuilder(String exprText) {
        this.exprText = exprText;
    }

    /**
     * 构建最终的表达式字符串
     *
     * @return 可执行的表达式字符串
     */
    public String build() {
        return buildVisitor().visit(parse());
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
        visitor.addAdapter(new ColumnRefAdapter(visitor, columnRefBuilder));
        visitor.addAdapter(new GeneralFuncAdapter(visitor, generalFuncBuilder));
        visitor.addAdapter(new NativeFuncAdapter(visitor, nativeFuncBuilder));
        visitor.addAdapter(new TemplateAdapter(visitor, templateBuilder));
        visitor.addAdapter(new UnaryItemAdapter(visitor, new UnaryItemBuilder()));
        visitor.addAdapter(new TextItemAdapter(visitor, new TextItemBuilder()));
        return visitor;
    }

    public ExprBuilder columnRefBuilder(ColumnRefBuilder columnRefBuilder) {
        this.columnRefBuilder = columnRefBuilder;
        return this;
    }

    public ExprBuilder templateBuilder(TemplateBuilder templateBuilder) {
        this.templateBuilder = templateBuilder;
        return this;
    }

    public ExprBuilder generalFuncBuilder(FunctionBuilder generalFuncBuilder) {
        this.generalFuncBuilder = generalFuncBuilder;
        return this;
    }

    public ExprBuilder nativeFuncBuilder(FunctionBuilder nativeFuncBuilder) {
        this.nativeFuncBuilder = nativeFuncBuilder;
        return this;
    }

}
