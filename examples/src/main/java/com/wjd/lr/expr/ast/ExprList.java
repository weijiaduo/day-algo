package com.wjd.lr.expr.ast;

import com.wjd.lr.expr.ExprType;
import com.wjd.lr.expr.AbstractExpr;
import com.wjd.lr.expr.Expr;
import com.wjd.lr.expr.ExprContext;
import com.wjd.lr.expr.type.ValueType;

import java.util.ArrayList;
import java.util.List;

/**
 * 表达式集合
 *
 * @author weijiaduo
 * @since 2023/3/24
 */
public class ExprList extends AbstractExpr {

    /**
     * Expression List
     */
    private final List<Expr> exprList;

    /**
     * Instantiates a new Expr list.
     */
    public ExprList() {
        this(new ArrayList<>());
    }

    /**
     * Instantiates a new Expr list.
     *
     * @param exprList the expr list
     */
    public ExprList(List<Expr> exprList) {
        this.exprList = exprList;
    }

    @Override
    public ExprType getType() {
        return null;
    }

    @Override
    public ValueType getValueType() {
        return null;
    }

    @Override
    public String toSql(ExprContext context) {
        String[] exprSqls = exprList.stream()
                .map(e -> e.toSql(context))
                .toList()
                .toArray(new String[0]);
        return String.join(" ", exprSqls);
    }

    /**
     * @return size
     */
    public int size() {
        return exprList.size();
    }

    /**
     * @param expr expr
     */
    public void add(Expr expr) {
        this.exprList.add(expr);
    }

    /**
     * @param exprList exprList
     */
    public void addAll(ExprList exprList) {
        this.exprList.addAll(exprList.exprList);
    }

    /**
     * @param index index
     * @return Expr
     */
    public Expr get(int index) {
        return exprList.get(index);
    }

}
