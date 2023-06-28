package com.wjd.practice.leetcode.array.statistics;

import java.util.Arrays;

/**
 * 1619. 删除某些元素后的数组均值
 * <p>
 * 给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。
 * <p>
 * 与 标准答案 误差在 10⁻⁵ 的结果都被视为正确结果。
 * <p>
 * 输入：arr = [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]
 * 输出：2.00000
 * 解释：删除数组中最大和最小的元素后，所有元素都等于 2，所以平均值为 2 。
 *
 * @author weijiaduo
 * @since 2022/9/14
 */
public class TrimMean {

    /**
     * 思路：排序后，直接去掉前后的 5%
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了99.73% 的Java用户
     * 内存消耗:41.3 MB,击败了41.42% 的Java用户
     *
     * @param arr 数组
     * @return 平均值
     */
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int k = (int) (n * 0.05);
        double sum = 0;
        for (int i = k; i < n - k; i++) {
            sum += arr[i];
        }
        return sum / (n - 2 * k);
    }

}
