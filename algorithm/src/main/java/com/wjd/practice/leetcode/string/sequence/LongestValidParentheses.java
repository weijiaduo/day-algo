package com.wjd.practice.leetcode.string.sequence;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. 最长有效括号
 * <p>
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 *
 * @since 2022/5/21
 */
public class LongestValidParentheses {

    /**
     * 暴力法
     * <p>
     * 执行耗时:790 ms,击败了5.29% 的Java用户
     * 内存消耗:41.4 MB,击败了34.80% 的Java用户
     */
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int leftCount = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == ')') {
                    // 右括号
                    leftCount--;
                    if (leftCount < 0) {
                        // 无效括号
                        break;
                    } else if (leftCount == 0) {
                        // 有效括号
                        if (j - i + 1 > maxLength) {
                            maxLength = j - i + 1;
                        }
                    }
                } else {
                    // 左括号
                    leftCount++;
                }
            }
        }
        return maxLength;
    }

    /**
     * 二位数组动态规划
     * <p>
     * Memory Limit Exceeded
     */
    public int dynamicLongestValidParentheses(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 0;
            if (i > 0) {
                dp[i][i - 1] = 0;
            }
        }
        int max = 0;
        for (int d = 1; d < s.length(); d++) {
            for (int i = 0; i + d < s.length(); i++) {
                int k = i + d;
                if (dp[i][k - 1] != 0 || dp[i + 1][k] != 0) {
                    // 少一个字符时，已经是有效的括号，再增加一个字符，必然是非法的
                    dp[i][k] = 0;
                } else if (dp[i + 1][k - 1] != 0) {
                    // 中间已经是有效括号，则左右2边必须是左括号和右括号才行
                    if (s.charAt(i) == '(' && s.charAt(k) == ')') {
                        dp[i][k] = dp[i + 1][k - 1] + 2;
                    }
                } else if (isValid(s, i, k)) {
                    // 验证有效括号
                    dp[i][k] = d + 1;
                }
                if (dp[i][k] > max) {
                    max = dp[i][k];
                }
            }
        }
        return max;
    }

    private boolean isValid(String s, int i, int j) {
        int count = 0;
        for (int k = i; k <= j; k++) {
            if (s.charAt(k) == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0 || count > j - k) {
                return false;
            }
        }

        return count == 0;
    }

    /**
     * 一维数组动态规划
     * dp[i] 表示以 s[i] 为结尾的最长有效括号
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:41.2 MB,击败了49.81% 的Java用户
     */
    public int dynamic2LongestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i >= 2 ? (dp[i - 2] + 2) : 2;
                } else {
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = 2 + dp[i - 1];
                        if (i - dp[i - 1] - 2 >= 0) {
                            dp[i] += dp[i - dp[i - 1] - 2];
                        }
                    }
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /**
     * 栈法
     * 栈底元素：最后一个没有被匹配的右括号的下标
     * 栈底元素，实际就是最左边左括号的起始位置，用于后面计算有效括号长度
     * <p>
     * 执行耗时:2 ms,击败了54.54% 的Java用户
     * 内存消耗:41.2 MB,击败了53.87% 的Java用户
     */
    public int stackLongestValidParentheses(String s) {
        int max = 0;
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
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    /**
     * 计数法
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:39.8 MB,击败了98.41% 的Java用户
     */
    public int countLongestValidParentheses(String s) {
        int max = 0;
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(left + right, max);
            } else if (left < right) {
                // 如果右括号比左括号多，就重新开始
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(left + right, max);
            } else if (right < left) {
                // 如果左括号比右括号多，就重新开始
                left = right = 0;
            }
        }
        return max;
    }
}
