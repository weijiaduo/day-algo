package com.wjd.practice.leetcode.array.sliding;

import com.wjd.practice.leetcode.TestCase;

/**
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 * <p>
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * <p>
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * <p>
 * 如果不存在这样的子数组，请返回 0 。
 * <p>
 * 提示 1：
 * <p>
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：2
 * 解释：你必须要删除一个元素。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10⁵
 * nums[i] 要么是 0 要么是 1 。
 *
 * @author weijiaduo
 * @since 2023/10/6
 */
public class LongestSubarray {

    /**
     * 思路：滑动窗口，窗口记录非1的个数，个数不能大于1
     * <p>
     * 复杂度：时间 O(n) 空间 O
     * <p>
     * 执行耗时:2 ms,击败了86.94% 的Java用户
     * 内存消耗:53.06MB,击败了72.42% 的Java用户
     */
    @TestCase(input = {"[1,1,0,1]", "[0,1,1,1,0,1,1,0,1]", "[1,1,1]"},
            output = {"3", "5", "2"})
    public int sliding(int[] nums) {
        int ans = 0;
        int n = nums.length, k = 1;
        // 窗口定义 [l, r)
        int l = 0, r = 0;
        while (r < n) {
            // 扩张窗口
            if (nums[r++] != 1) {
                k--;
            }
            // 收缩窗口
            while (k < 0) {
                if (nums[l++] != 1) {
                    k++;
                }
            }
            // -1 是因为要删除掉 1 个元素
            ans = Math.max(r - l - 1, ans);
        }
        return ans;
    }

}
