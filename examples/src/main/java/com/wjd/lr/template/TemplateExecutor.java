package com.wjd.lr.template;

/**
 * 模板执行器
 *
 * @author weijiaduo
 * @since 2023/4/5
 */
public interface TemplateExecutor {

    /**
     * 执行模板
     *
     * @param template 模板
     * @param context 模板上下文
     * @return 执行结果
     */
    Object execute(String template, TemplateContext context);

}
