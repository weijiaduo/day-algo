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
        String[] inputs = {
                "12",
                "'广州'",
                "true",
                "null"
        };
        String[] expects = {
                "12",
                "'广州'",
                "true",
                "null"
        };
        runCustomTest(inputs, expects);
    }

    @Test
    void testColumnRef() {
        String[] inputs = {
                "[orders].[freight2]",
                "[orders].[运费]",
                "[orders].[field-运费]",
                "[orders].[field_运费]",
                "[field2t]",
                "[field_运费]",
                "[(field-运费，。/‘！@#￥%……&*（）——+~}{：》？《|)-/+*~!@^@#$%^&*()_+~{}|:<>?]"
        };
        String[] expects = {
                "orders.freight2",
                "orders.运费",
                "orders.field-运费",
                "orders.field_运费",
                "field2t",
                "field_运费",
                "(field-运费，。/‘！@#￥%……&*（）——+~}{：》？《|)-/+*~!@^@#$%^&*()_+~{}|:<>?"
        };
        runDefaultTest(inputs, expects);
    }

    @Test
    void testCustomColumnRef() {
        String[] inputs = {
                "[orders].[运费]",
                "[orders].[field-运费]",
                "[field_运费]",
        };
        String[] expects = {
                "`orders`.`运费`",
                "`orders`.`field-运费`",
                "`field_运费`"
        };
        runCustomTest(inputs, expects);
    }

    @Test
    void testTemplateParamVar() {
        String[] inputs = {
                "${Param.freight}",
                "${Param.unitPrice}"
        };
        String[] expects = {
                "2.1",
                "10.2"
        };
        runCustomTest(inputs, expects);
    }

    @Test
    void testTemplateUserPropVar() {
        String[] inputs = {
                "${userId}",
                "${userName}"
        };
        String[] expects = {
                "test",
                "admin"
        };
        runCustomTest(inputs, expects);
    }

    @Test
    void testTemplateFunction() {
        // 默认系统函数
        String[] inputs = {
                "${ceil(-10.3)}",
                "${floor(10.7)}"
        };
        String[] expects = {
                "-10.0",
                "10.0"
        };
        runDefaultTest(inputs, expects);
    }

    @Test
    void testCustomTemplateFunction() {
        // 自定义函数
        String[] inputs = {
                "${floor(10.7)}",
                "${floor2(10.7)}"
        };
        String[] expects2 = {
                "1.23456789",
                "1.23456789"
        };
        runCustomTest(inputs, expects2);
    }

    @Test
    void testGeneralFunction() {
        String[] inputs = {
                "ceiling(-10.3)",
                "substring('12345678', 0, 5)",
                "abs([orders].[freight])",
                "substring([orders].[orderId], 0, abs([orders].[freight]))",
                "len(10.7)"
        };
        String[] expects = {
                "ceiling(-10.3)",
                "substring('12345678', 0, 5)",
                "abs(`orders`.`freight`)",
                "substring(`orders`.`orderId`, 0, abs(`orders`.`freight`))",
                "len(10.7)"
        };
        runCustomTest(inputs, expects);
    }

    @Test
    void testNativeFunction() {
        String[] inputs = {
                "@ceil(-10.3)",
                "@len(10.7)"
        };
        String[] expects = {
                "ceil(-10.3)",
                "len(10.7)"
        };
        runCustomTest(inputs, expects);
    }

    @Test
    void testBetween() {
        String[] inputs = {
                "[orders].[freight] between -10 and 100"
        };
        String[] expects = {
                "`orders`.`freight` between -10 and 100"
        };
        runCustomTest(inputs, expects);
    }

    @Test
    void testCaseWhen() {
        String[] inputs = {
                "case when [orders].[freight] > -10 then 0 else 1 end"
        };
        String[] expects = {
                "case when `orders`.`freight` > -10 then 0 else 1 end"
        };
        runCustomTest(inputs, expects);
    }

    @Test
    void testMixed() {
        String[] inputs = {
                "1 + 2",
                "1 > 2 * 3",
                "[orders].[ShipCity] is null",
                "[orders].[freight] - 100 / 2",
                "(${Param.freight} + 1) * 12",
                "abs([orders].[freight]) * 2",
                "@abs([orders].[freight]) / 3 * ([orderdatials].[quantity] + 1)",
                "substring(${userName}, 0, abs([orders].[freight]) + 2)",
                "@substring(${userName}, 0, @abs([orders].[freight]) + 2)",
                "abs(${ceil(Param.freight) + userCount * 4}) + @div(-[orders].[freight], 10)"
        };
        String[] expects = {
                "1 + 2",
                "1 > 2 * 3",
                "`orders`.`ShipCity` is null",
                "`orders`.`freight` - 100 / 2",
                "( 2.1 + 1 ) * 12",
                "abs(`orders`.`freight`) * 2",
                "abs(`orders`.`freight`) / 3 * ( `orderdatials`.`quantity` + 1 )",
                "substring(admin, 0, abs(`orders`.`freight`) + 2)",
                "substring(admin, 0, abs(`orders`.`freight`) + 2)",
                "abs(11.0) + div(-`orders`.`freight`, 10)"
        };
        runCustomTest(inputs, expects);
    }

    @Test
    void testCheckWrongExpr() {
        try {
            String exprText = "abs(${ceil(Param.freight) + userCount * 4}";
            new ExprBuilder(exprText).test();
            fail("Should be throw error!");
        } catch (Exception e) {
            assertNotNull(e);
        }
    }

    /**
     * 运行默认的构建测试
     *
     * @param inputs  实际输入
     * @param expects 期望输出
     */
    void runDefaultTest(String[] inputs, String[] expects) {
        for (int i = 0; i < inputs.length; i++) {
            String actual = new ExprBuilder(inputs[i]).build();
            assertEquals(expects[i], actual);
        }
    }

    /**
     * 运行自定义的构建测试
     *
     * @param inputs  实际输入
     * @param expects 期望输出
     */
    void runCustomTest(String[] inputs, String[] expects) {
        for (int i = 0; i < inputs.length; i++) {
            String actual = mockExprBuilder(inputs[i]).build();
            assertEquals(expects[i], actual);
        }
    }

    ExprBuilder mockExprBuilder(String exprText) {
        return new ExprBuilder(exprText)
                .columnRefBuilder(mockColumnRefBuilder())
                .templateBuilder(mockTemplateBuilder())
                .generalFuncBuilder(mockGeneralFuncBuilder())
                .nativeFuncBuilder(mockNativeFuncBuilder());
    }

    ColumnRefBuilder mockColumnRefBuilder() {
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

    FunctionBuilder mockGeneralFuncBuilder() {
        return new GeneralFuncBuilder();
    }

    FunctionBuilder mockNativeFuncBuilder() {
        return new NativeFuncBuilder();
    }

    TemplateBuilder mockTemplateBuilder() {
        return new TemplateBuilder(mockTemplateContext());
    }

    TemplateContext mockTemplateContext() {
        TemplateContext templateContext = new TemplateContext();
        try {
            // 环境变量
            VariableContext varCxt = templateContext.getVariableContext();
            varCxt.register("userId", "test");
            varCxt.register("userName", "admin");
            varCxt.register("userCount", 2);
            varCxt.registerByPath("Param.freight", 2.1);
            varCxt.registerByPath("Param.unitPrice", 10.2);

            // 函数
            FunctionContext funcCxt = templateContext.getFunctionContext();
            Method method = CustomFunctions.class.getDeclaredMethod("floor", double.class);
            FunctionStub floor = new FunctionStub("floor", method);
            FunctionStub floor2 = new FunctionStub("floor2", method);
            funcCxt.register("floor", floor);
            funcCxt.register("floor2", floor2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return templateContext;
    }

    public static class CustomFunctions {
        public static double floor(double a) {
            return 1.23456789;
        }
    }

}