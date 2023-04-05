package com.wjd.lr.service.sql;

import com.wjd.lr.expr.ExprContext;
import com.wjd.lr.expr.handler.ExprHandler;
import com.wjd.lr.expr.handler.TemplateHandler;
import com.wjd.lr.template.fucntion.FunctionContext;
import com.wjd.lr.template.fucntion.FunctionStub;
import com.wjd.lr.template.mvel2.Mvel2TemplateContext;
import com.wjd.lr.template.variable.VariableContext;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SqlExprServiceTest {

    @Test
    void build() {
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

        SqlExprService service = new SqlExprService();
        List<ExprHandler<?>> handlers = mockHandlers();
        ExprContext context = mockExprContext();
        for (int i = 0; i < inputs.length; i++) {
            String actual = service.build(inputs[i], handlers, context);
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

    List<ExprHandler<?>> mockHandlers() {
        return Arrays.asList(
                mockTemplateHandler()
        );
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