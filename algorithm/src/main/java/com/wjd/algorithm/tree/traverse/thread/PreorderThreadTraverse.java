package com.wjd.algorithm.tree.traverse.thread;

import com.wjd.algorithm.tree.build.thread.PreorderThreadBuilder;
import com.wjd.structure.tree.TreeNode;
import com.wjd.structure.tree.thread.ThreadTreeNode;

/**
 * 前序线索二叉树遍历
 *
 * @author weijiaduo
 * @since 2022/12/4
 */
public class PreorderThreadTraverse implements ThreadTraverse {

    /**
     * 根节点
     */
    private final ThreadTreeNode root;
    /**
     * 遍历到的当前节点
     */
    private ThreadTreeNode cur;

    public PreorderThreadTraverse(TreeNode root) {
        this.root = new PreorderThreadBuilder().build(root);
    }

    @Override
    public ThreadTreeNode first() {
        cur = root;
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
            // 无后驱节点，子节点先左后右
            if (cur.left != null && !cur.lTag) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return cur;
    }

}
