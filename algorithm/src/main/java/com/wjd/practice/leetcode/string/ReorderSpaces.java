package com.wjd.practice.leetcode.string;

import com.wjd.practice.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 1592. 重新排列单词间的空格
 * <p>
 * 给你一个字符串 text ，该字符串由若干被空格包围的单词组成。
 * <p>
 * 每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。
 * <p>
 * 题目测试用例保证text 至少包含一个单词 。
 * <p>
 * 请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。
 * <p>
 * 如果不能重新平均分配所有空格，请 将多余的空格放置在字符串末尾 ，这也意味着返回的字符串应当与原 text 字符串的长度相等。
 * <p>
 * 返回重新排列空格后的字符串 。
 * <p>
 * 输入：text = "  this   is  a sentence "
 * 输出："this   is   a   sentence"
 * 解释：总共有 9 个空格和 4 个单词。可以将 9 个空格平均分配到相邻单词之间，相邻单词间空格数为：9 / (4-1) = 3 个。
 *
 * @author weijiaduo
 * @since 2022/9/7
 */
public class ReorderSpaces implements Solution<String> {

    @Override
    public String solve(Object... args) {
        String text = "  sentence ";
        String result = reorderSpaces(text);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：统计空格数量和单词数量，直接计算
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.5 MB,击败了70.70% 的Java用户
     */
    private String reorderSpaces(String text) {
        int n = text.length();
        int spaces = n;
        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                continue;
            }

            // 解析单词
            int j = i + 1;
            while (j < n && text.charAt(j) != ' ') {
                j++;
            }
            words.add(text.substring(i, j));

            // 空格数量减去单词长度
            spaces -= j - i;
            i = j - 1;
        }

        // 重新拼接字符串
        int size = words.size();
        int avgSpaces = 0;
        int remainSpaces = spaces;
        if (size > 1) {
            avgSpaces = spaces / (size - 1);
            remainSpaces = spaces % (size - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                for (int j = 0; j < avgSpaces; j++) {
                    sb.append(' ');
                }
            }
            sb.append(words.get(i));
        }
        for (int i = 0; i < remainSpaces; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }

}
