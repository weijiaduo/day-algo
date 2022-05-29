package com.wjd.algorithm.practice.leetcode.string;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * 38. 外观数组
 * <p>
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 * <p>
 * @since 2022/5/22
 */
public class CountAndSay implements Solution<String> {

    @Override
    public String solve(Object ...args) {
        int n = 5;
        String result = countAndSay(n);
        System.out.println(result);
        return result;
    }

    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = count(s);
            System.out.println(s);
        }
        return s;
    }

    /**
     * 暴力法
     *
     * 执行耗时:4 ms,击败了61.79% 的Java用户
     * 内存消耗:38.8 MB,击败了90.75% 的Java用户
     */
    private String count(String s) {
        char ch = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0) {
                ch = c;
            }
            if (c == ch) {
                count++;
            }
            if (c != ch) {
                sb.append(count).append(ch);
                ch = c;
                count = 1;
            }
            if (i == s.length() - 1) {
                sb.append(count).append(ch);
            }
        }
        return sb.toString();
    }
}
