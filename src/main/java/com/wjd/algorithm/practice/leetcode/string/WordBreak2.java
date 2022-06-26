package com.wjd.algorithm.practice.leetcode.string;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.*;

/**
 * 140. 单词拆分2
 * <p>
 * 给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。
 * <p>
 * 以任意顺序 返回所有这些可能的句子。
 * <p>
 * 注意：词典中的同一个单词可能在分段中被重复使用多次。
 * <p>
 * 输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * 输出:["cats and dog","cat sand dog"]
 *
 * @author weijiaduo
 * @since 2022/6/26
 */
public class WordBreak2 implements Solution<List<String>> {

    @Override
    public List<String> solve(Object... args) {
        String s = "pineapplepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        List<String> result = wordBreak(s, wordDict);
        System.out.println(result);
        return result;
    }

    List<String> ans;
    Map<Integer, List<List<String>>> cache;

    private List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        cache = new HashMap<>();
        List<List<String>> list = dfs(s, 0, wordDict);
        for (List<String> l : list) {
            ans.add(String.join(" ", l));
        }
        return ans;
    }

    /**
     * 思路：递归，返回子串拼接的所有情况
     * <p>
     * 执行耗时:1 ms,击败了92.08% 的Java用户
     * 内存消耗:39.8 MB,击败了33.12% 的Java用户
     */
    private List<List<String>> dfs(String s, int i, List<String> wordDict) {
        // 快速剪枝，记忆缓存
        List<List<String>> list = cache.get(i);
        if (list != null) {
            return list;
        }

        list = new ArrayList<>();
        if (i == s.length()) {
            list.add(new ArrayList<>(0));
            return list;
        }

        for (String word : wordDict) {
            if (i + word.length() > s.length()
                    || !word.equals(s.substring(i, i + word.length()))) {
                continue;
            }

            // 递归遍历，返回子串的所有拼接情况，把当前单词加到前面
            List<List<String>> subList = dfs(s, i + word.length(), wordDict);
            for (List<String> sub : subList) {
                List<String> l = new ArrayList<>(sub.size() + 1);
                l.add(word);
                l.addAll(sub);
                list.add(l);
            }
        }
        return list;
    }

}
