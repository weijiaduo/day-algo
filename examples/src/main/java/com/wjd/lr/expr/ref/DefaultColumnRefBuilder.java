package com.wjd.lr.expr.ref;

import com.wjd.lr.expr.model.ColumnRef;

import java.util.ArrayList;
import java.util.List;

/**
 * 默认的列引用构造器
 *
 * @author weijiaduo
 * @since 2023/3/8
 */
public class DefaultColumnRefBuilder implements ColumnRefBuilder {

    @Override
    public String build(ColumnRef columnRef) {
        // TODO: get real column expr
        List<String> names = new ArrayList<>(3);
        if (columnRef.getSchemaName() != null) {
            names.add(columnRef.getSchemaName());
        }
        if (columnRef.getTableName() != null) {
            names.add(columnRef.getTableName());
        }
        names.add(columnRef.getColumnName());
        return String.join(".", names);
    }

}
