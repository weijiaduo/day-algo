package com.wjd.practice.leetcode.graph;

import com.wjd.practice.TestCase;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 127. 单词接龙
 * <p>
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列
 * <p>
 * beginWord -> s1 -> s2 -> ... -> sk：
 * <p>
 * 每一对相邻的单词只差一个字母。
 * <p>
 * 对于 1 <= i <= k 时，每个
 * si 都在
 * wordList 中。注意， beginWord 不需要在 wordList 中。
 * <p>
 * sk == endWord
 * <p>
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列中的 单词数目 。
 * <p>
 * 如果不存在这样的转换序列，返回 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * <p>
 * 示例 2：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 * <p>
 * 提示：
 * <p>
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有字符串 互不相同
 *
 * @author weijiaduo
 * @since 2023/12/11
 */
public class LadderLength {

    /**
     * 思路：广度优先搜索
     * <p>
     * 将单词集合构成一个无向图，然后用广度优先搜索求最短路径
     * <p>
     * 复杂度：时间 O(n) 空间 O(n^2)
     * <p>
     * 执行耗时:591 ms,击败了25.39% 的Java用户
     * 内存消耗:43.1 MB,击败了79.62% 的Java用户
     */
    @TestCase(input = {"hit", "cog", "[\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]",
            "hit", "cog", "[\"hot\",\"dot\",\"dog\",\"lot\",\"log\"]"},
            output = {"5", "0"})
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 构建无向图
        int n = wordList.size();
        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int target = -1;
        for (int i = 0; i < n; i++) {
            String s1 = wordList.get(i);
            if (s1.equals(endWord)) {
                target = i;
            }
            for (int j = 0; j < i; j++) {
                String s2 = wordList.get(j);
                if (isNeighbour(s1, s2)) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        // 目标不存在
        if (target == -1) {
            return 0;
        }

        // 广度优先搜索
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (isNeighbour(beginWord, wordList.get(i))) {
                queue.offer(i);
                visited[i] = true;
            }
        }
        for (int level = 1; !queue.isEmpty(); level++) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int idx = queue.poll();
                if (idx == target) {
                    // 加上 beginWord
                    return level + 1;
                }
                for (int j : adj.get(idx)) {
                    if (!visited[j]) {
                        queue.offer(j);
                        visited[j] = true;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 两个字符串是否相邻，即只有1个字符变化
     *
     * @param s1 字符串
     * @param s2 字符串
     * @return true/false
     */
    private boolean isNeighbour(String s1, String s2) {
        int diff = 0;
        int n = s1.length();
        for (int i = 0; i < n && diff < 2; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

}
