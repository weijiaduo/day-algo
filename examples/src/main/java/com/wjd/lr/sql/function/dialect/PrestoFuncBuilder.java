package com.wjd.lr.sql.function.dialect;

import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ast.NumericValue;
import com.wjd.lr.sql.function.GeneralFuncBuilder;
import com.wjd.lr.expr.ast.Function;

import java.util.ArrayList;
import java.util.List;

/**
 * Presto
 *
 * @author weijiaduo
 * @since 2023/3/10
 */
public class PrestoFuncBuilder extends GeneralFuncBuilder {

    @Override
    public String substring(Function function) {
        try {
            // 索引从 1 开始
            String p2 = function.getParams().get(1).toStr(ctx);
            int start = Integer.parseInt(p2.trim());
            start = start == 0 ? 1 : start;
            List<Expr> ps = new ArrayList<>(function.getParams());
            ps.set(1, new NumericValue(start));
            return buildDefault(new Function(function.getName(), ps));
        } catch (Exception e) {
            // 参数不一定是数字，如果是表达式就没办法替换了
        }
        return super.substring(function);
    }

    @Override
    public String getDate(Function function) {
        return buildDefault(new Function("now", function.getParams()));
    }

}
