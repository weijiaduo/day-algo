package com.wjd.practice.leetcode.string.combination;

import com.wjd.practice.leetcode.TestCase;

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
 * 注意:
 * <p>
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: words = ["This", "is", "an", "example", "of", "text", "justification."],
 * maxWidth = 16
 * 输出:
 * [
 * "This  is  an",
 * "example of text",
 * "justification. "
 * ]
 * <p>
 * 示例 2:
 * <p>
 * 输入:words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * 输出:
 * [
 * "What  must  be",
 * "acknowledgment ",
 * "shall be    "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 * 因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 * <p>
 * 示例 3:
 * <p>
 * 输入:words = ["Science","is","what","we","understand","well","enough","to",
 * "explain","to","a","computer.","Art","is","everything","else","we","do"]，maxWidth = 2
 * 0
 * 输出:
 * [
 * "Science is what we",
 * "understand   well",
 * "enough to explain to",
 * "a computer. Art is",
 * "everything else we",
 * "do         "
 * ]
 * <p>
 * 提示:
 * <p>
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] 由小写英文字母和符号组成
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 *
 * @since 2022/6/2
 */
public class FullJustify {

    /**
     * 思路：直接模拟，遍历的同时计算当前拼接的长度，足够长了就做成一行
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.5 MB,击败了76.30% 的Java用户
     */
    @TestCase(input = {"[\"This\", \"is\", \"an\", \"example\", \"of\", \"text\", \"justification.\"]", "16",
            "[\"What\",\"must\",\"be\",\"acknowledgment\",\"shall\",\"be\"]", "16",
            "[\"Science\",\"is\",\"what\",\"we\",\"understand\",\"well\",\"enough\",\"to\",\"explain\",\"to\",\"a\",\"computer.\",\"Art\",\"is\",\"everything\",\"else\",\"we\",\"do\"]", "20"},
            output = {"[\"This    is    an\",\"example  of text\",\"justification.  \"]",
                    "[\"What   must   be\",\"acknowledgment  \",\"shall be        \"]",
                    "[\"Science  is  what we\",\"understand      well\",\"enough to explain to\",\"a  computer.  Art is\",\"everything  else  we\",\"do                  \"]"})
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int n = words.length, width = 0;
        for (int i = 0, j = 0; i < n; i++) {
            if (width + words[i].length() > maxWidth) {
                // 凑够一行单词了
                int count = i - j;
                int allSpace = maxWidth - width + count;
                int avgSpace = 0, remainSpace = 0;
                if (count > 1) {
                    // 平均分配到每个空隙的空格数量
                    avgSpace = allSpace / (count - 1);
                    // 没有完全平均，还多出一些空格
                    remainSpace = allSpace % (count - 1);
                }
                ans.add(buildStr(words, j, i - 1, avgSpace, remainSpace, maxWidth));

                // 下一行
                j = i;
                width = 0;
            }

            // 在每个单词后面加上1个空格
            width += words[i].length() + 1;

            // 最后一行不是两边对齐，而是左对齐
            if (i == n - 1) {
                ans.add(buildStr(words, j, i, 1, 0, maxWidth));
            }
        }
        return ans;
    }

    /**
     * 构建两端对齐的字符串
     *
     * @param words     单词数组
     * @param from      [from, to]
     * @param to        [from, to]
     * @param average   平均空格
     * @param remain    多余空格
     * @param maxLength 字符串长度
     * @return 两端对齐的字符串
     */
    private String buildStr(String[] words, int from, int to, int average, int remain, int maxLength) {
        StringBuilder sb = new StringBuilder();
        for (int i = from; i < to; i++) {
            sb.append(words[i]);
            sb.append(" ".repeat(average));
            // 多余空格优先给前面的
            if (remain > 0) {
                sb.append(' ');
                remain--;
            }
        }
        sb.append(words[to]);
        while (sb.length() < maxLength) {
            sb.append(' ');
        }
        return sb.toString();
    }

}
