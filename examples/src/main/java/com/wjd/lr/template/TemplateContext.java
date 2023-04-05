package com.wjd.lr.template;

import java.util.Map;

/**
 * 模板上下文
 *
 * @author weijiaduo
 * @since 2023/4/5
 */
public interface TemplateContext {

    /**
     * 执行上下文
     *
     * @return 执行上下文
     */
    Map<String, Object> getExecuteContext();

}
