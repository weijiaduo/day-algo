package com.wjd.pattern.visitor;

/**
 * @since 2021/12/13
 */
public interface Element {
    void accept(Visitor visitor);
}
