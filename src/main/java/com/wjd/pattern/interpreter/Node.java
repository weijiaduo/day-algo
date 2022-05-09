package com.wjd.pattern.interpreter;

/**
 * @since 2021/12/18
 */
public abstract class Node {
    public abstract void parse(Context context) throws ParseException;
}
