package com.wjd.lr.expr;

import com.wjd.lr.expr.adapter.ParseTreeAdapter;
import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.antlr.ExprParserBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 表达式语法树访问者
 *
 * @author weijiaduo
 * @since 2023/3/7
 */
public class AbstractExprVisitor<T> extends ExprParserBaseVisitor<T> {

    /**
     * 类型转换适配器
     */
    protected final List<ParseTreeAdapter<T>> adapters = new ArrayList<>();

    /**
     * 添加适配器
     *
     * @param adapter 适配器
     */
    public void addAdapter(ParseTreeAdapter<T> adapter) {
        adapters.add(adapter);
    }

    /**
     * 获取适配器
     *
     * @param parseTree 语法树节点
     * @return 适配器
     */
    private ParseTreeAdapter<T> getAdapter(ParseTree parseTree) {
        for (ParseTreeAdapter<T> adapter : adapters) {
            if (adapter.accept(parseTree)) {
                return adapter;
            }
        }
        return null;
    }

    @Override
    public T visitTerminal(TerminalNode node) {
        ParseTreeAdapter<T> adapter = getAdapter(node);
        if (adapter != null) {
            return adapter.adapt(node);
        }
        return super.visitTerminal(node);
    }

    @Override
    public T visitParse(ExprParser.ParseContext ctx) {
        ParseTreeAdapter<T> adapter = getAdapter(ctx);
        if (adapter != null) {
            return adapter.adapt(ctx);
        }
        return super.visitParse(ctx);
    }

    @Override
    public T visitCompare(ExprParser.CompareContext ctx) {
        ParseTreeAdapter<T> adapter = getAdapter(ctx);
        if (adapter != null) {
            return adapter.adapt(ctx);
        }
        return super.visitCompare(ctx);
    }

    @Override
    public T visitFunction(ExprParser.FunctionContext ctx) {
        ParseTreeAdapter<T> adapter = getAdapter(ctx);
        if (adapter != null) {
            return adapter.adapt(ctx);
        }
        return super.visitFunction(ctx);
    }

    @Override
    public T visitColumn(ExprParser.ColumnContext ctx) {
        ParseTreeAdapter<T> adapter = getAdapter(ctx);
        if (adapter != null) {
            return adapter.adapt(ctx);
        }
        return super.visitColumn(ctx);
    }

    @Override
    public T visitArithmetic(ExprParser.ArithmeticContext ctx) {
        ParseTreeAdapter<T> adapter = getAdapter(ctx);
        if (adapter != null) {
            return adapter.adapt(ctx);
        }
        return super.visitArithmetic(ctx);
    }

    @Override
    public T visitUnary(ExprParser.UnaryContext ctx) {
        ParseTreeAdapter<T> adapter = getAdapter(ctx);
        if (adapter != null) {
            return adapter.adapt(ctx);
        }
        return super.visitUnary(ctx);
    }

    @Override
    public T visitLogic(ExprParser.LogicContext ctx) {
        ParseTreeAdapter<T> adapter = getAdapter(ctx);
        if (adapter != null) {
            return adapter.adapt(ctx);
        }
        return super.visitLogic(ctx);
    }

    @Override
    public T visitCaseWhen(ExprParser.CaseWhenContext ctx) {
        ParseTreeAdapter<T> adapter = getAdapter(ctx);
        if (adapter != null) {
            return adapter.adapt(ctx);
        }
        return super.visitCaseWhen(ctx);
    }

    @Override
    public T visitValue(ExprParser.ValueContext ctx) {
        ParseTreeAdapter<T> adapter = getAdapter(ctx);
        if (adapter != null) {
            return adapter.adapt(ctx);
        }
        return super.visitValue(ctx);
    }

    @Override
    public T visitWrap(ExprParser.WrapContext ctx) {
        ParseTreeAdapter<T> adapter = getAdapter(ctx);
        if (adapter != null) {
            return adapter.adapt(ctx);
        }
        return super.visitWrap(ctx);
    }

    @Override
    public T visitScript(ExprParser.ScriptContext ctx) {
        ParseTreeAdapter<T> adapter = getAdapter(ctx);
        if (adapter != null) {
            return adapter.adapt(ctx);
        }
        return super.visitScript(ctx);
    }

    @Override
    public T visitBetween(ExprParser.BetweenContext ctx) {
        ParseTreeAdapter<T> adapter = getAdapter(ctx);
        if (adapter != null) {
            return adapter.adapt(ctx);
        }
        return super.visitBetween(ctx);
    }

    @Override
    public T visitLiteral(ExprParser.LiteralContext ctx) {
        ParseTreeAdapter<T> adapter = getAdapter(ctx);
        if (adapter != null) {
            return adapter.adapt(ctx);
        }
        return super.visitLiteral(ctx);
    }

    @Override
    public T visitTemplate(ExprParser.TemplateContext ctx) {
        ParseTreeAdapter<T> adapter = getAdapter(ctx);
        if (adapter != null) {
            return adapter.adapt(ctx);
        }
        return super.visitTemplate(ctx);
    }

    @Override
    public T visitColumnRef(ExprParser.ColumnRefContext ctx) {
        ParseTreeAdapter<T> adapter = getAdapter(ctx);
        if (adapter != null) {
            return adapter.adapt(ctx);
        }
        return super.visitColumnRef(ctx);
    }

    @Override
    public T visitGeneralFunc(ExprParser.GeneralFuncContext ctx) {
        ParseTreeAdapter<T> adapter = getAdapter(ctx);
        if (adapter != null) {
            return adapter.adapt(ctx);
        }
        return super.visitGeneralFunc(ctx);
    }

    @Override
    public T visitNativeFunc(ExprParser.NativeFuncContext ctx) {
        ParseTreeAdapter<T> adapter = getAdapter(ctx);
        if (adapter != null) {
            return adapter.adapt(ctx);
        }
        return super.visitNativeFunc(ctx);
    }

    @Override
    public T visitFuncName(ExprParser.FuncNameContext ctx) {
        ParseTreeAdapter<T> adapter = getAdapter(ctx);
        if (adapter != null) {
            return adapter.adapt(ctx);
        }
        return super.visitFuncName(ctx);
    }

    @Override
    public T visitTableName(ExprParser.TableNameContext ctx) {
        ParseTreeAdapter<T> adapter = getAdapter(ctx);
        if (adapter != null) {
            return adapter.adapt(ctx);
        }
        return super.visitTableName(ctx);
    }

    @Override
    public T visitColumnName(ExprParser.ColumnNameContext ctx) {
        ParseTreeAdapter<T> adapter = getAdapter(ctx);
        if (adapter != null) {
            return adapter.adapt(ctx);
        }
        return super.visitColumnName(ctx);
    }

    @Override
    public T visitRefName(ExprParser.RefNameContext ctx) {
        ParseTreeAdapter<T> adapter = getAdapter(ctx);
        if (adapter != null) {
            return adapter.adapt(ctx);
        }
        return super.visitRefName(ctx);
    }

    @Override
    public T visitAnyName(ExprParser.AnyNameContext ctx) {
        ParseTreeAdapter<T> adapter = getAdapter(ctx);
        if (adapter != null) {
            return adapter.adapt(ctx);
        }
        return super.visitAnyName(ctx);
    }

}
