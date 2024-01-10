package com.wjd.practice.book.cracking.string;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 16.08. 整数的英语表示
 * <p>
 * 给定一个整数，打印该整数的英文描述。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: "One Hundred Twenty Three"
 * <p>
 * 示例 2:
 * <p>
 * 输入: 12345
 * 输出: "Twelve Thousand Three Hundred Forty Five"
 * <p>
 * 示例 3:
 * <p>
 * 输入: 1234567
 * 输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * <p>
 * 示例 4:
 * <p>
 * 输入: 1234567891
 * 输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 *
 * @author weijiaduo
 * @since 2024/1/10
 */
public class NumberToWords {

    static String[][] words = new String[][]{
            {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                    "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"},
            {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"},
            {"", "Thousand", "Million", "Billion"}
    };

    /**
     * 思路：3 位一个表示
     * <p>
     * 将数字拆分成一个个 3 位数，然后将 3 位数转成英语
     * <p>
     * 两个 3 位数之间再加上进阶单位即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:2 ms,击败了82.00% 的Java用户
     * 内存消耗:40.7 MB,击败了28.00% 的Java用户
     */
    @TestCase(input = {"123",
            "12345",
            "1234567",
            "1234567891",
            "1000",
            "1000000"},
            output = {"One Hundred Twenty Three",
                    "Twelve Thousand Three Hundred Forty Five",
                    "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven",
                    "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One",
                    "One Thousand",
                    "One Million"})
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        if (num < 0) {
            return "Negative " + convert(-num);
        } else {
            return convert(num);
        }
    }

    /**
     * 转换数字成英语
     *
     * @param num 数字
     * @return 英语字符串
     */
    private String convert(int num) {
        List<String> list = new ArrayList<>();
        while (num > 0) {
            list.add(toStr(num % 1000));
            num /= 1000;
        }
        StringBuilder sb = new StringBuilder();
        int n = list.size();
        for (int i = n - 1; i >= 0; i--) {
            String s = list.get(i);
            if (s.isEmpty()) {
                continue;
            }
            if (!sb.isEmpty()) {
                sb.append(" ");
            }
            sb.append(s);
            if (!words[2][i].isEmpty()) {
                sb.append(" ").append(words[2][i]);
            }
        }
        return sb.toString();
    }

    /**
     * 转换数字成英语
     *
     * @param num 小于 1000 的数字
     * @return 英语字符串
     */
    private String toStr(int num) {
        if (num == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(" ");
        // 百位
        if (num >= 100) {
            int h = num / 100;
            sb.append(words[0][h]).append(" Hundred ");
            num %= 100;
        }
        // 十位
        if (num >= 20) {
            int t = num / 10;
            sb.append(words[1][t]).append(" ");
            num %= 10;
        }
        // 个位
        if (num > 0) {
            sb.append(words[0][num]).append(" ");
        }
        return sb.substring(1, sb.length() - 1);
    }

}
