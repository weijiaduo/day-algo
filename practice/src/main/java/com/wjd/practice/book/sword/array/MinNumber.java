package com.wjd.practice.book.sword.array;

import com.wjd.practice.TestCase;

import java.util.Arrays;

/**
 * 45. 把数组排成最小的数
 * <p>
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * @author weijiaduo
 * @since 2023/11/28
 */
public class MinNumber {

    /**
     * 思路：排序，将整数数组转换成字符串数组，然后按照字典序排序
     * <p>
     * 比较两个字符串 s1 和 s2 的大小时，先将它们拼接起来，比较 s1+s2 和 s2+s1 的大小，看谁更小
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     */
    @TestCase(input = {"[1, 6, 5, 4]", "[1, 3, 2, 4, 6]"},
            output = {"1456", "12346"})
    public String minNumber(int[] numbers) {
        if (numbers == null) {
            return null;
        }

        // 将整数数组转换成字符串数组
        int n = numbers.length;
        String[] numStr = new String[n];
        for (int i = 0; i < n; i++) {
            numStr[i] = Integer.toString(numbers[i]);
        }

        // 按照字典序排序
        Arrays.sort(numStr, (String o1, String o2) -> (o1 + o2).compareTo((o2 + o1)));

        // 拼接所有字符串
        StringBuilder sb = new StringBuilder();
        for (String s : numStr) {
            sb.append(s);
        }
        return sb.toString();
    }

}
