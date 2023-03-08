package com.wjd.lr.expr.template;

import com.wjd.lr.expr.model.Template;

/**
 * 模板构建器
 *
 * @author weijiaduo
 * @since 2023/3/8
 */
public interface TemplateBuilder {

    /**
     * 构建模板字符串
     *
     * @param template 模板
     * @return 模板字符串
     */
    String build(Template template);

}
