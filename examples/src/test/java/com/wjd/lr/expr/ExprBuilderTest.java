package com.wjd.lr.expr;

import com.wjd.lr.expr.builder.function.FunctionBuilder;
import com.wjd.lr.expr.builder.function.GeneralFuncBuilder;
import com.wjd.lr.expr.builder.function.NativeFuncBuilder;
import com.wjd.lr.expr.builder.ref.ColumnRefBuilder;
import com.wjd.lr.expr.builder.template.TemplateBuilder;
import com.wjd.lr.expr.builder.template.TemplateContext;
import com.wjd.lr.expr.builder.template.fucntion.FunctionContext;
import com.wjd.lr.expr.builder.template.fucntion.FunctionStub;
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
        String exprText = "[orders].[freight2]";
        String expectExpr = "orders.freight2";
        String actualExpr = new ExprBuilder(exprText).build();
        assertEquals(expectExpr, actualExpr);

        exprText = "[orders].[运费]";
        expectExpr = "orders.运费";
        actualExpr = new ExprBuilder(exprText).build();
        assertEquals(expectExpr, actualExpr);

        exprText = "[orders].[field-运费]";
        expectExpr = "orders.field-运费";
        actualExpr = new ExprBuilder(exprText).build();
        assertEquals(expectExpr, actualExpr);

        exprText = "[orders].[field_运费]";
        expectExpr = "orders.field_运费";
        actualExpr = new ExprBuilder(exprText).build();
        assertEquals(expectExpr, actualExpr);

        exprText = "[field2t]";
        expectExpr = "field2t";
        actualExpr = new ExprBuilder(exprText).build();
        assertEquals(expectExpr, actualExpr);

        exprText = "[field_运费]";
        expectExpr = "field_运费";
        actualExpr = new ExprBuilder(exprText).build();
        assertEquals(expectExpr, actualExpr);

        exprText = "[(field_运费]";
        expectExpr = "(field_运费";
        actualExpr = new ExprBuilder(exprText).build();
        assertEquals(expectExpr, actualExpr);

        exprText = "[(field-运费，。/‘！@#￥%……&*（）——+~}{：》？《|)-/+*~!@^@#$%^&*()_+~{}|:<>?]";
        expectExpr = "(field-运费，。/‘！@#￥%……&*（）——+~}{：》？《|)-/+*~!@^@#$%^&*()_+~{}|:<>?";
        actualExpr = new ExprBuilder(exprText).build();
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

        VariableContext varCxt = templateContext.getVariableContext();
        varCxt.register("userId", "test");
        varCxt.register("userName", "admin");
        varCxt.register("userCount", 2);
        varCxt.registerByPath("Param.freight", 2.1);
        varCxt.registerByPath("Param.unitPrice", 10.2);

        try {
            FunctionContext funcCxt = templateContext.getFunctionContext();
            Method method = MockCustomFunction.class.getDeclaredMethod("floor", double.class);
            FunctionStub floor = new FunctionStub("floor", method);
            FunctionStub floor2 = new FunctionStub("floor2", method);
            funcCxt.register("floor", floor);
            funcCxt.register("floor2", floor2);
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