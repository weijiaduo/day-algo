package com.wjd.practice.leetcode.string;

import com.wjd.practice.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 2022/5/13
 * 17. 电话号码得字母组合
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 输入：digits = "23"
 * <p>
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class LetterCombinations implements Solution<List<String>> {

    @Override
    public List<String> solve(Object ...args) {
        String digits = "23";
        List<String> result = letterCombinations(digits);
        System.out.println(result);
        return result;
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }

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

        int[] numbers = new int[digits.length()];
        int[] count = new int[digits.length()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = digits.charAt(i) - '0' - 1;
            count[i] = 0;
        }

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
            if (k < count.length - 1) {
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
