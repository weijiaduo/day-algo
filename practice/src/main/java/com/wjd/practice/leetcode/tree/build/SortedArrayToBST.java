package com.wjd.practice.leetcode.tree.build;

import com.wjd.practice.TestCase;
import com.wjd.structure.tree.binary.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * <p>
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10⁴
 * -10⁴ <= nums[i] <= 10⁴
 * nums 按 严格递增 顺序排列
 *
 * @since 2022/6/18
 */
public class SortedArrayToBST {

    /**
     * 思路：用递归二分法创建树即可，两边可保持平衡
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.2 MB,击败了67.89% 的Java用户
     */
    @TestCase(input = {"[-10,-3,0,5,9]", "[1,3]"},
            output = {"[0,-10,5,null,-3,null,9]", "[1,null,3]"})
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int from, int to) {
        if (from > to) {
            return null;
        }
        int mid = from + (to - from) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, from, mid - 1);
        root.right = buildTree(nums, mid + 1, to);
        return root;
    }

}
