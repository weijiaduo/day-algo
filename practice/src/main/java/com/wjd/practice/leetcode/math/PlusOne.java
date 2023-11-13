package com.wjd.practice.leetcode.math;

import com.wjd.practice.TestCase;

/**
 * 66. 加一
 * <p>
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * 示例 2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * <p>
 * 示例 3：
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 * <p>
 * 提示：
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * @author weijiaduo
 * @since 2023/11/13
 */
public class PlusOne {

    /**
     * 思路：直接模拟即可，看有没有进位
     * <p>
     * 如果没有进位，直接返回当前数组；
     * <p>
     * 如果有进位，继续计算下一位的结果，直到最后
     * <p>
     * 如果最后还有进位，需要新建一个数组保存
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.9 MB,击败了48.52% 的Java用户
     */
    @TestCase(input = {"[1,2,3]", "[4,3,2,1]", "[0]"},
            output = {"[1,2,4]", "[4,3,2,2]", "[1]"})
    public int[] plus(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }

        // 进位溢出原数组长度
        int[] tmp = new int[n + 1];
        tmp[0] = 1;
        // 可以不用复制，因为所有位肯定都是 0
        // System.arraycopy(digits, 0, tmp, 1, n);
        return tmp;
    }

}
