package com.wjd.lr.expr.builder.text;

import com.wjd.lr.expr.builder.ExprItemBuilder;
import com.wjd.lr.expr.model.TextItem;

/**
 * 文本构建器
 *
 * @author weijiaduo
 * @since 2023/3/9
 */
public class TextItemBuilder implements ExprItemBuilder<TextItem> {

    @Override
    public String build(TextItem item) {
        return item.getText();
    }

}
