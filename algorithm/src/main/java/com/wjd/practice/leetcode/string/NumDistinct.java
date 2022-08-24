package com.wjd.practice.leetcode.string;

import com.wjd.practice.Solution;

import java.util.Map;

/**
 * 115. 不同的子序列
 * <p>
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * <p>
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * <p>
 * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * <p>
 * 题目数据保证答案符合 32 位带符号整数范围。
 * <p>
 * @since 2022/6/19
 */
public class NumDistinct implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        String s = "rabbbit";
        String t = "rabbit";
        int result = numDistinct(s, t);
        System.out.println(result);
        return result;
    }

    private int numDistinct(String s, String t) {
        // return dfs(s, 0, t, 0, new HashMap<>());
        return dynamic(s, t);
    }

    /**
     * 递归真是够慢的
     *
     * 不过很开心，自己做出来的，刚好 200 打卡
     *
     * 执行耗时:213 ms,击败了5.33% 的Java用户
     * 内存消耗:90.7 MB,击败了5.07% 的Java用户
     */
    private int dfs(String s, int f1, String t, int f2, Map<String, Integer> cache) {
        String key = f1 + "_" + f2;
        Integer value = cache.get(key);
        if (value != null) {
            return value;
        }

        if (t.length() == f2) {
            cache.put(key, 1);
            return 1;
        }
        // 快速剪枝，s字符串的字符不够了
        if (s.length() - f1 < t.length() - f2) {
            cache.put(key, 0);
            return 0;
        }

        int num = 0;
        char ch = t.charAt(f2);
        for (int i = f1; i < s.length(); i++) {
            if (s.charAt(i) != ch) {
                continue;
            }
            num += dfs(s, i + 1, t, f2 + 1, cache);
        }
        cache.put(key, num);
        return num;
    }

    /**
     * 动态规划
     *
     * 咦，这个方法竟然才50%，咋回事，虽然可以压缩数组，但是好像时间不会快呀
     *
     * 执行耗时:14 ms,击败了50.99% 的Java用户
     * 内存消耗:48.1 MB,击败了81.73% 的Java用户
     */
    private int dynamic(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        // 初始化
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // 动态计算
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // 最后一个字符相等，可分为2种情况：取/不取s最后一个字符
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // 最后一个字符不等，只有一种情况：不取s最后一个字符
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }

}
