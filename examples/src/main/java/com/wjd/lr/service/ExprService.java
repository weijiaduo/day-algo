package com.wjd.lr.service;

import com.wjd.lr.expr.ExprContext;
import com.wjd.lr.expr.handler.ExprHandler;

import java.util.List;

/**
 * 表达式服务接口
 *
 * @author weijiaduo
 * @since 2023/4/5
 */
public interface ExprService {

    /**
     * 构建表达式 -> 字符串
     *
     * @param exprText 表达式文本
     * @param handlers 表达式处理器
     * @param ctx      表达式上下文
     * @return 表达式字符串
     */
    String build(String exprText, List<ExprHandler<?>> handlers, ExprContext ctx);

}
