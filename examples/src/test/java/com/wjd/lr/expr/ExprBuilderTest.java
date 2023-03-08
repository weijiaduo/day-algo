package com.wjd.lr.expr;

import com.wjd.lr.expr.function.DefaultSQLFunctionBuilder;
import com.wjd.lr.expr.function.FunctionBuilder;
import com.wjd.lr.expr.template.DefaultTemplateBuilder;
import com.wjd.lr.expr.template.TemplateBuilder;
import com.wjd.lr.expr.template.TemplateContext;
import com.wjd.lr.expr.template.variable.VariableContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExprBuilderTest {

    @Test
    void testLiteral() {
        // int
        String exprText = "12";
        String expectExpr = "12";
        ExprBuilder builder = new ExprBuilder(exprText);
        String actualExpr = builder.build();
        assertEquals(expectExpr, actualExpr);

        // string
        exprText = "'广州'";
        expectExpr = "'广州'";
        builder = new ExprBuilder(exprText);
        actualExpr = builder.build();
        assertEquals(expectExpr, actualExpr);

        // boolean
        exprText = "true";
        expectExpr = "true";
        builder = new ExprBuilder(exprText);
        actualExpr = builder.build();
        assertEquals(expectExpr, actualExpr);

        // null
        exprText = "null";
        expectExpr = "null";
        builder = new ExprBuilder(exprText);
        actualExpr = builder.build();
        assertEquals(expectExpr, actualExpr);
    }

    @Test
    void testColumnRef() {
        String exprText = "[orders].[freight]";
        String expectExpr = "orders.freight";
        ExprBuilder builder = new ExprBuilder(exprText);
        String actualExpr = builder.build();
        assertEquals(expectExpr, actualExpr);
    }

    @Test
    void testParamVar() {
        String exprText = "${Param.freight}";
        String expectExpr = "2.1";
        ExprBuilder builder = new ExprBuilder(exprText)
                .templateBuilder(mockTemplateBuilder());
        String actualExpr = builder.build();
        assertEquals(expectExpr, actualExpr);
    }

    @Test
    void testEnvironmentVar() {
        String exprText = "${userId}";
        String expectExpr = "test";
        ExprBuilder builder = new ExprBuilder(exprText)
                .templateBuilder(mockTemplateBuilder());
        String actualExpr = builder.build();
        assertEquals(expectExpr, actualExpr);

        exprText = "${userName}";
        expectExpr = "admin";
        builder = new ExprBuilder(exprText)
                .templateBuilder(mockTemplateBuilder());
        actualExpr = builder.build();
        assertEquals(expectExpr, actualExpr);
    }

    @Test
    void testSystemFunction() {
        String exprText = "${ceil(-10.3)}";
        String expectExpr = "-10.0";
        ExprBuilder builder = new ExprBuilder(exprText);
        String actualExpr = builder.build();
        assertEquals(expectExpr, actualExpr);

        exprText = "${floor(10.7)}";
        expectExpr = "10.0";
        builder = new ExprBuilder(exprText);
        actualExpr = builder.build();
        assertEquals(expectExpr, actualExpr);
    }

    @Test
    void testGeneralFunction() {
        // 函数存在时
        String exprText = "ceil(-10.3)";
        String expectExpr = "ceil(-10.3)";
        ExprBuilder builder = new ExprBuilder(exprText);
        String actualExpr = builder.build();
        assertEquals(expectExpr, actualExpr);

        // 函数不存在时
        exprText = "len(10.7)";
        expectExpr = "len(10.7)";
        builder = new ExprBuilder(exprText);
        actualExpr = builder.build();
        assertEquals(expectExpr, actualExpr);
    }

    @Test
    void testNativeFunction() {
        String exprText = "@ceil(-10.3)";
        String expectExpr = "ceil(-10.3)";
        ExprBuilder builder = new ExprBuilder(exprText);
        String actualExpr = builder.build();
        assertEquals(expectExpr, actualExpr);

        exprText = "@len(10.7)";
        expectExpr = "len(10.7)";
        builder = new ExprBuilder(exprText);
        actualExpr = builder.build();
        assertEquals(expectExpr, actualExpr);
    }

    @Test
    void testBetween() {
        String exprText = "[orders].[freight] between -10 and 100";
        String expectExpr = "orders.freight between -10 and 100";
        ExprBuilder builder = new ExprBuilder(exprText);
        String actualExpr = builder.build();
        assertEquals(expectExpr, actualExpr);
    }

    @Test
    void testCaseWhen() {
        String exprText = "case when [orders].[freight] > -10 then 0 else 1 end";
        String expectExpr = "case when orders.freight > -10 then 0 else 1 end";
        ExprBuilder builder = new ExprBuilder(exprText);
        String actualExpr = builder.build();
        assertEquals(expectExpr, actualExpr);
    }

    @Test
    void testMixed() {
        String exprText = "abs(${ceil(Param.freight) + 2 * 4}) + @div(-[orders].[freight], 10)";
        String expectExpr = "abs(11.0) + div(-orders.freight, 10)";
        ExprBuilder builder = new ExprBuilder(exprText)
                .templateBuilder(mockTemplateBuilder())
                .generalFuncBuilder(mockFunctionBuilder());
        String actualExpr = builder.build();
        assertEquals(expectExpr, actualExpr);
    }

    private FunctionBuilder mockFunctionBuilder() {
        return new DefaultSQLFunctionBuilder();
    }

    private TemplateBuilder mockTemplateBuilder() {
        return new DefaultTemplateBuilder(mockTemplateContext());
    }

    private TemplateContext mockTemplateContext() {
        TemplateContext templateContext = new TemplateContext();
        VariableContext variableContext = templateContext.getVariableContext();
        variableContext.register("userId", "test");
        variableContext.register("userName", "admin");
        variableContext.registerByPath("Param.freight", 2.1);
        variableContext.registerByPath("Param.unitPrice", 10.2);
        return templateContext;
    }

}