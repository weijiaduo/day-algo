package com.wjd.algorithm.tree.traverse.thread;

import com.wjd.algorithm.tree.build.thread.PostorderThreadBuilder;
import com.wjd.structure.tree.TreeNode;
import com.wjd.structure.tree.thread.ThreadTreeNode;

/**
 * 后序线索二叉树树
 *
 * @author weijiaduo
 * @since 2022/12/4
 */
public class PostorderThreadTraverse implements ThreadTraverse {

    /**
     * 根节点
     */
    private final ThreadTreeNode root;
    /**
     * 遍历到的当前节点
     */
    private ThreadTreeNode cur;

    public PostorderThreadTraverse(TreeNode root) {
        this.root = new PostorderThreadBuilder().build(root);
    }

    @Override
    public ThreadTreeNode first() {
        if (root.left != null) {
            cur = first0(root.left);
        } else {
            cur = first0(root.right);
        }
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
            // 无后驱节点，先右子树，再父节点
            ThreadTreeNode parent = cur.parent;
            if (parent == null) {
                cur = null;
            } else if (parent.right != null && !parent.rTag && parent.right != cur) {
                cur = first0(parent.right);
            } else {
                cur = parent;
            }
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
