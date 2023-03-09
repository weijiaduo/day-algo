package com.wjd.lr.expr.model;

/**
 * 列引用
 *
 * @author weijiaduo
 * @since 2023/3/8
 */
public class ColumnRef extends ExprItem {

    /**
     * Schema
     */
    private final String schemaName;
    /**
     * Table
     */
    private final String tableName;
    /**
     * Column
     */
    private final String columnName;

    public ColumnRef(String schemaName, String tableName, String columnName) {
        this.schemaName = schemaName;
        this.tableName = tableName;
        this.columnName = columnName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public String getTableName() {
        return tableName;
    }

    public String getColumnName() {
        return columnName;
    }

}
