package com.wjd.lr.expr;

import com.wjd.lr.expr.ast.ColumnRef;
import com.wjd.lr.expr.handler.ColumnRefHandler;
import com.wjd.lr.expr.handler.FunctionHandler;
import com.wjd.lr.expr.handler.TemplateHandler;
import com.wjd.lr.expr.type.ValueType;
import com.wjd.lr.service.sql.SqlExprContext;
import com.wjd.lr.service.sql.SqlFunctionHandler;
import com.wjd.lr.template.fucntion.FunctionContext;
import com.wjd.lr.template.fucntion.FunctionStub;
import com.wjd.lr.template.mvel2.Mvel2TemplateContext;
import com.wjd.lr.service.sql.SqlTemplateHandler;
import com.wjd.lr.template.variable.VariableContext;
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
                "len(10.7)",
                "count(*)"
        };
        String[] expects = {
                "ceiling(-10.3)",
                "substring('12345678', 0, 5)",
                "abs(`orders`.`freight`)",
                "substring(`orders`.`orderId`, 0, abs(`orders`.`freight`))",
                "len(10.7)",
                "count(*)"
        };
        runCustomTest(inputs, expects);
    }

    @Test
    void testNativeFunction() {
        String[] inputs = {
                "@ceil(-10.3)",
                "@len(10.7)",
                "@count(*)"
        };
        String[] expects = {
                "ceil(-10.3)",
                "len(10.7)",
                "count(*)"
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
    void testIn() {
        String[] inputs = {
                "[orders].[freight] in ('1', '2', 3, 4)",
                "[orders].[freight] not in ('1', '2', 3, 4)",
                "(case when [省份] in ('山东省','江苏省') then '分组1' when [省份] in ('广东省','湖北省') then '分组2' else '其它' end)"
        };
        String[] expects = {
                "`orders`.`freight` in ('1', '2', 3, 4)",
                "`orders`.`freight` not in ('1', '2', 3, 4)",
                "(case when `省份` in ('山东省', '江苏省') then '分组1' when `省份` in ('广东省', '湖北省') then '分组2' else '其它' end)"
        };
        runCustomTest(inputs, expects);
    }

    @Test
    void testCaseWhen() {
        String[] inputs = {
                "case when [orders].[freight] > -10 then 0 else 1 end",
                "CASE WHEN [本行员工标志] = '是' || [本行员工标志] = '1' THEN concat( substr( [个人客户中文名称] , 1, 3), '**' ) ELSE [个人客户中文名称] END"
        };
        String[] expects = {
                "case when `orders`.`freight` > -10 then 0 else 1 end",
                "case when `本行员工标志` = '是' || `本行员工标志` = '1' then concat(substr(`个人客户中文名称`, 1, 3), '**') else `个人客户中文名称` end"
        };
        runCustomTest(inputs, expects);
    }

    @Test
    void testMixed() {
        String[] inputs = {
                "1 + 2",
                "1 > 2 * 3",
                "[orders].[ShipCity] is null",
                "[orders].[ShipCity] is not null",
                "[orders].[freight] - 100 / 2",
                "(${Param.freight} + 1) * 12",
                "abs([orders].[freight]) * 2",
                "@abs([orders].[freight]) / 3 * ([orderdatials].[quantity] + 1)",
                "substring(${userName}, 0, abs([orders].[freight]) + 2)",
                "@substring(${userName}, 0, @abs([orders].[freight]) + 2)",
                "abs(${ceil(Param.freight) + userCount * 4}) + @div(-[orders].[freight], 10)",
                "convert( date_format( [订单日期], '%Y') , char)"
        };
        String[] expects = {
                "1 + 2",
                "1 > 2 * 3",
                "`orders`.`ShipCity` is null",
                "`orders`.`ShipCity` is not null",
                "`orders`.`freight` - 100 / 2",
                "(2.1 + 1) * 12",
                "abs(`orders`.`freight`) * 2",
                "abs(`orders`.`freight`) / 3 * (`orderdatials`.`quantity` + 1)",
                "substring(admin, 0, abs(`orders`.`freight`) + 2)",
                "substring(admin, 0, abs(`orders`.`freight`) + 2)",
                "abs(11.0) + div(-`orders`.`freight`, 10)",
                "convert(date_format(`订单日期`, '%Y'), char)"
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

    @Test
    void testExprType() {
        String[] inputs = {
                "12",
                "'广州'",
                "true",
                "null",
                "[orders].[field-运费]",
                "${Param.freight}",
                "${userName}",
                "${ceil(-10.3)}",
                "substring([orders].[orderId], 0, abs([orders].[freight]))",
                "@ceil(-10.3)",
                "[orders].[freight] between -10 and 100",
                "case when [orders].[freight] > -10 then 0 else 1 end",
                "case [freight] when [orders].[freight] > -10 then 0 else 1 end",
                "1 + 2",
                "1 > 2 * 3",
                "[orders].[ShipCity] is not null",
                "@abs([orders].[freight]) / 3 * ([orderdatials].[quantity] + 1)",
                "abs(${ceil(Param.freight) + userCount * 4}) + @div(-[orders].[freight], 10)"
        };
        String[] expects = {
                "ExprType: NUMERIC, ValueType: NUMERIC",
                "ExprType: STRING, ValueType: STRING",
                "ExprType: BOOL, ValueType: BOOL",
                "ExprType: NULL, ValueType: NULL",
                "ExprType: COLUMN, ValueType: NUMERIC",
                "ExprType: NUMERIC, ValueType: NUMERIC",
                "ExprType: STRING, ValueType: STRING",
                "ExprType: NUMERIC, ValueType: NUMERIC",
                "ExprType: FUNCTION, ValueType: STRING",
                "ExprType: FUNCTION, ValueType: null",
                "ExprType: FUNCTION, ValueType: BOOL",
                "ExprType: FUNCTION, ValueType: NUMERIC",
                "ExprType: FUNCTION, ValueType: NUMERIC",
                "ExprType: ARITHMETIC, ValueType: NUMERIC",
                "ExprType: COMPARE, ValueType: BOOL",
                "ExprType: COMPARE, ValueType: BOOL",
                "ExprType: ARITHMETIC, ValueType: NUMERIC",
                "ExprType: ARITHMETIC, ValueType: NUMERIC"
        };

        for (int i = 0; i < inputs.length; i++) {
            Expr actual = mockExprBuilder(inputs[i]).build();
            assertEquals(expects[i], actual.toString());
        }
    }

    /**
     * 运行默认的构建测试
     *
     * @param inputs  实际输入
     * @param expects 期望输出
     */
    void runDefaultTest(String[] inputs, String[] expects) {
        ExprContext context = new SqlExprContext();
        TemplateHandler templateHandler = new SqlTemplateHandler();
        for (int i = 0; i < inputs.length; i++) {
            ExprBuilder builder = new ExprBuilder(inputs[i]);
            builder.addHandler(templateHandler);
            String actual = builder.build().toStr(context);
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
        ExprContext context = mockExprContext();
        for (int i = 0; i < inputs.length; i++) {
            String actual = mockExprBuilder(inputs[i]).build().toStr(context);
            assertEquals(expects[i], actual);
        }
    }

    ExprContext mockExprContext() {
        return new SqlExprContext() {
            @Override
            public String strName(String name) {
                return "`" + name + "`";
            }
        };
    }

    ExprBuilder mockExprBuilder(String exprText) {
        ExprBuilder builder = new ExprBuilder(exprText);
        builder.addHandler(mockColumnRefHandler());
        builder.addHandler(mockFunctionHandler());
        builder.addHandler(mockTemplateHandler());
        return builder;
    }

    ColumnRefHandler mockColumnRefHandler() {
        return new ColumnRefHandler() {
            @Override
            public Expr handle(ColumnRef columnRef) {
                ValueType valueType;
                switch (columnRef.getColumnName()) {
                    case "ShipCity":
                        valueType = ValueType.STRING;
                        break;
                    case "null":
                        valueType = ValueType.NULL;
                        break;
                    default:
                        valueType = ValueType.NUMERIC;
                        break;
                }
                columnRef.setValueType(valueType);
                return columnRef;
            }
        };
    }

    FunctionHandler mockFunctionHandler() {
        return new SqlFunctionHandler();
    }

    TemplateHandler mockTemplateHandler() {
        return new SqlTemplateHandler(mockTemplateContext());
    }

    Mvel2TemplateContext mockTemplateContext() {
        Mvel2TemplateContext templateCtx = new Mvel2TemplateContext();
        try {
            // 环境变量
            VariableContext varCxt = templateCtx.getVariableContext();
            varCxt.register("userId", "test");
            varCxt.register("userName", "admin");
            varCxt.register("userCount", 2);
            varCxt.registerByPath("Param.freight", 2.1);
            varCxt.registerByPath("Param.unitPrice", 10.2);

            // 函数
            FunctionContext funcCxt = templateCtx.getFunctionContext();
            Method method = MockFunctions.class.getDeclaredMethod("floor", double.class);
            FunctionStub floor = new FunctionStub("floor", method);
            FunctionStub floor2 = new FunctionStub("floor2", method);
            funcCxt.register("floor", floor);
            funcCxt.register("floor2", floor2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return templateCtx;
    }

    public static class MockFunctions {
        public static double floor(double a) {
            return 1.23456789;
        }
    }

}