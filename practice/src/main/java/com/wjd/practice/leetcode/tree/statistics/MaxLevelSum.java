package com.wjd.practice.leetcode.tree.statistics;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1161. 最大层内元素和
 * <p>
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * <p>
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * 输出：2
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在
 * [1, 10⁴]范围内
 * <p>
 * -10⁵ <= Node.val <= 10⁵
 *
 * @author weijiaduo
 * @since 2022/7/31
 */
public class MaxLevelSum {

    /**
     * 思路：层次遍历树，统计每层的和，并更新最大和的层数即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(w)
     * <p>
     * 执行耗时:8 ms,击败了78.17% 的Java用户
     * 内存消耗:43.9 MB,击败了88.95% 的Java用户
     */
    @TestCase(input = {"[1,7,0,7,-8,null,null]", "[989,null,10250,98693,-89388,null,null,null,-32127]"},
            output = {"2", "2"})
    public int bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxSum = root.val, maxLevel = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        for (int level = 1; !queue.isEmpty(); level++) {
            int sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (sum > maxSum) {
                maxLevel = level;
                maxSum = sum;
            }
        }
        return maxLevel;
    }

}
