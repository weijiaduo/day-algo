package com.wjd.algorithm.tree.binary.traverse;

import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 列表访问者
 *
 * @author weijiaduo
 * @since 2022/11/26
 */
public class ListVisitor implements Visitor {

    final private List<TreeNode> list = new ArrayList<>();

    @Override
    public void visit(TreeNode node) {
        list.add(node);
    }

    public List<TreeNode> getList() {
        return list;
    }

}
