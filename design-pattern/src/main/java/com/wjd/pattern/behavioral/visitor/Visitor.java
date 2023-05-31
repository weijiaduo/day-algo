package com.wjd.pattern.behavioral.visitor;

/**
 * @since 2021/12/13
 */
public interface Visitor {

    void visit(File file);
    void visit(Directory directory);

}
