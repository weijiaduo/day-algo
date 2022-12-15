package com.wjd.practice.leetcode.tree;

import com.wjd.structure.tree.binary.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 * <p>
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * <p>
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * <p>
 * 假定 BST 满足如下定义：
 * <p>
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * <p>
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * <p>
 * 左子树和右子树都是二叉搜索树
 * <p>
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 *
 * @author weijiaduo
 * @since 2022/12/16
 */
public class FindMode {

    /**
     * 当前统计的众数
     */
    List<Integer> nums = new ArrayList<>();
    /**
     * 众数频率
     */
    int maxCount = 0;

    /**
     * 中序遍历的上一个值
     */
    int prev = Integer.MIN_VALUE;
    /**
     * prev 的出现频率
     */
    int count = 0;

    /**
     * 思路：中序遍历，判断当前值和前一个之值是否相等，如果相等，频率加 1
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.2 MB,击败了29.92% 的Java用户
     *
     * @param root 根节点
     * @return 众数集合
     */
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        nums = new ArrayList<>();
        maxCount = 0;
        prev = Integer.MIN_VALUE;
        count = 0;
        find(root);

        int[] arr = new int[nums.size()];
        int k = 0;
        for (Integer num : nums) {
            arr[k++] = num;
        }
        return arr;
    }

    /**
     * 深度优先遍历
     *
     * @param root 根节点
     */
    private void find(TreeNode root) {
        if (root == null) {
            return;
        }
        find(root.left);
        if (root.val == prev) {
            count++;
        } else {
            count = 1;
        }
        if (count > maxCount) {
            nums.clear();
            nums.add(root.val);
            maxCount = count;
        } else if (count == maxCount) {
            nums.add(root.val);
        }
        prev = root.val;
        find(root.right);
    }

}
