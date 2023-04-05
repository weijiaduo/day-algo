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
    public String strName(String name) {
        return name;
    }

    @Override
    public String strColumnRef(ColumnRef columnRef) {
        StringBuilder sb = new StringBuilder();
        if (columnRef.getTableName() != null) {
            sb.append(strName(columnRef.getTableName())).append(".");
        }
        sb.append(strName(columnRef.getColumnName()));
        return sb.toString();
    }

    @Override
    public String strFunction(Function function) {
        List<String> paramStrings = function.getParams().stream().map(p -> p.toStr(this)).toList();
        return String.format("%s(%s)", function.getName(), String.join(", ", paramStrings));
    }

}
