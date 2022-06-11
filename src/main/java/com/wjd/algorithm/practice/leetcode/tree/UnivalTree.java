package com.wjd.algorithm.practice.leetcode.tree;

import com.wjd.algorithm.practice.leetcode.Solution;
import com.wjd.algorithm.practice.leetcode.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 965. 单值二叉树
 * <p>
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * <p>
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * <p>
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * <p>
 * @since 2022/5/24
 */
public class UnivalTree implements Solution<Boolean> {

    @Override
    public Boolean solve(Object ...args) {
        Integer[] values = {1,2,1,1,1,null,1};
        TreeNode root = TreeNode.build(values);
        boolean result = isUnivalTree(root);
        System.out.println(result);
        return result;
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.1 MB,击败了31.71% 的Java用户
     */
    public boolean isUnivalTree(TreeNode root) {
        int value = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (node.val != value) {
                return false;
            }
        }
        return true;
    }

}
