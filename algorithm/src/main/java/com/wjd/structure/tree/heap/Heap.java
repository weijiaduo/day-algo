package com.wjd.structure.tree.heap;

/**
 * 堆接口
 *
 * @author weijiaduo
 * @since 2023/2/24
 */
public interface Heap<T> {

    /**
     * 移除第一个节点
     *
     * @return 第一个节点值
     */
    T removeFirst();

    /**
     * 插入新值
     *
     * @param val 新值
     */
    void insert(T val);

}
