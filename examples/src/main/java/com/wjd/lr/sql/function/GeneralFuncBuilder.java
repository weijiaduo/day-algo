package com.wjd.lr.sql.function;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ExprContext;
import com.wjd.lr.expr.ast.BoolValue;
import com.wjd.lr.expr.ast.Function;
import com.wjd.lr.sql.SqlFunctions;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 通用函数构建器
 *
 * @author weijiaduo
 * @since 2023/3/8
 */
public class GeneralFuncBuilder implements FunctionBuilder {

    /**
     * 函数集合
     */
    protected Map<String, Method> functionMap = new HashMap<>();
    /**
     * Expression context
     */
    protected ExprContext ctx;

    public GeneralFuncBuilder() {
        try {
            // 注册所有声明的函数方法
            for (Method m : getClass().getMethods()) {
                String funcName = m.getName().toLowerCase();
                if (SqlFunctions.get(funcName) != null) {
                    functionMap.put(funcName, m);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String build(Function function) {
        try {
            String name = function.getName().toLowerCase();
            Method m = functionMap.get(name);
            if (m != null) {
                return (String) m.invoke(this, function);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buildDefault(function);
    }

    /**
     * Sets ctx.
     *
     * @param ctx expression context
     */
    public void setCtx(ExprContext ctx) {
        this.ctx = ctx;
    }

    /**
     * 函数构建的默认实现
     *
     * @param function 函数
     * @return 函数表达式字符串 string
     */
    protected String buildDefault(Function function) {
        List<String> paramStrings = function.getParams().stream().map(p -> p.toStr(ctx)).toList();
        return String.format("%s(%s)", function.getName(), String.join(", ", paramStrings));
    }

    /**
     * Lower Function
     *
     * @param function the function
     * @return the string
     */
    public String lower(Function function) {
        return buildDefault(function);
    }

    /**
     * Max Function
     *
     * @param function the function
     * @return the string
     */
    public String max(Function function) {
        return buildDefault(function);
    }

    /**
     * Min Function
     *
     * @param function the function
     * @return the string
     */
    public String min(Function function) {
        return buildDefault(function);
    }

    /**
     * Replace Function
     *
     * @param function the function
     * @return the string
     */
    public String replace(Function function) {
        return buildDefault(function);
    }

    /**
     * Substring Function
     *
     * @param function the function
     * @return the string
     */
    public String substring(Function function) {
        return buildDefault(function);
    }

    /**
     * Upper Function
     *
     * @param function the function
     * @return the string
     */
    public String upper(Function function) {
        return buildDefault(function);
    }

    /**
     * Day Function
     *
     * @param function the function
     * @return the string
     */
    public String day(Function function) {
        return buildDefault(function);
    }

    /**
     * Month Function
     *
     * @param function the function
     * @return the string
     */
    public String month(Function function) {
        return buildDefault(function);
    }

    /**
     * Year Function
     *
     * @param function the function
     * @return the string
     */
    public String year(Function function) {
        return buildDefault(function);
    }

    /**
     * Abs Function
     *
     * @param function the function
     * @return the string
     */
    public String abs(Function function) {
        return buildDefault(function);
    }

    /**
     * Avg Function
     *
     * @param function the function
     * @return the string
     */
    public String avg(Function function) {
        return buildDefault(function);
    }

    /**
     * Ceiling Function
     *
     * @param function the function
     * @return the string
     */
    public String ceiling(Function function) {
        return buildDefault(function);
    }

    /**
     * Count Function
     *
     * @param function the function
     * @return the string
     */
    public String count(Function function) {
        return buildDefault(function);
    }

    /**
     * Floor Function
     *
     * @param function the function
     * @return the string
     */
    public String floor(Function function) {
        return buildDefault(function);
    }

    /**
     * Round Function
     *
     * @param function the function
     * @return the string
     */
    public String round(Function function) {
        return buildDefault(function);
    }

    /**
     * Sign Function
     *
     * @param function the function
     * @return the string
     */
    public String sign(Function function) {
        return buildDefault(function);
    }

    /**
     * Sum Function
     *
     * @param function the function
     * @return the string
     */
    public String sum(Function function) {
        return buildDefault(function);
    }

    /**
     * Gets date.
     *
     * @param function the function
     * @return the date
     */
    public String getDate(Function function) {
        return buildDefault(function);
    }

    /**
     * Null if Function
     *
     * @param function the function
     * @return the string
     */
    public String nullIf(Function function) {
        return buildDefault(function);
    }

    /**
     * Case when Function
     *
     * @param function the function
     * @return the string
     */
    public String caseWhen(Function function) {
        StringBuilder sql = new StringBuilder();
        sql.append("case");
        List<Expr> params = function.getParams();
        Expr caseExpr = params.get(0);
        if (caseExpr != null) {
            sql.append(" ").append(caseExpr.toStr(ctx));
        }
        for (int i = 1; i < params.size() - 1; i += 2) {
            Expr whenExpr = params.get(i);
            Expr thenExpr = params.get(i + 1);
            sql.append(" when ").append(whenExpr.toStr(ctx))
                    .append(" then ").append(thenExpr.toStr(ctx));
        }
        Expr elseExpr = params.get(params.size() - 1);
        if (elseExpr != null) {
            sql.append(" else ").append(elseExpr.toStr(ctx));
        }
        sql.append(" end");
        return sql.toString();
    }

    /**
     * Between Function
     *
     * @param function the function
     * @return the string
     */
    public String between(Function function) {
        List<Expr> params = function.getParams();
        Expr expr = params.get(0);
        Expr notExpr = params.get(1);
        Expr left = params.get(2);
        Expr right = params.get(3);
        boolean isNot = false;
        if (notExpr instanceof BoolValue) {
            isNot = ((BoolValue) notExpr).getValue();
        }

        StringBuilder sql = new StringBuilder();
        sql.append(expr.toStr(ctx))
                .append(isNot ? " not" : "")
                .append(" between ").append(left.toStr(ctx))
                .append(" and ").append(right.toStr(ctx));
        return sql.toString();
    }

    /**
     * In Function
     *
     * @param function the function
     * @return the string
     */
    public String in(Function function) {
        List<Expr> params = function.getParams();
        Expr expr = params.get(0);
        Expr notExpr = params.get(1);
        boolean isNot = false;
        if (notExpr instanceof BoolValue) {
            isNot = ((BoolValue) notExpr).getValue();
        }
        List<String> values = params.subList(2, params.size()).stream()
                .map(e -> e.toStr(ctx))
                .collect(Collectors.toList());

        StringBuilder sql = new StringBuilder();
        sql.append(expr.toStr(ctx))
                .append(isNot ? " not" : "")
                .append(" in (")
                .append(String.join(", ", values))
                .append(")");
        return sql.toString();
    }

}
