package com.wjd.practice.leetcode.string;

import com.wjd.practice.leetcode.Solution;

import java.util.*;

/**
 * 139. 单词拆分
 * <p>
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 *
 * @author weijiaduo
 * @since 2022/6/26
 */
public class WordBreak implements Solution<Boolean> {

    @Override
    public Boolean solve(Object... args) {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        boolean result = wordBreak(s, wordDict);
        System.out.println(result);
        return result;
    }

    private boolean wordBreak(String s, List<String> wordDict) {
        // return dfs(s, 0, wordDict, new HashMap<>());
        return dynamic(s, wordDict);
    }

    /**
     * 思路：递归+记忆，不断递归判断子串是否可由字典拼成
     * <p>
     * 执行耗时:1 ms,击败了99.64% 的Java用户
     * 内存消耗:41.4 MB,击败了64.82% 的Java用户
     */
    private boolean dfs(String s, int i, List<String> wordDict, Map<Integer, Boolean> cache) {
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
            if (dfs(s, i + word.length(), wordDict, cache)) {
                cache.put(i, true);
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
     * 执行耗时:6 ms,击败了74.67% 的Java用户
     * 内存消耗:41.8 MB,击败了12.75% 的Java用户
     */
    private boolean dynamic(String s, List<String> wordDict) {
        // 单词转成Set可提高速度
        Set<String> words = new HashSet<>(wordDict);

        // 创建动态存储
        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        // 初始化状态
        dp[0] = true;

        // 动态计算
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    /**
     * 思路：动态规划，从后往前匹配，同时使用单词的最大最小长度来快速剪枝
     * <p>
     * 复杂度：时间 O(n^2 * m)，空间 O(n^2)
     * <p>
     * 执行耗时:1 ms,击败了99.64% 的Java用户
     * 内存消耗:39.8 MB,击败了91.17% 的Java用户
     */
    private boolean dynamic2(String s, List<String> wordDict) {
        // 单词转成Set可提高速度
        Set<String> words = new HashSet<>(wordDict.size());
        int wordMaxLength = 0, wordMinLength = Integer.MAX_VALUE;
        for (String word : wordDict) {
            wordMaxLength = Math.max(word.length(), wordMaxLength);
            wordMinLength = Math.min(word.length(), wordMinLength);
            words.add(word);
        }

        // 创建动态存储
        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        // 初始化状态
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
