package com.wjd.lr.expr.model;

/**
 * 列引用
 *
 * @author weijiaduo
 * @since 2023/3/8
 */
public class ColumnRef extends ExprItem {

    /**
     * Table
     */
    private final String tableName;
    /**
     * Column
     */
    private final String columnName;

    public ColumnRef(String tableName, String columnName) {
        this.tableName = tableName;
        this.columnName = columnName;
    }

    public String getTableName() {
        return tableName;
    }

    public String getColumnName() {
        return columnName;
    }

}
