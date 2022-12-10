package com.wjd.algorithm.tree.binary.traverse;

import com.wjd.structure.tree.binary.TreeNode;

/**
 * 访问者模式
 *
 * @author weijiaduo
 * @since 2022/11/26
 */
public interface Visitor {

    void visit(TreeNode node);

}
