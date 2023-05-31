package com.wjd.pattern.behavioral.iterator;

/**
 * @since 2022/1/21
 */
public interface Aggregate<T> {

    Iterator<T> iterator();

}
