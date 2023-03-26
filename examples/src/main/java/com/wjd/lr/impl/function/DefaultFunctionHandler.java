package com.wjd.lr.impl.function;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ast.Function;
import com.wjd.lr.expr.handler.GeneralFunctionHandler;
import com.wjd.lr.expr.type.ValueType;

import java.util.List;

/**
 * Default function handler
 *
 * @author weijiaduo
 * @since 2023/3/25
 */
public class DefaultFunctionHandler extends GeneralFunctionHandler {

    @Override
    public Expr handle(Function function) {
        // TODO: 后面要根据函数配置文件读取默认的返回值类型
        String name = function.getName().toLowerCase();
        switch (name) {
            case "casewhen":
                function.setValueType(getCaseValueType(function));
                break;
            case "between":
                function.setValueType(ValueType.BOOL);
                break;
            case "lower":
            case "replace":
            case "substring":
            case "upper":
                function.setValueType(ValueType.STRING);
                break;
            case "day":
            case "month":
            case "year":
            case "getdate":
                function.setValueType(ValueType.DATETIME);
                break;
            case "abs":
            case "avg":
            case "ceiling":
            case "count":
            case "floor":
            case "round":
            case "sign":
            case "sum":
                function.setValueType(ValueType.NUMERIC);
                break;
            default:
                break;
        }
        return function;
    }

    /**
     * handle case when
     *
     * @param function function
     * @return function
     */
    private ValueType getCaseValueType(Function function) {
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

}
