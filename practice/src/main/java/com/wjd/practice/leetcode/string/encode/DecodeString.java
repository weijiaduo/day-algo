package com.wjd.practice.leetcode.string.encode;

import com.wjd.practice.leetcode.TestCase;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 394. 字符串解码
 * <p>
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * <p>
 * 示例 4：
 * <p>
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 30
 * <p>
 * s 由小写英文字母、数字和方括号
 * '[]' 组成
 * s 保证是一个 有效 的输入。
 * s 中所有整数的取值范围为
 * [1, 300]
 *
 * @author weijiaduo
 * @since 2023/6/30
 */
public class DecodeString {

    @TestCase(input = {"3[a]2[bc]", "3[a2[c]]", "2[abc]3[cd]ef", "abc3[cd]xyz", "10[a]"},
            output = {"aaabcbc", "accaccacc", "abcabccdcdcdef", "abccdcdcdxyz", "aaaaaaaaaa"})
    private String dfs(String s) {
        return dfs(s, 0, s.length() - 1);
    }

    /**
     * 思路：栈+递归，利用栈找到 k[sub] 里面的 sub，然后再递归处理 sub
     * <p>
     * 比如，解析编码 3[a2[c]]
     * <p>
     * 第1轮是 3[a2[c]]，利用栈解析得到了内部编码 a2[c]，作为递归第2轮输入
     * <p>
     * 第2轮是 a2[c]，利用栈解析得到了内部编码 c，作为递归第3轮输入
     * <p>
     * 依此类推，就能得到最终的字符串
     * <p>
     * 复杂度：时间 O(n) 空间 O(k)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.4 MB,击败了85.73% 的Java用户
     */
    private String dfs(String s, int start, int end) {
        if (start > end) {
            return "";
        }
        // 重复编码，至少有 k[] 这3个字符
        if (end - start + 1 < 3) {
            return s.substring(start, end + 1);
        }

        StringBuilder sb = new StringBuilder();
        int l = start, r = l;
        while (l <= end) {
            // 非重复编码，直接追加
            int k = s.charAt(l) - '0';
            if (k < 0 || k > 9) {
                sb.append(s.charAt(l++));
                continue;
            }

            // 重复次数
            r = l + 1;
            while (r <= end && s.charAt(r) != '[') {
                k = k * 10 + (s.charAt(r++) - '0');
            }

            // 模拟栈来寻找匹配的括号
            l = r = r + 1;
            int cnt = 1;
            while (r <= end && cnt > 0) {
                char ch = s.charAt(r++);
                if (ch == '[') {
                    cnt++;
                } else if (ch == ']') {
                    cnt--;
                }
            }
            // 取出 k[sub] 里面的 sub，递归处理
            String sub = dfs(s, l, r - 2);
            while (k-- > 0) {
                sb.append(sub);
            }
            l = r;
        }
        return sb.toString();
    }

    /**
     * 别人的代码可真是简洁~~
     * <p>
     * 思路：双栈，数字栈 + 字符串栈
     * <p>
     * 遇到 [ 时，数字、字符串入栈
     * <p>
     * 遇到 ] 时，数字、字符串出栈
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.1 MB,击败了99.51% 的Java用户
     */
    @TestCase(input = {"3[a]2[bc]", "3[a2[c]]", "2[abc]3[cd]ef", "abc3[cd]xyz", "10[a]"},
            output = {"aaabcbc", "accaccacc", "abcabccdcdcdef", "abccdcdcdxyz", "aaaaaaaaaa"})
    private String doubleStack(String s) {
        StringBuilder str = new StringBuilder();
        int times = 0;
        Deque<Integer> timesStack = new LinkedList<>();
        Deque<StringBuilder> strStack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                timesStack.push(times);
                strStack.push(str);
                times = 0;
                str = new StringBuilder();
            } else if (c == ']') {
                String cur = str.toString();
                times = timesStack.pop();
                str = strStack.pop();
                for (; times > 0; times--) {
                    str.append(cur);
                }
            } else if (Character.isDigit(c)) {
                times = times * 10 + (c - '0');
            } else {
                str.append(c);
            }
        }
        return str.toString();
    }

}
