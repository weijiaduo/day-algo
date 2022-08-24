package com.wjd.practice.leetcode.string;

import com.wjd.practice.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 126. 单词接龙2
 *
 * @author weijiaduo
 * @since 2022/6/22
 */
public class FindLadders implements Solution<List<List<String>>> {

    @Override
    public List<List<String>> solve(Object... args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = Arrays.asList(words);
        List<List<String>> result = findLadders(beginWord, endWord, wordList);
        System.out.println(result);
        return result;
    }

    List<List<String>> ans;
    List<String> path;
    boolean[] visited;
    int min;

    private List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return new ArrayList<>(0);
        }
        min = wordList.size() + 1;
        visited = new boolean[wordList.size()];
        path = new ArrayList<>();
        ans = new ArrayList<>();
        path.add(beginWord);
        dfs(beginWord, endWord, wordList);
        return ans;
    }

    /**
     * 猜到了，应该会超时
     *
     * Time Limit Exceeded
     */
    private void dfs(String beginWord, String endWord, List<String> wordList) {
        for (int i = 0; i < visited.length; i++) {
            String word = wordList.get(i);
            if (visited[i] || !isDeferOneChar(word, beginWord)) {
                continue;
            }
            path.add(word);
            if (word.equals(endWord)) {
                // 找到目标单词
                if (path.size() < min) {
                    // 路径比之前找到的还要短，清除之前的路径
                    min = path.size();
                    ans.clear();
                    ans.add(new ArrayList<>(path));
                } else if (path.size() == min) {
                    // 路径和之前最小路径一样短，则添加
                    ans.add(new ArrayList<>(path));
                }
            } else {
                // 回溯寻找目标单词
                visited[i] = true;
                dfs(word, endWord, wordList);
                visited[i] = false;
            }
            path.remove(path.size() - 1);
        }
    }

    /**
     * 是否只有一个字符的区别
     */
    private boolean isDeferOneChar(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int count = 0;
        int n = word1.length();
        for (int i = 0; i < n; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (++count > 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
