package com.wjd.practice.leetcode.string;

import com.wjd.practice.leetcode.Solution;

/**
 * 1422. 分割字符串的最大得分
 * <p>
 * 给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。
 * <p>
 * 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
 * <p>
 * 输入：s = "00111"
 * 输出：5
 * 解释：当 左子字符串 = "00" 且 右子字符串 = "111" 时，我们得到最大得分 = 2 + 3 = 5
 *
 * @author weijiaduo
 * @since 2022/8/14
 */
public class MaxScore implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        String s = "011101";
        int result = maxScore(s);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：用滑动窗口，直接增加左边区间和减少右边区间，统计0和1的数量
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了94.26% 的Java用户
     * 内存消耗:39.3 MB,击败了77.70% 的Java用户
     *
     * @param s 01字符串
     * @return 最大得分
     */
    private int maxScore(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        int leftZero = s.charAt(0) == '0' ? 1 : 0;
        int rightOne = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '1') {
                rightOne++;
            }
        }

        int max = leftZero + rightOne;
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == '1') {
                rightOne--;
            } else {
                leftZero++;
            }
            max = Math.max(leftZero + rightOne, max);
        }
        return max;
    }

}
