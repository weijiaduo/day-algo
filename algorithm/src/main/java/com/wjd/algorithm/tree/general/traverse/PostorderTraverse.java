package com.wjd.algorithm.tree.general.traverse;

import com.wjd.algorithm.tree.ListVisitor;
import com.wjd.algorithm.tree.Traverse;
import com.wjd.structure.tree.binary.TreeNode;
import com.wjd.structure.tree.general.Node;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 通用树-后序遍历
 *
 * @author weijiaduo
 * @since 2022/8/28
 */
public class PostorderTraverse implements Traverse<Node> {

    /**
     * 列表访问者
     */
    private ListVisitor<Node> visitor;

    /**
     * 遍历实现类型：
     * 1：递归
     * 2：迭代
     * 3：标记
     */
    private int type = 1;

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public List<Node> traverse(Node root) {
        visitor = new ListVisitor<>();
        recursive(root);
        List<Node> list = visitor.getList();
        visitor = null;
        return list;
    }

    /**
     * 递归实现
     *
     * @param root 根节点
     */
    private void recursive(Node root) {
        if (root == null) {
            return;
        }

        if (root.children != null) {
            for (Node child : root.children) {
                recursive(child);
            }
        }
        visitor.visit(root);
    }

}
