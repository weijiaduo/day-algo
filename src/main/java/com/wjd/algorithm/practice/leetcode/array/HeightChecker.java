package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * 1051. 高度检查器
 * <p>
 * 学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 非递减 的高度顺序排成一行。
 * <p>
 * 排序后的高度情况用整数数组 expected 表示，其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。
 * <p>
 * 给你一个整数数组 heights ，表示 当前学生站位 的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。
 * <p>
 * 返回满足 heights[i] != expected[i] 的 下标数量 。
 * <p>
 * 输入：heights = [1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度：[1,1,4,2,1,3]
 * 预期：[1,1,1,2,3,4]
 * 下标 2 、4 、5 处的学生高度不匹配。
 * <p>
 * @since 2022/6/13
 */
public class HeightChecker implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[] height = {1,2,3,4,5};
        int result = heightChecker(height);
        System.out.println(result);
        return result;
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.2 MB,击败了58.22% 的Java用户
     */
    public int heightChecker(int[] heights) {
        int k = heights.length;
        int[] counts = new int[101];
        for (int height : heights) {
            counts[height]++;
            k = Math.min(k, height);
        }
        int count = 0;
        for (int height : heights) {
            if (height != k) {
                count++;
            }
            counts[k]--;
            while (k < counts.length && counts[k] == 0) {
                k++;
            }
        }
        return count;
    }

}
