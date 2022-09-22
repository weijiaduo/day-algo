package com.wjd.practice.leetcode.math;

import com.wjd.practice.Solution;

/**
 * 263. 丑数
 * <p>
 * 丑数 就是只包含质因数 2、3 和 5 的正整数。
 * <p>
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 *
 * @author weijiaduo
 * @since 2022/9/22
 */
public class IsUgly implements Solution<Boolean> {

    @Override
    public Boolean solve(Object... args) {
        int n = 14;
        boolean result = isUgly(n);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：除法，一直用2/3/5除n，如果最后n等于1，则是丑数，反正不是
     * <p>
     * 复杂度：不好计算
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.9 MB,击败了27.38% 的Java用户
     */
    private boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else if (n % 3 == 0) {
                n /= 3;
            } else if (n % 5 == 0) {
                n /= 5;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 官解：代码确实简洁，不过性能差很多
     * <p>
     * 执行耗时:1 ms,击败了23.51% 的Java用户
     * 内存消耗:38.7 MB,击败了57.98% 的Java用户
     */
    private boolean isUgly2(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factory : factors) {
            while (n % factory == 0) {
                n /= factory;
            }
        }
        return n == 1;
    }

}
