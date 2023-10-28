package com.wjd.practice.leetcode.backtrack;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码得字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * @since 2022/5/13
 */
public class LetterCombinations {

    final char[][] characters = {
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    /**
     * 思路：回溯法的递归实现
     * <p>
     * 复杂度：时间 O(3^n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.3 MB,击败了30.04% 的Java用户
     */
    @TestCase(input = {"23", "2"},
            output = {"[\"ad\",\"ae\",\"af\",\"bd\",\"be\",\"bf\",\"cd\",\"ce\",\"cf\"]", "[\"a\",\"b\",\"c\"]"})
    public List<String> backtrack(String digits) {
        List<String> ans = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), ans);
        return ans;
    }

    private void backtrack(String digits, int i, StringBuilder sb, List<String> ans) {
        if (i == digits.length()) {
            if (sb.length() > 0) {
                ans.add(sb.toString());
            }
            return;
        }
        char[] ds = characters[digits.charAt(i) - '0' - 1];
        for (char c : ds) {
            sb.append(c);
            backtrack(digits, i + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /**
     * 思路：回溯法的迭代实现
     * <p>
     * 复杂度：时间 O(3^n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40 MB,击败了76.97% 的Java用户
     */
    @TestCase(input = {"23", "2"},
            output = {"[\"ad\",\"ae\",\"af\",\"bd\",\"be\",\"bf\",\"cd\",\"ce\",\"cf\"]", "[\"a\",\"b\",\"c\"]"})
    public List<String> iterate(String digits) {
        List<String> combinations = new ArrayList<>();
        int n = digits.length();
        if (n == 0) {
            return combinations;
        }

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = digits.charAt(i) - '0' - 1;
        }

        int[] count = new int[n];
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k >= 0; ) {
            int num = numbers[k];
            // 遍历完一个数字对应的所有字母
            if (count[k] >= characters[num].length) {
                // 遍历结束
                if (k == 0) {
                    break;
                }
                // 回到上一个数字
                count[k] = 0;
                sb.deleteCharAt(sb.length() - 1);
                // 遍历下一个字母
                count[--k]++;
                continue;
            }

            sb.append(characters[num][count[k]]);
            if (k < n - 1) {
                // 下一个数字
                k++;
            } else {
                // 最后一个数字
                combinations.add(sb.toString());
                sb.deleteCharAt(sb.length() - 1);
                count[k]++;
            }
        }
        return combinations;
    }

}
