package com.wjd.practice.leetcode.dynamic;

import com.wjd.practice.leetcode.TestCase;

/**
 * 5. 最长回文子串
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 * @author weijiaduo
 * @since 2023/7/6
 */
public class LongestPalindrome {

    /**
     * 思路：动态规划，二维数组对角线遍历
     * <p>
     * dp[i][j] 表示子串 [i,j] 是否是回文串
     * <p>
     * 那么就有：
     * <p>
     * dp[i][j] = s[i]==s[j] && dp[i+1,j-1]
     * <p>
     * 在遍历过程中，顺便统计最长的回文串
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n^2)
     * <p>
     * 执行耗时:186 ms,击败了15.40% 的Java用户
     * 内存消耗:45.4 MB,击败了7.40% 的Java用户
     */
    @TestCase(input = {"babad", "cbbd"},
            output = {"bab", "bb"})
    public String dynamic22(String s) {
        // 状态定义
        // dp[i][j] 表示子串 [i,j] 是否是回文串
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        // 初始化状态
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i > 0) {
                dp[i][i - 1] = true;
            }
        }
        // 状态转移，对角线遍历
        String ans = s.substring(0, 1);
        for (int d = 1; d < n; d++) {
            for (int i = 0; i < n - d; i++) {
                int j = i + d;
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                if (dp[i][j] && j - i + 1 > ans.length()) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    /**
     * 思路：动态规划，倒着遍历
     * <p>
     * 动态规划只依赖了下一行的数据，因此可以倒着遍历计算
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n^2)
     * <p>
     * 执行耗时:169 ms,击败了20.12% 的Java用户
     * 内存消耗:44.8 MB,击败了14.68% 的Java用户
     */
    @TestCase(input = {"babad", "cbbd"},
            output = {"bab", "bb"})
    public String dynamic2(String s) {
        // 状态定义
        // dp[i][j] 表示子串 [i,j] 是否是回文串
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        // 状态转移，倒着遍历
        String ans = s.substring(0, 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                // j-1 - (i+1) + 1 < 2  ==>  j - i < 3
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > ans.length()) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    /**
     * 思路：动态规划，滚动数组
     * <p>
     * 倒着遍历的动态规划，只依赖于上一轮的结果
     * <p>
     * 所以可以将空间优化，改成滚动数组
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 执行耗时:137 ms,击败了30.31% 的Java用户
     * 内存消耗:43.2 MB,击败了47.14% 的Java用户
     */
    @TestCase(input = {"babad", "cbbd"},
            output = {"bab", "bb"})
    public String dynamic1(String s) {
        // 状态定义
        // dp[j] 表示子串 [*,j] 是否是回文串
        int n = s.length();
        boolean[] dp = new boolean[n];
        // 状态转移
        String ans = s.substring(0, 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                // j-1 - (i+1) + 1 < 2  ==>  j - i < 3
                dp[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[j - 1]);
                if (dp[j] && j - i + 1 > ans.length()) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    /**
     * 官方题解
     * <p>
     * 思路：中心扩展法，以每个位置为中心，向左右两边扩展
     * <p>
     * 注意，回文串可能是奇数串，或者偶数串，所以中心会分为2种
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(1)
     * <p>
     * 执行耗时:14 ms,击败了90.86% 的Java用户
     * 内存消耗:40.2 MB,击败了89.75% 的Java用户
     */
    @TestCase(input = {"babad", "cbbd"},
            output = {"bab", "bb"})
    public String expand(String s) {
        int start = 0, end = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int odd = expand(s, i, i);
            int even = expand(s, i, i + 1);
            int len = Math.max(odd, even);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        int n = s.length();
        while (left >= 0 && right < n) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * 思路：Manacher 算法
     * <p>
     * 利用已有的回文串，加快后面回文串的比较
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:8 ms,击败了93.77% 的Java用户
     * 内存消耗:41.3 MB,击败了77.94% 的Java用户
     */
    @TestCase(input = {"babad", "cbbd"},
            output = {"bab", "bb"})
    public String manacher(String s) {
        // 预处理字符串
        String ps = process(s);
        int n = ps.length();
        int[] p = new int[n];
        int center = 0, right = 0;
        for (int i = 0; i < n; i++) {
            // 寻找 i 关于 center 对称的位置
            if (i < right) {
                int mi = 2 * center - i;
                p[i] = Math.min(p[mi], right - i);
            }

            // 继续扩展回文串
            while (i - p[i] - 1 >= 0 && i + p[i] + 1 < n
                    && ps.charAt(i - p[i] - 1) == ps.charAt(i + p[i] + 1)) {
                p[i]++;
            }

            // 回文串边界变大了
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        int c = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] > p[c]) {
                c = i;
            }
        }
        // 在原始字符串的起始索引
        int start = (c - p[c]) / 2;
        return s.substring(start, start + p[c]);
    }

    private String process(String s) {
        if (s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            sb.append("#").append(s.charAt(i));
        }
        sb.append("#");
        return sb.toString();
    }

}
