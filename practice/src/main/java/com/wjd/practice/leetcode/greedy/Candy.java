package com.wjd.practice.leetcode.greedy;

import com.wjd.practice.TestCase;

/**
 * 135. 分发糖果
 * <p>
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * <p>
 * 你需要按照以下要求，给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * <p>
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * <p>
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * <p>
 * 示例 2：
 * <p>
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 * <p>
 * 提示：
 * <p>
 * n == ratings.length
 * 1 <= n <= 2 * 10⁴
 * 0 <= ratings[i] <= 2 * 10⁴
 *
 * @author weijiaduo
 * @since 2022/6/27
 */
public class Candy {

    /**
     * 官解：左遍历一遍，计算[i-1]和[i]的糖果，右遍历一遍，计算[i]和[i+1]的糖果
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:2 ms,击败了98.20% 的Java用户
     * 内存消耗:41.8 MB,击败了74.66% 的Java用户
     */
    @TestCase(input = {"[1,0,2]", "[1,2,2]"},
            output = {"5", "4"})
    public int leftRightCandy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0, ret = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            ret += Math.max(left[i], right);
        }
        return ret;
    }

    /**
     * 官解：利用递增序列和递减序列，看递增递减序列谁比较长
     * <p>
     * 复杂度：时间 O(n)，空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了98.20% 的Java用户
     * 内存消耗:42.5 MB,击败了5.82% 的Java用户
     */
    @TestCase(input = {"[1,0,2]", "[1,2,2]"},
            output = {"5", "4"})
    public int upDownCandy(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    // 如果递减序列比递增序列长
                    // 那么递增序列的最后一个元素应该算是递减序列里面的
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }

}
