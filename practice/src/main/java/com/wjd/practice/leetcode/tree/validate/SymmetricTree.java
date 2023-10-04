package com.wjd.practice.leetcode.tree.validate;

import com.wjd.practice.leetcode.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * <p>
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 *
 * @since 2022-06-11
 */
public class SymmetricTree {

    /**
     * 思路：递归法，镜像就是左1等于右2，右1等于左1的效果
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.5 MB,击败了59.80% 的Java用户
     */
    @TestCase(input = {"[1,2,2,3,4,4,3]", "[1,2,2,null,3,null,3]"},
            output = {"true", "false"})
    public boolean dfs(TreeNode root) {
        return dfs(root, root);
    }

    private boolean dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }

        return root1.val == root2.val
                && dfs(root1.left, root2.right)
                && dfs(root1.right, root2.left);
    }

    /**
     * 思路：迭代法，按照层次遍历，判断左右子树的层次遍历是否相同
     * <p>
     * 复杂度：时间 O(n) 最坏空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了22.63% 的Java用户
     * 内存消耗:39.9 MB,击败了12.14% 的Java用户
     */
    @TestCase(input = {"[1,2,2,3,4,4,3]", "[1,2,2,null,3,null,3]"},
            output = {"true", "false"})
    public boolean iterator(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.add(root.left);
        rightQueue.add(root.right);
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode l = leftQueue.poll();
            TreeNode r = rightQueue.poll();
            if (l == null || r == null) {
                if (l != r) {
                    return false;
                } else {
                    continue;
                }
            }
            if (l.val != r.val) {
                return false;
            }

            // 先左后右
            leftQueue.add(l.left);
            leftQueue.add(l.right);
            // 先右后左
            rightQueue.add(r.right);
            rightQueue.add(r.left);
        }
        return leftQueue.isEmpty() && rightQueue.isEmpty();
    }

}
