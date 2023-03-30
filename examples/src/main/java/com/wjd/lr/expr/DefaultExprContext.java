package com.wjd.lr.expr;

import com.wjd.lr.expr.ast.ColumnRef;
import com.wjd.lr.expr.ast.Function;

import java.util.List;

/**
 * The Default Expr Context
 *
 * @author weijiaduo
 * @since 2023/3/26
 */
public class DefaultExprContext implements ExprContext {

    @Override
    public String quoteName(String name) {
        return name;
    }

    @Override
    public String sqlColumnRef(ColumnRef columnRef) {
        StringBuilder sb = new StringBuilder();
        if (columnRef.getTableName() != null) {
            sb.append(quoteName(columnRef.getTableName())).append(".");
        }
        sb.append(quoteName(columnRef.getColumnName()));
        return sb.toString();
    }

    @Override
    public String sqlFunction(Function function) {
        List<String> paramStrings = function.getParams().stream().map(p -> p.toSql(this)).toList();
        return String.format("%s(%s)", function.getName(), String.join(", ", paramStrings));
    }

}
