package com.wjd.practice.book.sword.tree;

import com.wjd.practice.book.sword.structure.TreeLinkNode;

/**
 * 8. 二叉树的下一个结点
 * <p>
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * <p>
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * @author weijiaduo
 * @since 2023/11/22
 */
public class NextNodeInBinaryTrees {

    /**
     * 思路：分情况讨论
     * <p>
     * 1. 如果一个节点有右子树，那么它的下一个节点就是它的右子树中的最左子节点
     * <p>
     * 2. 如果一个节点没有右子树，且它是它父节点的左子节点，那么它的下一个节点就是它的父节点
     * <p>
     * 3. 如果一个节点没有右子树，且它是它父节点的右子节点，那么沿着它的父节点向上遍历，直到找到一个是它父节点的左子节点的节点
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        TreeLinkNode cur = pNode;
        if (cur.right != null) {
            cur = cur.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        } else {
            TreeLinkNode parent = cur.parent;
            while (parent != null && parent.right == cur) {
                cur = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

}
