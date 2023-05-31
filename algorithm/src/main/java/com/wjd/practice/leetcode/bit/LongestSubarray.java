package com.wjd.practice.leetcode.bit;

/**
 * 6189. 按位与最大的最长子数组
 *
 * @author weijiaduo
 * @since 2022/9/25
 */
public class LongestSubarray {

    /**
     * 思路：找到最大值，然后往最大值的左右两边扩展，得到最长子数组
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        int ans = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != max) {
                continue;
            }
            int sum = nums[i];
            int l = i - 1, r = i + 1;
            while (l >= 0 && (sum <= (sum & nums[l]))) {
                l--;
            }
            while (r < n && (sum <= (sum & nums[r]))) {
                r++;
            }
            ans = Math.max(r - l - 1, ans);
            i = r - 1;
        }
        return ans;
    }

}
