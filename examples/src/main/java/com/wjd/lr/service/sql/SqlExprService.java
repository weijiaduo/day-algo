package com.wjd.lr.service.sql;

import com.wjd.lr.expr.ExprBuilder;
import com.wjd.lr.expr.ExprContext;
import com.wjd.lr.expr.handler.ExprHandler;
import com.wjd.lr.service.ExprService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SQL 表达式服务实现类
 *
 * @author weijiaduo
 * @since 2023/4/5
 */
public class SqlExprService implements ExprService {

    @Override
    public String build(String exprText, List<ExprHandler<?>> handlers, ExprContext ctx) {
        ExprBuilder builder = new ExprBuilder(exprText);
        List<ExprHandler<?>> allHandlers = new ArrayList<>();
        if (handlers != null) {
            allHandlers.addAll(handlers);
        }
        // 追加不影响前面的处理器，会优先用前面的
        allHandlers.addAll(getDefaultHandlers());
        for (ExprHandler<?> handler : allHandlers) {
            builder.addHandler(handler);
        }
        if (ctx == null) {
            ctx = getDefaultContext();
        }
        return builder.build().toStr(ctx);
    }

    /**
     * @return 默认表达式处理器
     */
    private List<ExprHandler<?>> getDefaultHandlers() {
        return Arrays.asList(
                new SqlFunctionHandler(),
                new SqlTemplateHandler()
        );
    }

    /**
     * @return 默认的上下文
     */
    private ExprContext getDefaultContext() {
        return new SqlExprContext();
    }

}
