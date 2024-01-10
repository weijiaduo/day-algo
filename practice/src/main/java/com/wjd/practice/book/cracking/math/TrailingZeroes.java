package com.wjd.practice.book.cracking.math;

import com.wjd.practice.TestCase;

/**
 * 面试题 16.05. 阶乘尾数
 * <p>
 * 设计一个算法，算出 n 阶乘有多少个尾随零。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: 0
 * 解释:3! = 6, 尾数中没有零。
 * <p>
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: 1
 * 解释:5! = 120, 尾数中有 1 个零.
 * <p>
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * @author weijiaduo
 * @since 2024/1/10
 */
public class TrailingZeroes {

    /**
     * 思路：计数，尾数为 0 只能由 2*5 得到
     * <p>
     * 所以 0 的个数取决于 [1,n] 之中，2 和 5 的数量
     * <p>
     * 而 5 的数量肯定比 2 的数量要少，所以只要计算 5 的数量即可
     * <p>
     * 可以分别计算 5、5*5、5*5*5 的数量有多少个
     * <p>
     * 一个 5 的出现次数 n/5
     * <p>
     * 两个 5 的出现次数 n/5/5
     * <p>
     * 三个 5 的出现次数 n/5/5/5
     * <p>
     * 依次类推，其中一个 5 里面还包含了两个 5 的情况
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.5 MB,击败了12.08% 的Java用户
     */
    @TestCase(input = {"3", "5"},
            output = {"0", "1"})
    public int trailingZeroes(int n) {
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
