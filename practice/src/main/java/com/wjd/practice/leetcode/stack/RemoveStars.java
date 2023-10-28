package com.wjd.practice.leetcode.stack;

import com.wjd.practice.TestCase;

/**
 * 2390. 从字符串中移除星号
 * <p>
 * 给你一个包含若干星号 * 的字符串 s 。
 * <p>
 * 在一步操作中，你可以：
 * <p>
 * 选中 s 中的一个星号。
 * <p>
 * 移除星号 左侧 最近的那个 非星号 字符，并移除该星号自身。
 * <p>
 * 返回移除 所有 星号之后的字符串。
 * <p>
 * 注意：
 * <p>
 * 生成的输入保证总是可以执行题面中描述的操作。
 * 可以证明结果字符串是唯一的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leet**cod*e"
 * 输出："lecoe"
 * 解释：从左到右执行移除操作：
 * - 距离第 1 个星号最近的字符是 "leet**cod*e" 中的 't' ，s 变为 "lee*cod*e" 。
 * - 距离第 2 个星号最近的字符是 "lee*cod*e" 中的 'e' ，s 变为 "lecod*e" 。
 * - 距离第 3 个星号最近的字符是 "lecod*e" 中的 'd' ，s 变为 "lecoe" 。
 * 不存在其他星号，返回 "lecoe" 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "erase*****"
 * 输出：""
 * 解释：整个字符串都会被移除，所以返回空字符串。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10⁵
 * s 由小写英文字母和星号 * 组成
 * s 可以执行上述操作
 *
 * @author weijiaduo
 * @since 2023/10/8
 */
public class RemoveStars {

    /**
     * 思路：栈，遇到非*号，入栈，遇到*号，栈顶出栈
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:29 ms,击败了86.52% 的Java用户
     * 内存消耗:43.7 MB,击败了54.80% 的Java用户
     */
    @TestCase(input = {"leet**cod*e", "erase*****"},
            output = {"lecoe", ""})
    public String stack(String s) {
        // 直接适用字符串构建器模拟栈
        StringBuilder stack = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                stack.deleteCharAt(stack.length() - 1);
            } else {
                stack.append(ch);
            }
        }
        return stack.toString();
    }

}
