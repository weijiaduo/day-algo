package com.wjd.practice.leetcode.tree;

import com.wjd.practice.Solution;
import com.wjd.practice.leetcode.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 654. 最大二叉树
 * <p>
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * <p>
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * <p>
 * 返回 nums 构建的 最大二叉树 。
 * <p>
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 *
 * @author weijiaduo
 * @since 2022/8/20
 */
public class ConstructMaximumBinaryTree implements Solution<TreeNode> {

    @Override
    public TreeNode solve(Object... args) {
        int[] nums = {3, 2, 1};
        TreeNode result = constructMaximumBinaryTree(nums);
        System.out.println(TreeNode.bfs(result));
        return result;
    }

    private TreeNode constructMaximumBinaryTree(int[] nums) {
        // return dfs(nums, 0, nums.length);
        // return monotoneStack(nums);
        return monotoneStack2(nums);
    }

    /**
     * 思路：递归构建树，相当于中序遍历构建树
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(logn)
     * <p>
     * 执行耗时:2 ms,击败了75.72% 的Java用户
     * 内存消耗:41.7 MB,击败了24.87% 的Java用户
     *
     * @param nums  数组
     * @param start [start, end)
     * @param end   [start, end)
     * @return 根节点
     */
    private TreeNode dfs(int[] nums, int start, int end) {
        if (end <= start) {
            return null;
        }
        int index = start;
        for (int i = start + 1; i < end; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = dfs(nums, start, index);
        root.right = dfs(nums, index + 1, end);
        return root;
    }

    /**
     * 思路：一个节点的父节点，实际就是该节点左右两边第一个比自己大的节点中的一个。
     * 1、如果左边大值 < 右边大值，说明左边节点更接近当前节点，即是当前节点的父节点
     * 2、如果右边大值 < 左边大值，说明右边节点更接近当前节点，即是当前节点的父节点
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:10 ms,击败了6.47% 的Java用户
     * 内存消耗:41.8 MB,击败了12.04% 的Java用户
     *
     * @param nums 数组
     * @return 根节点
     */
    private TreeNode monotoneStack(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        TreeNode[] nodes = new TreeNode[n];

        // 单调栈求解左右两边第一个比自己大的值
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(nums[i]);
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                right[stack.pop()] = i;
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        // 根据左右边界构造树
        TreeNode root = null;
        for (int i = 0; i < n; i++) {
            if (left[i] < 0 && right[i] < 0) {
                // 没有比自己大的值，即最大值
                root = nodes[i];
            } else if (left[i] < 0 || (right[i] > -1 && nums[right[i]] < nums[left[i]])) {
                // 右边大值比左边大值小，说明右边节点才是自己的父节点
                nodes[right[i]].left = nodes[i];
            } else {
                // 左边大值比右边大值小，说明左边节点才是自己的父节点
                nodes[left[i]].right = nodes[i];
            }
        }
        return root;
    }

    /**
     * 思路：单调栈的空间优化
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:13 ms,击败了6.47% 的Java用户
     * 内存消耗:41.3 MB,击败了73.46% 的Java用户
     *
     * @param nums 数组
     * @return 根节点
     */
    private TreeNode monotoneStack2(int[] nums) {
        int n = nums.length;
        TreeNode[] nodes = new TreeNode[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(nums[i]);
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                // 找到最接近当前值得节点
                nodes[i].left = nodes[stack.pop()];
            }
            if (!stack.isEmpty()) {
                nodes[stack.peek()].right = nodes[i];
            }
            stack.push(i);
        }
        // 根节点是最大值，肯定是在栈底
        return stack.isEmpty() ? null : nodes[stack.getLast()];
    }

}
