package com.wjd.practice.leetcode.string.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 828. 统计子串中的唯一字符
 * <p>
 * 我们定义了一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符，并返回唯一字符的个数。
 * <p>
 * 例如：s = "LEETCODE" ，则其中 "L", "T","C","O","D" 都是唯一字符，因为它们只出现一次，所以 countUniqueChars(s) = 5 。
 * <p>
 * 本题将会给你一个字符串 s ，我们需要返回 countUniqueChars(t) 的总和，其中 t 是 s 的子字符串。
 * <p>
 * 输入用例保证返回值为 32 位整数。
 * <p>
 * 注意，某些子字符串可能是重复的，但你统计时也必须算上这些重复的子字符串（也就是说，你必须统计 s 的所有子字符串中的唯一字符）。
 * <p>
 * 输入: s = "ABC"
 * 输出: 10
 * 解释: 所有可能的子串为："A","B","C","AB","BC" 和 "ABC"。
 * 其中，每一个子串都由独特字符构成。
 * 所以其长度总和为：1 + 1 + 1 + 2 + 2 + 3 = 10
 *
 * @author weijiaduo
 * @since 2022/9/6
 */
public class UniqueLetterString {

    /**
     * 思路：对于字符 c(i)，它上一次出现位置是 c(j)，下一次出现的位置是 c(k)。
     * <p>
     * 那么以 c(i) 为唯一字符的情况有 (c(i) - c(j)) * (c(k) - c(i)))。
     * <p>
     * c(i) - c(j) 表示以 (j, i] 为起点的情况。
     * <p>
     * c(k) - c(i) 表示以 [i, k) 为终点的情况。
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:34 ms,击败了53.57% 的Java用户
     * 内存消耗:49 MB,击败了26.79% 的Java用户
     */
    public int uniqueLetterString(String s) {
        // 记录每个字符出现的位置
        int n = s.length();
        Map<Character, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            List<Integer> list = pos.computeIfAbsent(ch, k -> new ArrayList<>());
            list.add(i);
        }

        // 统计唯一字符的情况
        int sum = 0;
        for (List<Integer> list : pos.values()) {
            int prev = -1;
            list.add(n);
            for (int i = 0; i < list.size() - 1; i++) {
                int index = list.get(i);
                sum += (index - prev) * (list.get(i + 1) - index);
                prev = index;
            }
        }
        return sum;
    }

}
