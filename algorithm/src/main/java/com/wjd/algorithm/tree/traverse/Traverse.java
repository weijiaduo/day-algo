package com.wjd.algorithm.tree.traverse;

import com.wjd.structure.tree.TreeNode;

import java.util.List;

/**
 * 遍历
 *
 * @author weijiaduo
 * @since 2022/8/28
 */
public interface Traverse {

    /**
     * 遍历
     *
     * @param root 根节点
     * @return 遍历顺序列表
     */
    List<TreeNode> traverse(TreeNode root);

}
