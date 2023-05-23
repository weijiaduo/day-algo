package com.wjd.lr.sql.expr;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ast.Function;
import com.wjd.lr.expr.handler.GeneralFunctionHandler;
import com.wjd.lr.expr.type.ValueType;
import com.wjd.lr.sql.SqlFunctions;
import com.wjd.lr.sql.FunctionDescriptor;

import java.util.List;

/**
 * Function expr handler
 *
 * @author weijiaduo
 * @since 2023/3/25
 */
public class SqlFunctionHandler extends GeneralFunctionHandler {

    @Override
    public Expr handle(Function function) {
        String name = function.getName().toLowerCase();
        switch (name) {
            case "casewhen" -> function.setValueType(getCaseReturnType(function));
            case "between" -> function.setValueType(ValueType.BOOL);
            case "nullif" -> function.setValueType(getNullIfReturnType(function));
            default -> {
                FunctionDescriptor descriptor = SqlFunctions.get(name);
                if (descriptor != null) {
                    function.setValueType(descriptor.getReturnType());
                }
            }
        }
        return function;
    }

    private ValueType getCaseReturnType(Function function) {
        ValueType type = null;
        List<Expr> params = function.getParams();
        Expr elseExpr = params.get(params.size() - 1);
        if (elseExpr != null) {
            type = elseExpr.getValueType();
        }
        for (int i = 2; type == null && i < params.size() - 1; i += 2) {
            Expr expr = params.get(i);
            type = expr.getValueType();
        }
        if (type == null) {
            Expr caseExpr = params.get(0);
            if (caseExpr != null) {
                type = caseExpr.getValueType();
            }
        }
        return type;
    }

    private ValueType getNullIfReturnType(Function function) {
        List<Expr> params = function.getParams();
        Expr a = params.get(0);
        Expr b = params.get(1);
        if (a.getValueType() != null) {
            return a.getValueType();
        }
        return b.getValueType();
    }

    private FunctionDescriptor getFunctionDescriptor(String funcName) {
        return SqlFunctions.get(funcName);
    }

}
