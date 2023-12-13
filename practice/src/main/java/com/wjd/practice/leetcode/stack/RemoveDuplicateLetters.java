package com.wjd.practice.leetcode.stack;

import com.wjd.practice.TestCase;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 316. 去除重复字母
 * <p>
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "bcabc"
 * 输出："abc"
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10⁴
 * s 由小写英文字母组成
 *
 * @author weijiaduo
 * @since 2023/12/13
 */
public class RemoveDuplicateLetters {

    /**
     * 思路：单调栈
     * <p>
     * 当前元素比栈顶小，并且栈顶元素后面还会出现时，移除栈顶元素
     * <p>
     * 识别栈顶元素是否还会出现，可使用计数的方式
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:2 ms,击败了68.52% 的Java用户
     * 内存消耗:40 MB,击败了85.07% 的Java用户
     */
    @TestCase(input = {"bcabc", "cbacdcbc"},
            output = {"abc", "acdb"})
    public String monotonic(String s) {
        // 统计每个字符的出现次数
        int n = s.length();
        int[] count = new int[128];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i)]++;
        }

        // 单调栈，栈里面的字符互不相同
        Deque<Character> stack = new ArrayDeque<>();
        boolean[] added = new boolean[128];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            count[ch]--;
            if (added[ch]) {
                continue;
            }

            while (!stack.isEmpty() && ch < stack.peek()
                   && count[stack.peek()] > 0) {
                added[stack.pop()] = false;
            }
            stack.push(ch);
            added[ch] = true;
        }

        // 构造字符串返回
        char[] chs = new char[stack.size()];
        for (int i = chs.length - 1; !stack.isEmpty(); i--) {
            chs[i] = stack.pop();
        }
        return new String(chs);
    }

}
