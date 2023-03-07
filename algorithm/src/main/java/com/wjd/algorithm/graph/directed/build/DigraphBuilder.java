package com.wjd.algorithm.graph.directed.build;

import com.wjd.structure.graph.directed.Digraph;

/**
 * 有向图构建器
 *
 * @author weijiaduo
 * @since 2023/3/8
 */
public interface DigraphBuilder {

    /**
     * @return 有向图
     */
    Digraph build();

}
