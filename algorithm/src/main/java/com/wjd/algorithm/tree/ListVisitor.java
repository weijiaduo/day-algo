package com.wjd.algorithm.tree;

import com.wjd.algorithm.tree.Visitor;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 列表访问者
 *
 * @author weijiaduo
 * @since 2022/11/26
 */
public class ListVisitor<T> implements Visitor<T> {

    final private List<T> list = new ArrayList<>();

    @Override
    public void visit(T node) {
        list.add(node);
    }

    public List<T> getList() {
        return list;
    }

}
