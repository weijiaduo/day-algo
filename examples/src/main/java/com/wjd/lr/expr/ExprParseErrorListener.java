package com.wjd.lr.expr;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * 解析错误监听器
 *
 * @author weijiaduo
 * @since 2023/3/10
 */
public class ExprParseErrorListener extends BaseErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        throw new RuntimeException(msg);
    }

}
