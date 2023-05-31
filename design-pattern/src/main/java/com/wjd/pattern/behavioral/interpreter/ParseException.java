package com.wjd.pattern.behavioral.interpreter;

/**
 * @since 2021/12/18
 */
public class ParseException extends RuntimeException {

    public ParseException() {}

    public ParseException(String msg) {
        super(msg);
    }

}
