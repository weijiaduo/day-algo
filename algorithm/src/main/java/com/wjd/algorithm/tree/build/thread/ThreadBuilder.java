package com.wjd.algorithm.tree.build.thread;

import com.wjd.structure.tree.TreeNode;
import com.wjd.structure.tree.thread.ThreadTreeNode;

/**
 * 线索二叉树构建
 *
 * @author weijiaduo
 * @since 2022/12/3
 */
public interface ThreadBuilder {

    ThreadTreeNode build(TreeNode root);

}
