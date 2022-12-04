package com.wjd.algorithm.tree.traverse.thread;

import com.wjd.algorithm.tree.build.thread.InorderThreadBuilder;
import com.wjd.structure.tree.TreeNode;
import com.wjd.structure.tree.thread.ThreadTreeNode;

/**
 * 中序线索二叉树遍历
 *
 * @author weijiaduo
 * @since 2022/12/3
 */
public class InorderThreadTraverse implements ThreadTraverse {

    /**
     * 根节点
     */
    private final ThreadTreeNode root;
    /**
     * 遍历到的当前节点
     */
    private ThreadTreeNode cur;

    public InorderThreadTraverse(TreeNode root) {
        this.root = new InorderThreadBuilder().build(root);
    }

    @Override
    public ThreadTreeNode first() {
        cur = first0(root);
        return cur;
    }

    @Override
    public ThreadTreeNode next() {
        if (cur == null) {
            return null;
        }
        if (cur.rTag) {
            // 有后驱节点
            cur = cur.right;
        } else {
            // 无后驱节点，右子树
            cur = first0(cur.right);
        }
        return cur;
    }

    /**
     * @param root 根节点
     * @return 第一个节点
     */
    public ThreadTreeNode first0(ThreadTreeNode root) {
        if (root == null) {
            return null;
        }
        while (!root.lTag) {
            root = root.left;
        }
        return root;
    }
}
