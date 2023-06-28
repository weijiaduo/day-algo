package com.wjd.practice.leetcode.string.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. 文本左右对齐
 * <p>
 * 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * <p>
 * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * <p>
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * <p>
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 输入: words = ["This", "is", "an", "example", "of", "text", "justification."],
 * maxWidth = 16
 * 输出:
 * <p>
 * "This  is  an",
 * "example of text",
 * "justification. "
 * <p>
 *
 * @since 2022/6/2
 */
public class FullJustify {

    /**
     * 暴力法
     * <p>
     * 思路：遍历的同时计算当前拼接的长度，足够长了就做成一行
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.5 MB,击败了76.30% 的Java用户
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int width = 0;
        for (int i = 0, j = 0; i < words.length; i++) {
            if (width + words[i].length() > maxWidth) {
                int wordNum = i - j;
                int allSpace = maxWidth - width + wordNum;
                int avgSpace = 0, remainSpace = 0;
                if (wordNum > 1) {
                    // 平均分配到每个空隙的空格数量
                    avgSpace = allSpace / (wordNum - 1);
                    // 没有完全平均，还多出一些空格
                    remainSpace = allSpace % (wordNum - 1);
                }
                ans.add(buildStr(words, j, i - 1, avgSpace, remainSpace, maxWidth));
                j = i;
                width = 0;
            }

            // 在每个单词后面加上1个空格
            width += words[i].length() + 1;

            // 最后一行不是两边对齐，而是左对齐
            if (i == words.length - 1) {
                ans.add(buildStr(words, j, i, 1, 0, maxWidth));
            }
        }
        return ans;
    }

    public String buildStr(String[] words, int from, int to, int average, int remain, int maxLength) {
        StringBuilder sb = new StringBuilder();
        for (int i = from; i < to; i++) {
            sb.append(words[i]);
            for (int j = 0; j < average; j++) {
                sb.append(' ');
            }
            if (remain-- > 0) {
                sb.append(' ');
            }
        }
        sb.append(words[to]);
        while (sb.length() < maxLength) {
            sb.append(' ');
        }
        return sb.toString();
    }

}
