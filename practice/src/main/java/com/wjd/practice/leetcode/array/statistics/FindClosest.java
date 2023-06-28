package com.wjd.practice.leetcode.array.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17.11 单词距离
 * <p>
 * 有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。
 * <p>
 * 如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 * <p>
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"],
 * word1 = "a", word2 = "student"
 * 输出：1
 * <p>
 *
 * @since 2022/5/27
 */
public class FindClosest {

    /**
     * 思路：记录所有单词的下标，再遍历所有下标计算最小值
     * <p>
     * 执行耗时:13 ms,击败了39.01% 的Java用户
     * 内存消耗:48.9 MB,击败了74.74% 的Java用户
     */
    public int findClosest(String[] words, String word1, String word2) {
        int minAns = words.length;
        Map<String, List<Integer>> positions = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!word.equals(word1) && !word.equals(word2)) {
                continue;
            }
            List<Integer> pos = positions.getOrDefault(word, new ArrayList<>());
            pos.add(i);
            positions.put(word, pos);
        }
        List<Integer> pos1 = positions.get(word1);
        List<Integer> pos2 = positions.get(word2);
        if (pos1 != null && pos2 != null) {
            for (Integer p1 : pos1) {
                for (Integer p2 : pos2) {
                    minAns = Math.min(Math.abs(p1 - p2), minAns);
                }
            }
        }
        return minAns;
    }

    /**
     * 思路：从左至右遍历，记录最新的2个索引位置，同时更新最近距离
     * <p>
     * 执行耗时:10 ms,击败了95.69% 的Java用户
     * 内存消耗:48.7 MB,击败了94.25% 的Java用户
     */
    public int TwoPointsFindClosest(String[] words, String word1, String word2) {
        int minAns = words.length;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                index1 = i;
                if (index2 >= 0) {
                    minAns = Math.min(index1 - index2, minAns);
                }
            } else if (word.equals(word2)) {
                index2 = i;
                if (index1 >= 0) {
                    minAns = Math.min(index2 - index1, minAns);
                }
            }
        }
        return minAns;
    }

}
