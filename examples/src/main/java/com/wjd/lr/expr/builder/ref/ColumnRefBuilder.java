package com.wjd.lr.expr.builder.ref;

import com.wjd.lr.expr.builder.ExprItemBuilder;
import com.wjd.lr.expr.model.ColumnRef;

import java.util.ArrayList;
import java.util.List;

/**
 * 默认的列引用构造器
 *
 * @author weijiaduo
 * @since 2023/3/8
 */
public class ColumnRefBuilder implements ExprItemBuilder<ColumnRef> {

    @Override
    public String build(ColumnRef columnRef) {
        // TODO: get real column expr
        List<String> names = new ArrayList<>(3);
        if (columnRef.getSchemaName() != null) {
            names.add(getPreQuote() + columnRef.getSchemaName() + getPostQuote());
        }
        if (columnRef.getTableName() != null) {
            names.add(getPreQuote() + columnRef.getTableName() + getPostQuote());
        }
        names.add(getPreQuote() + columnRef.getColumnName() + getPostQuote());
        return String.join(".", names);
    }

    /**
     * @return previous quote
     */
    protected String getPreQuote() {
        return "";
    }

    /**
     * @return post quote
     */
    protected String getPostQuote() {
        return "";
    }

}
