package com.wjd.practice.leetcode.math;

import com.wjd.practice.leetcode.Solution;

import java.util.Arrays;

/**
 * 556. 下一个更大元素
 * <p>
 * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
 * <p>
 * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 * <p>
 * 输入：n = 12
 * 输出：21
 *
 * @author weijiaduo
 * @since 2022/7/3
 */
public class NextGreaterElement implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int n = 21;
        int result = nextGreaterElement2(n);
        System.out.println(result);
        return result;
    }

    /**
     * 细节真的多，错了好多次
     * <p>
     * 思路：从后往前找，找到最小的正序对，调换位置
     * <p>
     * 执行耗时:1 ms,击败了21.58% 的Java用户
     * 内存消耗:38.6 MB,击败了6.77% 的Java用户
     */
    private int nextGreaterElement(int n) {
        int len = String.valueOf(n).length();
        int[] numbers = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            numbers[i] = n % 10;
            n /= 10;
        }

        for (int i = len - 2; i >= 0; i--) {
            int number = numbers[i];
            if (numbers[i] < numbers[len - 1]) {
                // 和第一个比当前值大的值替换
                int j = i + 1;
                while (j < len && number >= numbers[j]) {
                    j++;
                }
                numbers[i] = numbers[j];
                numbers[j] = number;
                System.out.println(Arrays.toString(numbers));

                // 重新计算新值
                long num = 0;
                for (int k = 0; k < len; k++) {
                    num = num * 10 + numbers[k];
                    if (num > Integer.MAX_VALUE) {
                        return -1;
                    }
                }
                return (int) num;
            } else {
                // 插入最后一个位置，从小到大排序，[len-1]始终是当前遍历的最大值
                for (int j = i; j < len - 1; j++) {
                    numbers[j] = numbers[j + 1];
                }
                numbers[len - 1] = number;
            }
        }
        return -1;
    }

    /**
     * 官解和我想的效果差不多，但是代码写得就简洁多了
     * <p>
     * 思路：也是找到第一个正序对，交换位置，并把后面的排序弄成升序
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.5 MB,击败了15.76% 的Java用户
     */
    private int nextGreaterElement2(int n) {
        char[] numbers = String.valueOf(n).toCharArray();
        int len = numbers.length;

        // 找到第一个比后面小的值
        int i = len - 2;
        while (i >= 0 && numbers[i] >= numbers[i + 1]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }

        // 和第一个比当前值大的值交换
        char number = numbers[i];
        int j = len - 1;
        while (j > i && numbers[j] <= number) {
            j--;
        }
        numbers[i] = numbers[j];
        numbers[j] = number;

        // 把降序交换成升序
        j = len - 1;
        i = i + 1;
        while (i < j) {
            char temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
            i++;
            j--;
        }

        // 转换为数字
        long num = Long.parseLong(new String(numbers));
        if (num > Integer.MAX_VALUE) {
            return -1;
        } else {
            return (int) num;
        }
    }

}
