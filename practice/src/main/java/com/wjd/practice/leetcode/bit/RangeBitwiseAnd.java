package com.wjd.practice.leetcode.bit;

import com.wjd.practice.TestCase;

/**
 * 201. 数字范围按位与
 * <p>
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：left = 5, right = 7
 * 输出：4
 * <p>
 * 示例 2：
 * <p>
 * 输入：left = 0, right = 0
 * 输出：0
 * <p>
 * 示例 3：
 * <p>
 * 输入：left = 1, right = 2147483647
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 0 <= left <= right <= 2³¹ - 1
 *
 * @author weijiaduo
 * @since 2022/7/16
 */
public class RangeBitwiseAnd {

    /**
     * 这官解，这么简单
     * <p>
     * 思路：假设 left=SSS0XXX,right=SSS1YYY，公共前缀是 SSS，不同部分是从这个前缀之后开始的。
     * <p>
     * 由于 left 到 right 的值是连续的，所以不论如何，必然会存在2个数 SSS0111 和 SSS1000
     * <p>
     * 而这2个数的按位与结果就是 SSS0111&SSS1000=SSS0000，所以[left, right]区间内所有数字
     * <p>
     * 的按位与结果，实际就是 left 和 right 的位公共前缀
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"5", "7", "0", "0", "1", "2147483647"},
            output = {"4", "0", "0"})
    public int rangeBitwiseAnd(int left, int right) {
        int m = left, n = right;
        int shift = 0;
        // 找到公共前缀
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }

    /**
     * 思路：思路是一样的，求公共前缀，只是换种实现方式
     * <p>
     * 每次去掉 max 最右边的1，直到 max 小于 min 时，剩下的 max 就是公共前缀了
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"5", "7", "0", "0", "1", "2147483647"},
            output = {"4", "0", "0"})
    public int rangeBitwiseAnd2(int left, int right) {
        int m = left, n = right;
        while (n > m) {
            // 抹去最右边的1
            n = n & (n - 1);
        }
        return n;
    }

}
