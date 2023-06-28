package com.wjd.practice.leetcode.math;

/**
 * 2485. 找出中枢整数
 * <p>
 * 给你一个正整数 n ，找出满足下述条件的 中枢整数 x ：
 * <p>
 * 1 和 x 之间的所有元素之和等于 x 和 n 之间所有元素之和。
 * <p>
 * 返回中枢整数 x 。如果不存在中枢整数，则返回 -1 。题目保证对于给定的输入，至多存在一个中枢整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 8
 * 输出：6
 * 解释：6 是中枢整数，因为 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * 解释：1 是中枢整数，因为 1 = 1 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：-1
 * 解释：可以证明不存在满足题目要求的整数。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 *
 * @author weijiaduo
 * @since 2023/6/26
 */
public class PivotInteger {

    public int pivotInteger(int n) {
        // return slide(n);
        return math(n);
    }

    /**
     * 思路：滑动窗口，左右2个窗口，对比它们的值
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了47.40%的用户
     */
    private int slide(int n) {
        int left = 1, right = (n + 1) * n / 2;
        for (int x = 1; x <= n; x++) {
            if (left == right) {
                return x;
            }
            left += x + 1;
            right -= x;
        }
        return -1;
    }

    /**
     * 官方题解
     * <p>
     * 思路：数学计算，根据左右两边的等式计算出结果
     * <p>
     * 复杂度：时间 O(1) 空间 O(1)
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.2 MB, 在所有 Java 提交中击败了92.66%的用户
     */
    private int math(int n) {
        int t = (n * n + n) / 2;
        int x = (int) Math.sqrt(t);
        if (x * x == t) {
            return x;
        }
        return -1;
    }

}
