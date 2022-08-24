package com.wjd.practice.leetcode.graph;

import com.wjd.practice.Solution;

import java.util.*;

/**
 * 114. 外星文字典
 * <p>
 * 现有一种使用英语字母的外星文语言，这门语言的字母顺序与英语顺序不同。
 * <p>
 * 给定一个字符串列表 words ，作为这门语言的词典，words 中的字符串已经 按这门新语言的字母顺序进行了排序 。
 * <p>
 * 请你根据该词典还原出此语言中已知的字母顺序，并 按字母递增顺序 排列。若不存在合法字母顺序，返回 "" 。
 * <p>
 * 若存在多种可能的合法字母顺序，返回其中 任意一种顺序即可。
 * <p>
 * 输入：words = ["wrt","wrf","er","ett","rftt"]
 * 输出："wertf"
 * <p>
 * @since 2022/5/31
 */
public class AlienOrder implements Solution<String> {

    @Override
    public String solve(Object... args) {
        String[] words = {"wrt","wrf","er","ett","rftt"};
        String result = alienOrder(words);
        System.out.println(result);
        return result;
    }

    static final int VISITING = 1, VISITED = 2;
    Map<Character, List<Character>> edges = new HashMap<>();
    Map<Character, Integer> states = new HashMap<>();
    boolean valid = true;
    char[] order;
    int index;

    /**
     * 拓扑排序 + 深度遍历
     *
     * 抄答案的，懒得写了
     *
     * 执行耗时:3 ms,击败了86.64% 的Java用户
     * 内存消耗:39.8 MB,击败了61.09% 的Java用户
     */
    public String alienOrder(String[] words) {
        // 添加有向图的节点
        int length = words.length;
        for (String word : words) {
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                char c = word.charAt(j);
                edges.putIfAbsent(c, new ArrayList<>());
            }
        }

        // 添加有向图的边
        for (int i = 1; i < length && valid; i++) {
            addEdge(words[i - 1], words[i]);
        }

        // 顺序栈，使用数组模拟
        order = new char[edges.size()];
        index = edges.size() - 1;

        // 遍历所有的字符
        Set<Character> letterSet = edges.keySet();
        for (char u : letterSet) {
            if (!states.containsKey(u)) {
                dfs(u);
            }
        }
        if (!valid) {
            return "";
        }
        return new String(order);
    }

    public void addEdge(String before, String after) {
        int length1 = before.length(), length2 = after.length();
        int length = Math.min(length1, length2);
        int index = 0;
        while (index < length) {
            char c1 = before.charAt(index), c2 = after.charAt(index);
            if (c1 != c2) {
                // 2个字母不同，则存在先后关系
                edges.get(c1).add(c2);
                break;
            }
            index++;
        }

        // 前面都相同的情况下，第一个字符串长度比第二个字符串长
        if (index == length && length1 > length2) {
            valid = false;
        }
    }

    public void dfs(char u) {
        states.put(u, VISITING);
        List<Character> adjacent = edges.get(u);
        for (char v : adjacent) {
            if (!states.containsKey(v)) {
                // 没有访问过
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (states.get(v) == VISITING) {
                // 访问到了正在访问的节点，说明存在环
                valid = false;
                return;
            }
        }
        states.put(u, VISITED);
        order[index] = u;
        index--;
    }

}
