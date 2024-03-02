package com.wjd.practice.leetcode.dynamic.one;

import com.wjd.practice.TestCase;

import java.util.*;

/**
 * 139. 单词拆分
 * <p>
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。
 * <p>
 * 请你判断是否可以利用字典中出现的单词拼接出 s 。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * <p>
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 * 注意，你可以重复使用字典中的单词。
 * <p>
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅有小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 *
 * @author weijiaduo
 * @since 2022/6/26
 */
public class WordBreak {

    /**
     * 思路：递归+记忆，不断递归判断子串是否可由字典拼成
     * <p>
     * 复杂度：时间 O(n^2 * m)，空间 O(n^2)
     * <p>
     * 执行耗时:1 ms,击败了99.53% 的Java用户
     * 内存消耗:39.9 MB,击败了90.67% 的Java用户
     */
    @TestCase(input = {"leetcode", "[\"leet\", \"code\"]", "applepenapple", "[\"apple\", \"pen\"]"},
            output = {"true", "true"})
    public boolean meno(String s, List<String> wordDict) {
        return meno(s, 0, wordDict, new HashMap<>());
    }

    private boolean meno(String s, int i, List<String> wordDict, Map<Integer, Boolean> cache) {
        Boolean result = cache.get(i);
        if (result != null) {
            return result;
        }
        if (i == s.length()) {
            cache.put(i, true);
            return true;
        }
        for (String word : wordDict) {
            if (i + word.length() > s.length()
                || !word.equals(s.substring(i, i + word.length()))) {
                continue;
            }
            if (meno(s, i + word.length(), wordDict, cache)) {
                return true;
            }
        }
        cache.put(i, false);
        return false;
    }

    /**
     * 思路：动态规划，dp[i]表示s[0,i-1]是否能够拆分成单词
     * <p>
     * 复杂度：时间 O(n^2 * m)，空间 O(n^2)
     * <p>
     * 执行耗时:2 ms,击败了94.75% 的Java用户
     * 内存消耗:40.40 MB,击败了95.16% 的Java用户
     */
    @TestCase(input = {"leetcode", "[\"leet\", \"code\"]", "applepenapple", "[\"apple\", \"pen\"]"},
            output = {"true", "true"})
    public boolean dynamic(String s, List<String> wordDict) {
        // 状态定义
        // dp[i] 表示长度为 i 的子串是否能够由字典单词拼成
        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        // 状态初始化
        dp[0] = true;

        // 状态转移
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                if (dp[i]) {
                    break;
                }
                int wn = word.length();
                if (wn > i) {
                    continue;
                }
                dp[i] = dp[i - wn] && endWith(s, i, word);
            }
        }

        return dp[n];
    }

    /**
     * 是否以某个单词为结尾
     *
     * @param s    字符串
     * @param len  字符串长度
     * @param word 单词
     * @return true 表示以某个单位为结尾，false 表示不是
     */
    private boolean endWith(String s, int len, String word) {
        int n = word.length();
        for (int i = 0; i < n; i++) {
            if (word.charAt(n - 1 - i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 思路：动态规划，从后往前匹配，同时使用单词的最大最小长度来快速剪枝
     * <p>
     * 复杂度：时间 O(n^2 * m)，空间 O(n^2)
     * <p>
     * 执行耗时:1 ms,击败了99.64% 的Java用户
     * 内存消耗:39.8 MB,击败了91.17% 的Java用户
     */
    @TestCase(input = {"leetcode", "[\"leet\", \"code\"]", "applepenapple", "[\"apple\", \"pen\"]"},
            output = {"true", "true"})
    public boolean dynamic2(String s, List<String> wordDict) {
        // 单词转成Set可提高速度
        Set<String> words = new HashSet<>(wordDict.size());
        int wordMaxLength = 0, wordMinLength = Integer.MAX_VALUE;
        for (String word : wordDict) {
            wordMaxLength = Math.max(word.length(), wordMaxLength);
            wordMinLength = Math.min(word.length(), wordMinLength);
            words.add(word);
        }

        // 状态定义
        // dp[i] 表示长度为 i 的子串是否能够由字典单词拼成
        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        // 状态初始化
        dp[0] = true;

        // 动态计算
        for (int i = 1; i <= n; i++) {
            for (int j = i - wordMinLength; j >= 0 && j >= i - wordMaxLength; j--) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

}
