package com.wjd.practice.leetcode.math;

import com.wjd.practice.TestCase;

/**
 * 172. 阶乘后的零
 * <p>
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * <p>
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 10⁴
 * <p>
 * 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？
 *
 * @author weijiaduo
 * @since 2022/7/9
 */
public class TrailingZeroes {

    /**
     * 思路：暴力法，统计每个数字里面5的数量，就是最终值末尾0的数量
     * <p>
     * 复杂度：时间 O(nk) 空间 O(1)
     * <p>
     * 执行耗时:8 ms,击败了6.50% 的Java用户
     * 内存消耗:38.3 MB,击败了85.86% 的Java用户
     */
    @TestCase(input = {"3", "5", "0"},
            output = {"0", "1", "0"})
    public int brute(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += countFive(i);
        }
        return ans;
    }

    private int countFive(int n) {
        int num = 0;
        while (n % 5 == 0) {
            num++;
            n /= 5;
        }
        return num;
    }

    /**
     * 思路：统计5、5*5、5*5*5...等多种形式的数量
     * <p>
     * 复杂度：时间 O(klogn) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了31.04% 的Java用户
     * 内存消耗:38.3 MB,击败了88.08% 的Java用户
     */
    @TestCase(input = {"3", "5", "0"},
            output = {"0", "1", "0"})
    public int line(int n) {
        int ans = 0;
        int e = 1, count = 0;
        while (true) {
            count++;
            e *= 5;
            if (e > n) {
                break;
            }
            int size = n / e;
            for (int i = 1; i <= size; i++) {
                // 避免5的数量变多
                if (i % 5 == 0) {
                    continue;
                }
                ans += count;
            }
        }
        return ans;
    }

    /**
     * 官解：也是统计5、5*5、5*5*5...等多种形式的数量，但是用一种比较巧妙的方式计算
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.2 MB,击败了91.09% 的Java用户
     */
    @TestCase(input = {"3", "5", "0"},
            output = {"0", "1", "0"})
    public int log(int n) {
        int ans = 0;
        while (n != 0) {
            // 第一次除5，表示单个5的数量
            // 第二次除5，表示5*5的数量
            // 以此类推
            n /= 5;
            ans += n;
        }
        return ans;
    }

}
