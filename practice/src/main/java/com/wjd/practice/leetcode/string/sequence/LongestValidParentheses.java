package com.wjd.practice.leetcode.string.sequence;

import com.wjd.practice.leetcode.TestCase;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. 最长有效括号
 * <p>
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = ""
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 3 * 10⁴
 * s[i] 为 '(' 或 ')'
 *
 * @since 2022/5/21
 */
public class LongestValidParentheses {

    /**
     * 思路：暴力法，检查以每个 i 开头的子串的最长有效括号
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(1)
     * <p>
     * 执行耗时:790 ms,击败了5.29% 的Java用户
     * 内存消耗:41.4 MB,击败了34.80% 的Java用户
     */
    @TestCase(input = {"(()", ")()())", ""},
            output = {"2", "4", "0"})
    public int brute(String s) {
        int ans = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            int leftCount = 0;
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == ')') {
                    // 右括号
                    leftCount--;
                    if (leftCount < 0) {
                        // 无效括号
                        break;
                    }
                    if (leftCount == 0) {
                        // 有效括号
                        if (j - i + 1 > ans) {
                            ans = j - i + 1;
                        }
                    }
                } else {
                    // 左括号
                    leftCount++;
                }
            }
        }
        return ans;
    }

    /**
     * 官方题解
     * <p>
     * 思路：动态规划，dp[i] 表示以 s[i] 为结尾的最长有效括号
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:41.2 MB,击败了49.81% 的Java用户
     */
    @TestCase(input = {"(()", ")()())", ""},
            output = {"2", "4", "0"})
    public int dynamic1(String s) {
        int ans = 0;
        // 状态定义
        // dp[i] 表示以 s[i] 为结尾的最长有效括号
        int n = s.length();
        int[] dp = new int[n];
        // 状态转移
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    // 符合临近括号的模式 "()"
                    dp[i] = i >= 2 ? (dp[i - 2] + 2) : 2;
                } else {
                    // 符合外层括号的模式 "(...)"
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = 2 + dp[i - 1];
                        // 有可能和别的有效模式连起来了"(...)(...)"
                        if (i - dp[i - 1] - 2 >= 0) {
                            dp[i] += dp[i - dp[i - 1] - 2];
                        }
                    }
                }
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    /**
     * 官方题解
     * <p>
     * 思路：栈法
     * <p>
     * 栈底元素：最后一个没有被匹配的右括号的下标
     * <p>
     * 栈底元素，实际就是最左边左括号的起始位置，用于后面计算有效括号长度
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:2 ms,击败了54.54% 的Java用户
     * 内存消耗:41.2 MB,击败了53.87% 的Java用户
     */
    @TestCase(input = {"(()", ")()())", ""},
            output = {"2", "4", "0"})
    public int stack(String s) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }

    /**
     * 官方题解
     * <p>
     * 思路：计数法，去掉栈用到的空间，直接统计左右括号的数量
     * <p>
     * 一次从左往右遍历，找到最长有效括号
     * <p>
     * 一次从右往左遍历，找最长有效括号
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:39.8 MB,击败了98.41% 的Java用户
     */
    @TestCase(input = {"(()", ")()())", ""},
            output = {"2", "4", "0"})
    public int count(String s) {
        int ans = 0;
        int n = s.length();
        // 从左往右遍历
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                ans = Math.max(left + right, ans);
            } else if (left < right) {
                // 如果右括号比左括号多，就重新开始
                left = right = 0;
            }
        }
        // 从右往左遍历
        left = right = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                ans = Math.max(left + right, ans);
            } else if (right < left) {
                // 如果左括号比右括号多，就重新开始
                left = right = 0;
            }
        }
        return ans;
    }

}
