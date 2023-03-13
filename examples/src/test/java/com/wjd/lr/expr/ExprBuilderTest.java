package com.wjd.lr.expr;

import com.wjd.lr.expr.builder.function.FunctionBuilder;
import com.wjd.lr.expr.builder.function.GeneralFuncBuilder;
import com.wjd.lr.expr.builder.function.NativeFuncBuilder;
import com.wjd.lr.expr.builder.ref.ColumnRefBuilder;
import com.wjd.lr.expr.builder.template.TemplateBuilder;
import com.wjd.lr.expr.builder.template.TemplateContext;
import com.wjd.lr.expr.builder.template.fucntion.FunctionContext;
import com.wjd.lr.expr.builder.template.fucntion.FunctionTemplate;
import com.wjd.lr.expr.builder.template.variable.VariableContext;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class ExprBuilderTest {

    @Test
    void testLiteral() {
        // int
        String exprText = "12";
        String expectExpr = "12";
        String actualExpr = new ExprBuilder(exprText).build();
        assertEquals(expectExpr, actualExpr);

        // string
        exprText = "'广州'";
        expectExpr = "'广州'";
        actualExpr = new ExprBuilder(exprText).build();
        assertEquals(expectExpr, actualExpr);

        // boolean
        exprText = "true";
        expectExpr = "true";
        actualExpr = new ExprBuilder(exprText).build();
        assertEquals(expectExpr, actualExpr);

        // null
        exprText = "null";
        expectExpr = "null";
        actualExpr = new ExprBuilder(exprText).build();
        assertEquals(expectExpr, actualExpr);
    }

    @Test
    void testColumnRef() {
        String exprText = "[orders].[freight]";
        String expectExpr = "orders.freight";
        String actualExpr = new ExprBuilder(exprText).build();
        assertEquals(expectExpr, actualExpr);

        exprText = "[orders].[freight]";
        expectExpr = "`orders`.`freight`";
        actualExpr = new ExprBuilder(exprText)
                .columnRefBuilder(mockColumnRefBuilder())
                .build();
        assertEquals(expectExpr, actualExpr);
    }

    @Test
    void testTemplateParamVar() {
        String exprText = "${Param.freight}";
        String expectExpr = "2.1";
        String actualExpr = new ExprBuilder(exprText)
                .templateBuilder(mockTemplateBuilder())
                .build();
        assertEquals(expectExpr, actualExpr);
    }

    @Test
    void testTemplateUserPropVar() {
        String exprText = "${userId}";
        String expectExpr = "test";
        String actualExpr = new ExprBuilder(exprText)
                .templateBuilder(mockTemplateBuilder())
                .build();
        assertEquals(expectExpr, actualExpr);

        exprText = "${userName}";
        expectExpr = "admin";
        actualExpr = new ExprBuilder(exprText)
                .templateBuilder(mockTemplateBuilder())
                .build();
        assertEquals(expectExpr, actualExpr);
    }

    @Test
    void testTemplateFunction() {
        String exprText = "${ceil(-10.3)}";
        String expectExpr = "-10.0";
        String actualExpr = new ExprBuilder(exprText).build();
        assertEquals(expectExpr, actualExpr);

        exprText = "${floor(10.7)}";
        expectExpr = "10.0";
        actualExpr = new ExprBuilder(exprText).build();
        assertEquals(expectExpr, actualExpr);

        // 自定义函数
        exprText = "${floor(10.7)}";
        expectExpr = "1.23456789";
        actualExpr = new ExprBuilder(exprText)
                .templateBuilder(mockTemplateBuilder())
                .build();
        assertEquals(expectExpr, actualExpr);

        // 自定义函数
        exprText = "${floor2(10.7)}";
        expectExpr = "1.23456789";
        actualExpr = new ExprBuilder(exprText)
                .templateBuilder(mockTemplateBuilder())
                .build();
        assertEquals(expectExpr, actualExpr);
    }

    @Test
    void testGeneralFunction() {
        // 函数存在时
        String exprText = "ceiling(-10.3)";
        String expectExpr = "ceiling(-10.3)";
        String actualExpr = new ExprBuilder(exprText).build();
        assertEquals(expectExpr, actualExpr);

        // 函数不存在时
        exprText = "len(10.7)";
        expectExpr = "len(10.7)";
        actualExpr = new ExprBuilder(exprText).build();
        assertEquals(expectExpr, actualExpr);
    }

    @Test
    void testNativeFunction() {
        String exprText = "@ceil(-10.3)";
        String expectExpr = "ceil(-10.3)";
        String actualExpr = new ExprBuilder(exprText).build();
        assertEquals(expectExpr, actualExpr);

        exprText = "@len(10.7)";
        expectExpr = "len(10.7)";
        actualExpr = new ExprBuilder(exprText).build();
        assertEquals(expectExpr, actualExpr);
    }

    @Test
    void testBetween() {
        String exprText = "[orders].[freight] between -10 and 100";
        String expectExpr = "orders.freight between -10 and 100";
        String actualExpr = new ExprBuilder(exprText).build();
        assertEquals(expectExpr, actualExpr);
    }

    @Test
    void testCaseWhen() {
        String exprText = "case when [orders].[freight] > -10 then 0 else 1 end";
        String expectExpr = "case when orders.freight > -10 then 0 else 1 end";
        String actualExpr = new ExprBuilder(exprText).build();
        assertEquals(expectExpr, actualExpr);
    }

    @Test
    void testMixed() {
        String exprText = "abs(${ceil(Param.freight) + userCount * 4}) + @div(-[orders].[freight], 10)";
        String expectExpr = "abs(11.0) + div(-`orders`.`freight`, 10)";
        String actualExpr = new ExprBuilder(exprText)
                .columnRefBuilder(mockColumnRefBuilder())
                .templateBuilder(mockTemplateBuilder())
                .generalFuncBuilder(mockGeneralFuncBuilder())
                .nativeFuncBuilder(mockNativeFuncBuilder())
                .build();
        assertEquals(expectExpr, actualExpr);
    }

    @Test
    public void testCheckWrongExpr() {
        try {
            String exprText = "abs(${ceil(Param.freight) + userCount * 4}";
            new ExprBuilder(exprText).test();
            fail("Should be throw error!");
        } catch (Exception e) {
            assertNotNull(e);
        }
    }

    private ColumnRefBuilder mockColumnRefBuilder() {
        return new ColumnRefBuilder() {
            @Override
            protected String getPreQuote() {
                return "`";
            }

            @Override
            protected String getPostQuote() {
                return "`";
            }
        };
    }

    private FunctionBuilder mockGeneralFuncBuilder() {
        return new GeneralFuncBuilder();
    }

    private FunctionBuilder mockNativeFuncBuilder() {
        return new NativeFuncBuilder();
    }

    private TemplateBuilder mockTemplateBuilder() {
        return new TemplateBuilder(mockTemplateContext());
    }

    private TemplateContext mockTemplateContext() {
        TemplateContext templateContext = new TemplateContext();

        VariableContext variableContext = templateContext.getVariableContext();
        variableContext.register("userId", "test");
        variableContext.register("userName", "admin");
        variableContext.register("userCount", 2);
        variableContext.registerByPath("Param.freight", 2.1);
        variableContext.registerByPath("Param.unitPrice", 10.2);

        try {
            FunctionContext functionContext = templateContext.getFunctionContext();
            Method method = MockCustomFunction.class.getDeclaredMethod("floor", double.class);
            FunctionTemplate floorFunc = new FunctionTemplate("floor", method);
            FunctionTemplate floor2Func = new FunctionTemplate("floor2", method);
            functionContext.register("floor", floorFunc);
            functionContext.register("floor2", floor2Func);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return templateContext;
    }

    public static class MockCustomFunction {
        public static double floor(double a) {
            return 1.23456789;
        }
    }

}