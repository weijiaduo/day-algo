package com.wjd.algorithm.practice.leetcode.tree;

import com.wjd.algorithm.practice.leetcode.Solution;
import com.wjd.algorithm.practice.leetcode.structure.TreeNode;
import com.wjd.util.ArrayUtil;

import java.util.*;

/**
 * 508. 出现次数最多的子树元素和
 * <p>
 * 给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 * <p>
 * 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * <p>
 * 输入: root = [5,2,-3]
 * 输出: [2,-3,4]
 * <p>
 * @since 2022/6/19
 */
public class FindFrequentTreeSum implements Solution<int[]> {

    @Override
    public int[] solve(Object... args) {
        Integer[] values = {5,2,-5};
        TreeNode root = TreeNode.build(values);
        System.out.println(TreeNode.bfs(root));
        int[] result = findFrequentTreeSum(root);
        ArrayUtil.print(result);
        return result;
    }

    int maxCount = 0;
    Set<Integer> valueSet = new HashSet<>();
    Map<Integer, Integer> counts = new HashMap<>();

    private int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        int[] ans = new int[valueSet.size()];
        int i = 0;
        for(Integer value : valueSet) {
           ans[i++] = value;
        }
        return ans;
    }


    /**
     * 思路：深度优先，统计子树和以及次数，并同时更新最大值以及最大值列表
     *
     * 执行耗时:2 ms,击败了100.00% 的Java用户
     * 内存消耗:41.6 MB,击败了53.35% 的Java用户
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = root.val + dfs(root.left) + dfs(root.right);
        int count = counts.getOrDefault(sum, 0) + 1;
        counts.put(sum, count);

        // 直接更新最大值列表
        if (count > maxCount) {
            maxCount = count;
            valueSet.clear();
            valueSet.add(sum);
        } else if (count == maxCount) {
            valueSet.add(sum);
        }
        return sum;
    }

}
