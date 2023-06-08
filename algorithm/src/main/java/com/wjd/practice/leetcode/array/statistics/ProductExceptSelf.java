package com.wjd.practice.leetcode.array.statistics;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 * <p>
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。
 * <p>
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 10⁵
 * -30 <= nums[i] <= 30
 * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内
 *
 * @author weijiaduo
 * @since 2023/6/8
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        return productExceptSelf2(nums);
    }

    /**
     * 思路：前缀积和后缀积
     * <p>
     * 前缀积 pre[i] = nums[0] * ... * nums[i - 1]
     * <p>
     * 后缀积 suf[i] = nums[n - 1] * ... * nums[i + 1]
     * <p>
     * 指定位置的乘积 = pre[i] * suf[i]
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:2 ms,击败了25.52% 的Java用户
     * 内存消耗:49.7 MB,击败了59.09% 的Java用户
     */
    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        // 前缀积
        int[] pre = new int[n];
        pre[0] = 1;
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        // 后缀积
        int[] suf = new int[n];
        suf[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] * nums[i + 1];
        }
        // 前后乘积
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = pre[i] * suf[i];
        }
        return ret;
    }

    /**
     * 思路：优化空间，使用返回数组+两个变量保存前后缀积
     * <p>
     * 这个一次遍历真的很优雅~~~评论区是真的牛
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了25.52% 的Java用户
     * 内存消耗:50.3 MB,击败了33.35% 的Java用户
     */
    private int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, 1);
        int pre = 1, suf = 1;
        for (int i = 0; i < n; i++) {
            ret[i] *= pre;
            ret[n - 1 - i] *= suf;
            pre *= nums[i];
            suf *= nums[n - 1 - i];
        }
        return ret;
    }

}
