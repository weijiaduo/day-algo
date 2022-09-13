package com.wjd.practice.leetcode.math;

import com.wjd.practice.Solution;

/**
 * 670. 最大交换
 * <p>
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * <p>
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 *
 * @author weijiaduo
 * @since 2022/9/13
 */
public class MaximumSwap implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int num = 98368;
        int result = maximumSwap(num);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：
     * <p>
     * 在数字的右边找到比自己大的数字，替换以后就能得到更大值。
     * <p>
     * 而要取最大值，那么就要找到右边比自己大的最大值，然后交换。
     * <p>
     * 从高位往低位遍历，看谁先找到比自己大的数字，交换后就是最大值。
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了37.22% 的Java用户
     * 内存消耗:38.2 MB,击败了81.32% 的Java用户
     *
     * @param num 整数
     * @return 交换后的整数
     */
    public int maximumSwap(int num) {
        char[] digits = ("" + num).toCharArray();
        int n = digits.length;

        // 记录右边的最大值
        // -1表示右边的数字都不大于自己
        int[] maxes = new int[n];
        int swapIndex = -1, maxIndex = n - 1;
        maxes[maxIndex] = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (digits[i] > digits[maxIndex]) {
                maxIndex = i;
                maxes[i] = -1;
            } else if (digits[i] == digits[maxIndex]) {
                // 最大数字的位置越靠低位越好
                maxes[i] = -1;
            } else {
                maxes[i] = maxIndex;
                swapIndex = i;
            }
        }

        if (swapIndex != -1) {
            char c = digits[swapIndex];
            digits[swapIndex] = digits[maxes[swapIndex]];
            digits[maxes[swapIndex]] = c;
        }

        return Integer.parseInt(new String(digits));
    }

    /**
     * 思路：优化掉空间，直接用2个变量保存交换位置即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了37.22% 的Java用户
     * 内存消耗:38.3 MB,击败了61.02% 的Java用户
     *
     * @param num 整数
     * @return 交换后的整数
     */
    private int maximumSwap2(int num) {
        char[] digits = ("" + num).toCharArray();
        int n = digits.length;

        // 记录可交换的位置和右边的最大值位置
        int maxIndex = n - 1;
        int swapIndex1 = -1, swapIndex2 = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (digits[i] > digits[maxIndex]) {
                maxIndex = i;
            } else if (digits[i] < digits[maxIndex]) {
                swapIndex1 = i;
                swapIndex2 = maxIndex;
            }
        }

        if (swapIndex1 != -1) {
            char c = digits[swapIndex1];
            digits[swapIndex1] = digits[swapIndex2];
            digits[swapIndex2] = c;
        }

        return Integer.parseInt(new String(digits));
    }

}
