package com.wjd.practice.book.cracking.tree;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 面试题 04.02. 最小高度树
 * <p>
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9], 一个可能的答案是：[0,-3,9,-10,null,5]
 *
 * @author weijiaduo
 * @since 2023/12/20
 */
public class SortedArrayToBST {

    /**
     * 思路：分治，将数组平分，左右两边代表子树
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:43.6 MB,击败了5.51% 的Java用户
     */
    @TestCase(input = {"[-10,-3,0,5,9]"},
            output = {"[0,-3,9,-10,null,5]"})
    public TreeNode build(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    /**
     * 构建指定区间内的数组为二叉树
     *
     * @param nums 数组
     * @param low  [low, high]
     * @param high [low, high]
     * @return 根节点
     */
    private TreeNode build(int[] nums, int low, int high) {
        if (high < low) {
            return null;
        }
        int mid = high - (high - low) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, low, mid - 1);
        root.right = build(nums, mid + 1, high);
        return root;
    }

}
