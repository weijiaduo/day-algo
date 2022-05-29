package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;
import com.wjd.util.ArrayUtil;

/**
 * @since 2021-05-29
 *
 * 66. 加一
 * <p>
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class PlusOne implements Solution<int[]> {

    @Override
    public int[] solve(Object ...args) {
        int[] digits = {9};
        int[] result = plusOne(digits);
        ArrayUtil.print(result);
        return result;
    }

    /**
     * 大数加一
     *
     * @param digits 大数数组
     * @return 返回值
     */
    private int[] plusOne(int[] digits) {
        int c = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + c;
            digits[i] = sum % 10;
            c = sum / 10;
            if (c == 0) {
                break;
            }
        }
        if (c > 0) {
            int[] oldDigits = digits;
            digits = new int[oldDigits.length + 1];
            System.arraycopy(oldDigits, 0, digits, 1, digits.length - 1);
            digits[0] = c;
        }
        return digits;
    }
}
