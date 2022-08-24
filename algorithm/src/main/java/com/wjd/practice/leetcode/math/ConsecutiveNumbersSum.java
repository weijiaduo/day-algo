package com.wjd.practice.leetcode.math;

import com.wjd.practice.Solution;

/**
 * 829. 连续整数求和
 * <p>
 * 给定一个正整数 n，返回 连续正整数满足所有数字之和为 n 的组数 。
 * <p>
 * 输入: n = 5
 * 输出: 2
 * 解释: 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。
 * <p>
 * @since 2022/6/3
 */
public class ConsecutiveNumbersSum implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int n = 933320757;
        int result = consecutiveNUmberSum(n);
        System.out.println(result);
        return result;
    }

    public int consecutiveNUmberSum(int n) {
        return divide3(n);
    }

    /**
     * 滑动窗口法
     *
     * 思路：维护一个滑动窗口，一点点往最大值滑动
     *
     * Time Limit Exceeded
     * 测试用例:933320757
     */
    private int slideWindow(int n) {
        int ans = n > 2 ? 1 : 0;
        int sum = 0;
        for (int i = 1, j = 1; i <= n / 2 + 1;) {
            if (sum == n - i) {
                // 窗口往右滑动一个位置
                ans++;
                sum -= j++;
                sum += i++;
            } else if (sum > n - i) {
                // 左边往右缩减一个位置
                sum -= j++;
            } else {
                // 右边往右扩展一个位置
                sum += i++;
            }
        }
        return ans;
    }

    /**
     * 除法
     *
     * 思路：根据连续整数的数量，逐个遍历，从1个、2个、3个...这样遍历
     *
     * Time Limit Exceeded
     * 测试用例:933320757
     */
    private int divide(int n) {
        int ans = 0;
        int mid = (n + 1) / 2;
        for (int i = 1; i <= mid; i++) {
            int m = n / i;
            int r = i / 2;
            if (i % 2 == 0) {
                if (m - r + 1 >= 1 && m + r <= n) {
                    if ((m + m + 1) * r == n) {
                        ans++;
                    }
                }
            } else {
                if (m - r >= 1 && m + r <= n) {
                    if (m * i == n) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 除法
     *
     * 思路：根据连续整数的数量，逐个遍历，从1个、2个、3个...这样遍历
     *
     * Time Limit Exceeded
     * 测试用例:66704037
     */
    private int divide2(int n) {
        int ans = 0;
        int mid = (n + 1) / 2;
        for (int i = 1; i <= mid; i++) {
            int m = n / i;
            int c = n % i;
            int r = i / 2;
            if (i % 2 == 0) {
                if (c == r && m - r + 1 >= 1 && m + r <= n) {
                    ans++;
                }
            } else {
                if (c == 0 && m - r >= 1 && m + r <= n) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 除法
     *
     * 思路：根据连续整数的数量，逐个遍历，从1个、2个、3个...这样遍历
     *
     * 执行耗时:4 ms,击败了40.11% 的Java用户
     * 内存消耗:38.1 MB,击败了81.28% 的Java用户
     */
    private int divide3(int n) {
        int ans = 0;
        int end = n * 2;
        for (int i = 1; i * i <= end; i++) {
            int c = n % i;
            if (i % 2 == 0) {
                if (c == i / 2) {
                    ans++;
                }
            } else {
                if (c == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
