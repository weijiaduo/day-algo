package com.wjd.algorithm.tree.binary.build;

import com.wjd.structure.tree.binary.TreeNode;

/**
 * 树构建类
 *
 * @author weijiaduo
 * @since 2022/8/28
 */
public interface TreeBuilder<T> {

    TreeNode build(T values);

}
