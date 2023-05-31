package com.wjd.pattern.behavioral.iterator;

/**
 * @since 2022/1/21
 */
public interface Iterator<T> {

    boolean hasNext();
    T next();

}
