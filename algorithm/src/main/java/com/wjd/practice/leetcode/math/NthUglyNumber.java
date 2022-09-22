package com.wjd.practice.leetcode.math;

import com.wjd.practice.Solution;

/**
 * 264. 丑数2
 * <p>
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * <p>
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 * <p>
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 *
 * @author weijiaduo
 * @since 2022/9/22
 */
public class NthUglyNumber implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int n = 1;
        int result = nthUglyNumber(n);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：3指针，分别指向2、3、5的倍数，下一个丑数肯定是从这3个数里面出来的
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:2 ms,击败了97.22% 的Java用户
     * 内存消耗:40.9 MB,击败了36.82% 的Java用户
     */
    private int nthUglyNumber(int n) {
        int[] nums = new int[n];
        int p2 = 0, p3 = 0, p5 = 0;
        nums[0] = 1;
        for (int i = 1; i < n; ) {
            // 下一个丑数
            int next2 = nums[p2] * 2;
            int next3 = nums[p3] * 3;
            int next5 = nums[p5] * 5;
            int next = Math.min(next2, Math.min(next3, next5));

            // 不用 else 是为了去掉重复的数字
            if (next == next2) {
                p2++;
            }
            if (next == next3) {
                p3++;
            }
            if (next == next5) {
                p5++;
            }

            nums[i++] = next;
        }
        return nums[n - 1];
    }

}
