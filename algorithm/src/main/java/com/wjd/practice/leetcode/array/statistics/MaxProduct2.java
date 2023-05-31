package com.wjd.practice.leetcode.array.statistics;

/**
 * 1464. 数组中两元素的最大乘积
 *
 * @author weijiaduo
 * @since 2022/8/26
 */
public class MaxProduct2 {

    /**
     * 思路：乘积最大值 = 最大值 * 次大值，扫一遍数组就能拿到这2个值
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.3 MB,击败了15.85% 的Java用户
     *
     * @param nums 数组
     * @return 最大乘积
     */
    public int maxProduct(int[] nums) {
        int first = 0, second = first;
        for (int num : nums) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second) {
                second = num;
            }
        }
        return (first - 1) * (second - 1);
    }

}
