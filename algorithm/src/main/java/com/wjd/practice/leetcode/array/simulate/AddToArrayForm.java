package com.wjd.practice.leetcode.array.simulate;

import java.util.ArrayList;
import java.util.List;

/**
 * 989. 数组形式的整数加法
 * <p>
 * 对于非负整数X而言，X的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果X = 1231，那么其数组形式为[1,2,3,1]。
 * <p>
 * 给定非负整数 X 的数组形式A，返回整数X+K的数组形式。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = [1,2,0,0], k = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 *
 * @since 2021-05-29
 */
public class AddToArrayForm {

    /**
     * 思路：直接模拟即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(m)
     * <p>
     * 执行耗时:2 ms,击败了98.51% 的Java用户
     * 内存消耗:43.9 MB,击败了10.74% 的Java用户
     *
     * @param num 数组整数
     * @param k   加数
     * @return 和
     */
    public List<Integer> addToArrayForm(int[] num, int k) {
        int[] num2 = transferToArray(k);
        int[] sums = add(num, num2);
        List<Integer> result = new ArrayList<>(sums.length);
        for (int n : sums) {
            result.add(n);
        }
        return result;
    }

    /**
     * 整数转数组
     *
     * @param k 整数
     * @return 数组
     */
    private int[] transferToArray(int k) {
        int length = 0;
        int temp = k;
        while (temp > 0) {
            temp /= 10;
            length++;
        }
        int[] num = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            num[i] = k % 10;
            k /= 10;
        }
        return num;
    }

    /**
     * 数组整数相加
     *
     * @param num1 数组1
     * @param num2 数组2
     * @return 和
     */
    private int[] add(int[] num1, int[] num2) {
        int c = 0;
        int length = Math.max(num1.length, num2.length);
        int[] sums = new int[length];
        for (int i = 1; i <= length; i++) {
            int sum = c;
            if (i <= num1.length) {
                sum += num1[num1.length - i];
            }
            if (i <= num2.length) {
                sum += num2[num2.length - i];
            }
            sums[length - i] = sum % 10;
            c = sum / 10;
        }
        if (c > 0) {
            int[] oldSum = sums;
            sums = new int[oldSum.length + 1];
            System.arraycopy(oldSum, 0, sums, 1, sums.length - 1);
            sums[0] = c;
        }
        return sums;
    }
}
