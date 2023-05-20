package com.wjd.practice.leetcode.math;

import java.util.Arrays;

/**
 * 453. 最小操作次数使数组元素相等
 * <p>
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：0
 *
 * @author weijiaduo
 * @since 2023/5/20
 */
public class MinMoves {

    /**
     * 思路：官方题解，这哪想得到~
     * <p>
     * 使 n-1 个元素加1，等价于使 1 个元素减一
     * <p>
     * 只要求出其他元素减到最小值的累和即可
     * <p>
     * 复杂度：O(n) 空间 O(1)
     * <p>
     * 执行耗时:5 ms,击败了40.37% 的Java用户
     * 内存消耗:43 MB,击败了5.70% 的Java用户
     *
     * @param nums 数组
     * @return 最小操作次数
     */
    public int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int sum = 0;
        for (int num : nums) {
            sum += num - min;
        }
        return sum;
    }

    /**
     * 思路：
     * <p>
     * 假设最小操作次数是 k
     * <p>
     * 数组初始总和为 S，每次增加 n-1，k次操作后总和为 S1 = S + k*(n-1)
     * <p>
     * 因为最终所有数字相等，假设数字为 m，则总和为 S2 = n*m
     * <p>
     * 由于 S1=S2，所以有 k = (n*m - S)/(n-1)
     * <p>
     * 找到最小k，只需要找到满足整数条件的最小 m 即可
     * <p>
     * 复杂度：空间 O(1)
     * <p>
     * Time Limit Exceeded
     *
     * @param nums 数组
     * @return 最小操作次数
     */
    private int minMoves2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        long s = 0;
        long max = nums[0], min = max;
        for (int num : nums) {
            s += num;
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        int n = nums.length;
        for (; max < Integer.MAX_VALUE; max++) {
            long r = (n * max - s) % (n - 1);
            if (r != 0) {
                continue;
            }
            long k = (n * max - s) / (n - 1);
            if (k == max - min) {
                return (int) k;
            }
        }
        return -1;
    }

}
