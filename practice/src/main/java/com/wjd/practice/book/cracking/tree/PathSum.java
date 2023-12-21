package com.wjd.practice.book.cracking.tree;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 04.12. 求和路径
 * <p>
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。
 * <p>
 * 设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。
 * <p>
 * 注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 * <p>
 * 示例: 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * //              5
 * //             / \
 * //            4   8
 * //           /   / \
 * //          11  13  4
 * //         /  \    / \
 * //        7    2  5   1
 * <p>
 * 返回: 3
 * <p>
 * 解释：和为 22的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 10000
 *
 * @author weijiaduo
 * @since 2023/12/21
 */
public class PathSum {

    /**
     * 思路：前缀和差 + 深度优先搜索
     * <p>
     * 从上往下深度优先搜索，并记录一路上的节点总和
     * <p>
     * 然后寻找前缀和差 cur - sum 的节点和是否存在
     * <p>
     * 如果存在，那么路径和就找到了，且以当前节点为路径结尾
     * <p>
     * 如果不存在，说明以该节点为结尾的路径和不存在
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:41.6 MB,击败了10.58% 的Java用户
     */
    @TestCase(input = {"[5,4,8,11,null,13,4,7,2,null,null,5,1]", "22"},
            output = {"3"})
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        return paths(root, 0, sum, prefix);
    }

    /**
     * 路径和为 sum 的路径数量
     *
     * @param root   当前节点
     * @param cur    上一个节点的路径和
     * @param sum    目标路径和
     * @param prefix 前缀和频率
     * @return 路径数量
     */
    private int paths(TreeNode root, int cur, int sum, Map<Integer, Integer> prefix) {
        if (root == null) {
            return 0;
        }

        cur += root.val;
        int cnt = prefix.getOrDefault(cur - sum, 0);
        prefix.put(cur, prefix.getOrDefault(cur, 0) + 1);
        cnt += paths(root.left, cur, sum, prefix);
        cnt += paths(root.right, cur, sum, prefix);
        prefix.put(cur, prefix.get(cur) - 1);
        return cnt;
    }

}
