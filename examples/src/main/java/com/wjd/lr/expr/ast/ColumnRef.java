package com.wjd.lr.expr.ast;

import com.wjd.lr.expr.ExprType;
import com.wjd.lr.expr.AbstractExpr;
import com.wjd.lr.expr.ExprContext;

/**
 * 列引用表达式
 *
 * @author weijiaduo
 * @since 2023/3/24
 */
public class ColumnRef extends AbstractExpr {

    /**
     * table name
     */
    private final String tableName;
    /**
     * column name
     */
    private final String columnName;

    /**
     * Instantiates a new Column ref.
     *
     * @param tableName  the table name
     * @param columnName the column name
     */
    public ColumnRef(String tableName, String columnName) {
        this.tableName = tableName;
        this.columnName = columnName;
    }

    @Override
    public ExprType getType() {
        return ExprType.COLUMN;
    }

    @Override
    public String toSql(ExprContext context) {
        StringBuilder sb = new StringBuilder();
        if (tableName != null) {
            sb.append(context.quoteName(tableName)).append(".");
        }
        sb.append(context.quoteName(columnName));
        return sb.toString();
    }

    /**
     * @return table name
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * @return column name
     */
    public String getColumnName() {
        return columnName;
    }

}
