package com.wjd.practice.leetcode.tree;

import com.wjd.practice.leetcode.Solution;
import com.wjd.practice.leetcode.structure.TreeNode;

/**
 * 114. 二叉树展开为链表
 * <p>
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * <p>
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * <p>
 * @since 2022/6/19
 */
public class Flatten implements Solution<Void> {

    @Override
    public Void solve(Object... args) {
        Integer[] values = {0};
        TreeNode root = TreeNode.build(values);
        System.out.println(TreeNode.bfs(root));
        flatten(root);
        System.out.println(TreeNode.bfs(root));
        return null;
    }

    private void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root);
        root.left = null;
    }

    /**
     * 思路：递归构造链表，先把左子树构成链表，返回链头，再把右子树构造成链表，也是返回链头，然后把根-左链表-右链表连接起来即可
     *      连接左链表-右链表时，需要知道左链表的链尾，遍历一次也可以，但是为了提高速度，直接用 root.left 保存链尾，快速指向
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.1 MB,击败了33.04% 的Java用户
     */
    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tail = root, temp;
        TreeNode left = root.left, right = root.right;
        if (left != null) {
            // 左子树成链
            tail.right = dfs(left);
            temp = tail.right.left;
            tail.right.left = null;
            tail = temp;
        }
        if (right != null) {
            // 右子树成链
            tail.right = dfs(right);
            temp = tail.right.left;
            tail.right.left = null;
            tail = temp;
        }
        // 用 root.left 保存链尾
        root.left = tail;
        return root;
    }

}
