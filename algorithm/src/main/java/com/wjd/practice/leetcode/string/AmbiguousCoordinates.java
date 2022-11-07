package com.wjd.practice.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 816. 模糊坐标
 * <p>
 * 我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。
 * <p>
 * 返回所有可能的原始字符串到一个列表中。
 * <p>
 * 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表示坐标。
 * <p>
 * 此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。
 * <p>
 * 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。
 * <p>
 * 输入: "(123)"
 * 输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 *
 * @author weijiaduo
 * @since 2022/11/7
 */
public class AmbiguousCoordinates {

    /**
     * 思路：按照逗号（,）分割成2条子串，分别统计2条子串的数值情况，最后叉乘
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 执行耗时:7 ms,击败了84.40% 的Java用户
     * 内存消耗:42.6 MB,击败了26.95% 的Java用户
     */
    public List<String> solve(String s) {
        List<String> ans = new ArrayList<>();
        String nums = s.substring(1, s.length() - 1);
        int n = nums.length();
        for (int i = 1; i < n; i++) {
            List<String> xs = getNumbers(nums.substring(0, i));
            if (xs.isEmpty()) {
                continue;
            }
            List<String> ys = getNumbers(nums.substring(i));
            if (ys.isEmpty()) {
                continue;
            }
            for (String x : xs) {
                for (String y : ys) {
                    ans.add("(" + x + ", " + y + ")");
                }
            }
        }
        return ans;
    }

    /**
     * 字符串作为数值的情况
     *
     * @param s 字符串
     * @return 不同数值
     */
    private List<String> getNumbers(String s) {
        List<String> numbers = new ArrayList<>();
        // 整数的情况
        int n = s.length();
        // 0 值或开头不为 0
        if (n == 1 || s.charAt(0) != '0') {
            numbers.add(s);
        }
        // 小数的情况
        // 小数点前必须有数字，且小数末尾不能是 0
        if (n > 1 && s.charAt(n - 1) != '0') {
            if (s.charAt(0) == '0') {
                // 0 开头的话，只有 1 种情况
                numbers.add("0." + s.substring(1));
            } else {
                for (int i = 1; i < n; i++) {
                    numbers.add(s.substring(0, i) + "." + s.substring(i));
                }
            }
        }
        return numbers;
    }

}
