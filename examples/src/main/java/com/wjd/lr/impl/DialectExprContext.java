package com.wjd.lr.impl;

import com.wjd.lr.expr.DefaultExprContext;
import com.wjd.lr.expr.ast.Function;
import com.wjd.lr.impl.function.FunctionBuilder;
import com.wjd.lr.impl.function.FunctionBuilderFactory;
import com.wjd.lr.impl.function.GeneralFuncBuilder;

/**
 * @author weijiaduo
 * @since 2023/3/25
 */
public class DialectExprContext extends DefaultExprContext {

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
    public DialectExprContext() {
        this("");
    }

    /**
     * Instantiates a new Dialect expr context.
     *
     * @param dialectType the dialect type
     */
    public DialectExprContext(String dialectType) {
        this.dialectType = dialectType;
        GeneralFuncBuilder funcBuilder = FunctionBuilderFactory.create(dialectType);
        funcBuilder.setCtx(this);
        this.functionBuilder = funcBuilder;
    }

    @Override
    public String quoteName(String name) {
        if (sqlBuilder == null) {
            return name;
        }
        return sqlBuilder.getPreQuote() + name + sqlBuilder.getPostQuote();
    }

    @Override
    public String sqlFunction(Function function) {
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
