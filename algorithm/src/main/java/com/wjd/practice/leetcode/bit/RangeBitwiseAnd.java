package com.wjd.practice.leetcode.bit;

import com.wjd.practice.Solution;

/**
 * 201. 数字范围按位与
 * <p>
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，
 * <p>
 * 返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 *
 * @author weijiaduo
 * @since 2022/7/16
 */
public class RangeBitwiseAnd implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int left = 1;
        int right = 3;
        int result = rangeBitwiseAnd(left, right);
        System.out.println(result);
        return result;
    }

    /**
     * 这官解，这么简单
     * <p>
     * 官解：假设 left=SSS0XXX,right=SSS1YYY，公共前缀是 SSS，不同部分是从这个前缀之后开始的。
     * 由于 left 到 right 的值是连续的，所以不论如何，必然会存在2个数 SSS0111 和 SSS1000
     * 而这2个数的按位与结果就是 SSS0111&SSS1000=SSS0000，所以[left, right]区间内所有数字
     * 的按位与结果，实际就是 left 和 right 的位公共前缀
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     *
     * @param left  最小值
     * @param right 最大值
     * @return 按位与结果
     */
    private int rangeBitwiseAnd(int left, int right) {
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
     * 官解：思路是一样的，求公共前缀，只是换种实现方式
     * 每次去掉 max 最右边的1，直到 max 小于 min 时，剩下的 max 就是公共前缀了
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     *
     * @param left  最小值
     * @param right 最大值
     * @return 按位与结果
     */
    public int rangeBitwiseAnd2(int left, int right) {
        int m = left, n = right;
        while (n > m) {
            // 抹去最右边的1
            n = n & (n - 1);
        }
        return n;
    }

}
