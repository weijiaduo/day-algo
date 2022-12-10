package com.wjd.algorithm.tree.binary.traverse;

import com.wjd.structure.tree.binary.TreeNode;

/**
 * 遍历
 *
 * @author weijiaduo
 * @since 2022/8/28
 */
public interface Traverse<T> {

    /**
     * 遍历
     *
     * @param root 根节点
     * @return 遍历顺序列表
     */
    T traverse(TreeNode root);

}
