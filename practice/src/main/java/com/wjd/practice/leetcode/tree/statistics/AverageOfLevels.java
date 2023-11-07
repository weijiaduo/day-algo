package com.wjd.practice.leetcode.tree.statistics;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 637. 二叉树的层平均值
 * <p>
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。
 * <p>
 * 与实际答案相差 10⁻⁵ 以内的答案可以被接受。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
 * 因此返回 [3, 14.5, 11] 。
 * <p>
 * 示例 2:
 * <p>
 * 输入：root = [3,9,20,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * <p>
 * 提示：
 * <p>
 * 树中节点数量在 [1, 10⁴] 范围内
 * -2³¹ <= Node.val <= 2³¹ - 1
 *
 * @author weijiaduo
 * @since 2023/11/7
 */
public class AverageOfLevels {

    /**
     * 思路：层序遍历，统计层级节点和以及节点数量即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(w)
     * <p>
     * 执行耗时:2 ms,击败了92.75% 的Java用户
     * 内存消耗:43.3 MB,击败了66.64% 的Java用户
     */
    @TestCase(input = {"[3,9,20,null,null,15,7]", "[3,9,20,15,7]", "[2147483647,2147483647,2147483647]"},
            output = {"[3.00000,14.50000,11.00000]", "[3.00000,14.50000,11.00000]", "[2147483647.0,2147483647.0]"})
    public List<Double> bfs(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(sum / size);
        }
        return list;
    }

}
