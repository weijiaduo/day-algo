package com.wjd.practice.leetcode.array.statistics;

/**
 * 268. 丢失的数字
 * <p>
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 * @since 2021-05-29
 */
public class MissingNumber {

    /**
     * 丢失的数字
     *
     * @param nums 数组
     * @return 丢失的数字
     */
    private int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            while (0 <= t && t < n && nums[t] != nums[i]) {
                // 交换到正确的位置
                nums[t] = nums[t] ^ nums[i];
                nums[i] = nums[t] ^ nums[i];
                nums[t] = nums[t] ^ nums[i];
                t = nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }

    /**
     * 丢失的数字（官方解法）
     *
     * @param nums 数组
     * @return 丢失的数字
     */
    private int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

}
