package com.wjd.lr.expr;

import com.wjd.lr.expr.handler.ColumnRefHandler;
import com.wjd.lr.expr.handler.GeneralFunctionHandler;
import com.wjd.lr.expr.handler.TemplateHandler;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
        ExprVisitor visitor = new ExprVisitor();
        visitor.registerHandler("template", new TemplateHandlerTest(visitor));
        ExprBuilder builder = new ExprBuilder(exprText).visitor(visitor);
        String actualExpr = builder.build();
        assertEquals(expectExpr, actualExpr);
    }

    @Test
    void testEnvironmentVar() {
        ExprVisitor visitor = new ExprVisitor();
        visitor.registerHandler("template", new TemplateHandlerTest(visitor));

        String exprText = "${userId}";
        String expectExpr = "test";
        ExprBuilder builder = new ExprBuilder(exprText).visitor(visitor);
        String actualExpr = builder.build();
        assertEquals(expectExpr, actualExpr);

        exprText = "${userName}";
        expectExpr = "admin";
        builder = new ExprBuilder(exprText).visitor(visitor);
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
        String exprText = "ceil(-10.3)";
        String expectExpr = "ceil(-10.3)";
        ExprBuilder builder = new ExprBuilder(exprText);
        String actualExpr = builder.build();
        assertEquals(expectExpr, actualExpr);

        exprText = "len(10.7)";
        expectExpr = "length(10.7)";
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
    void testMixed() {
        ExprVisitor visitor = new ExprVisitor();
        visitor.registerHandler("template", new TemplateHandlerTest(visitor));
        visitor.registerHandler("general_func", new GeneralFunctionHandlerTest(visitor));
        visitor.registerHandler("column_ref", new ColumnRefHandlerTest(visitor));

        String exprText = "abs(${ceil(Param.freight) + 2 * 4}) + @div(-[orders].[freight], 10)";
        String expectExpr = "abs(11.0)+div(-orders.freight,10)";
        ExprBuilder builder = new ExprBuilder(exprText).visitor(visitor);
        String actualExpr = builder.build();
        assertEquals(expectExpr, actualExpr);
    }

    static class TemplateHandlerTest extends TemplateHandler {

        TemplateHandlerTest(ExprVisitor visitor) {
            super(visitor);
        }

        @Override
        protected void prepareVars() {
            // environment variable
            vars.put("userId", "test");
            vars.put("userName", "admin");

            // parameter
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("freight", 2.1);
            paramMap.put("unitPrice", 10.2);
            vars.put("Param", paramMap);
        }
    }

    static class GeneralFunctionHandlerTest extends GeneralFunctionHandler {
        GeneralFunctionHandlerTest(ExprVisitor visitor) {
            super(visitor);
        }
    }

    static class ColumnRefHandlerTest extends ColumnRefHandler {
        ColumnRefHandlerTest(ExprVisitor visitor) {
            super(visitor);
        }
    }

}