package com.wjd.lr.expr.ast;

import com.wjd.lr.expr.ExprType;
import com.wjd.lr.expr.AbstractExpr;
import com.wjd.lr.expr.ExprContext;

/**
 * Template
 *
 * @author weijiaduo
 * @since 2023/3/25
 */
public class Template extends AbstractExpr {

    private final String script;

    /**
     * Instantiates a new Template.
     *
     * @param script the script
     */
    public Template(String script) {
        this.script = script;
    }

    @Override
    public ExprType getType() {
        return ExprType.TEMPLATE;
    }

    @Override
    public String toStr(ExprContext context) {
        return script;
    }

    /**
     * Get Macro script
     *
     * @return script
     */
    public String getScript() {
        return script;
    }

}
