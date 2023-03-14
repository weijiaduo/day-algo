package com.wjd.lr.expr.builder.function.dialect;

import com.wjd.lr.expr.builder.function.GeneralFuncBuilder;
import com.wjd.lr.expr.model.Function;

import java.util.ArrayList;
import java.util.List;

/**
 * ClickHouse
 *
 * @author weijiaduo
 * @since 2023/3/10
 */
public class ClickHouseFuncBuilder extends GeneralFuncBuilder {

    @Override
    public String replace(Function function) {
        return buildDefault(new Function("replaceOne", function.getParams()));
    }

    @Override
    public String substring(Function function) {
        try {
            // 索引从 1 开始
            String p2 = function.getParams().get(1);
            int start = Integer.parseInt(p2.trim());
            start = start == 0 ? 1 : start;
            List<String> ps = new ArrayList<>(function.getParams());
            ps.set(1, String.valueOf(start));
            return buildDefault(new Function(function.getName(), ps));
        } catch (Exception e) {
            // 参数不一定是数字，如果是表达式就没办法替换了
        }
        return super.substring(function);
    }

    @Override
    public String day(Function function) {
        return buildDefault(new Function("toDayOfMonth", function.getParams()));
    }

    @Override
    public String month(Function function) {
        return buildDefault(new Function("toMonth", function.getParams()));
    }

    @Override
    public String year(Function function) {
        return buildDefault(new Function("toDayOfMonth", function.getParams()));
    }

    @Override
    public String sign(Function function) {
        String p1 = function.getParams().get(0);
        return String.format("case when %s > 0 then 1 when %s = 0 then 0 else -1 end", p1, p1);
    }

    @Override
    public String getDate(Function function) {
        return buildDefault(new Function("now", function.getParams()));
    }

    @Override
    public String nullIf(Function function) {
        return buildDefault(new Function("nullIf", function.getParams()));
    }

}
