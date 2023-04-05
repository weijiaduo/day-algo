package com.wjd.lr.service.sql;

import com.wjd.lr.expr.DefaultExprContext;
import com.wjd.lr.expr.ast.Function;
import com.wjd.lr.sql.SqlBuilder;
import com.wjd.lr.sql.function.FunctionBuilder;
import com.wjd.lr.sql.function.FunctionBuilderFactory;
import com.wjd.lr.sql.function.GeneralFuncBuilder;

/**
 * SQL 表达式上下文
 *
 * @author weijiaduo
 * @since 2023/3/25
 */
public class SqlExprContext extends DefaultExprContext {

    /**
     * DialectType
     */
    private final String dialectType;
    /**
     * SqlBuilder
     */
    private SqlBuilder sqlBuilder;
    /**
     * FunctionBuilder
     */
    private FunctionBuilder functionBuilder;

    /**
     * Instantiates a new Dialect expr context.
     */
    public SqlExprContext() {
        this("");
    }

    /**
     * Instantiates a new Dialect expr context.
     *
     * @param dialectType the dialect type
     */
    public SqlExprContext(String dialectType) {
        this.dialectType = dialectType;
        GeneralFuncBuilder funcBuilder = FunctionBuilderFactory.create(dialectType);
        funcBuilder.setCtx(this);
        this.functionBuilder = funcBuilder;
    }

    @Override
    public String strName(String name) {
        if (sqlBuilder == null) {
            return name;
        }
        return sqlBuilder.getPreQuote() + name + sqlBuilder.getPostQuote();
    }

    @Override
    public String strFunction(Function function) {
        return functionBuilder.build(function);
    }

    /**
     * @return dialect type
     */
    public String getDialectType() {
        return dialectType;
    }

    /**
     * @return SqlBuilder
     */
    public SqlBuilder getSqlBuilder() {
        return sqlBuilder;
    }

    /**
     * @param sqlBuilder SqlBuilder
     */
    public void setSqlBuilder(SqlBuilder sqlBuilder) {
        this.sqlBuilder = sqlBuilder;
    }

    /**
     * @return FunctionBuilder
     */
    public FunctionBuilder getFunctionBuilder() {
        return functionBuilder;
    }

    /**
     * @param functionBuilder FunctionBuilder
     */
    public void setFunctionBuilder(FunctionBuilder functionBuilder) {
        this.functionBuilder = functionBuilder;
    }

}
