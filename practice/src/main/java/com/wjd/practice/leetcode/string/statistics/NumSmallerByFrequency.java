package com.wjd.practice.leetcode.string.statistics;

import java.util.Arrays;

/**
 * 1170. 比较字符串最小字母出现频次
 * <p>
 * 定义一个函数 f(s)，统计 s 中（按字典序比较）最小字母的出现频次 ，其中 s 是一个非空字符串。
 * <p>
 * 例如，若 s = "dcce"，那么 f(s) = 2，因为字典序最小字母是 "c"，它出现了 2 次。
 * <p>
 * 现在，给你两个字符串数组待查表 queries 和词汇表 words 。对于每次查询 queries[i] ，需统计 words 中满足 f(
 * queries[i]) < f(W) 的 词的数目 ，W 表示词汇表 words 中的每个词。
 * <p>
 * 请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是第 i 次查询的结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：queries = ["cbd"], words = ["zaaaz"]
 * 输出：[1]
 * 解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
 * <p>
 * 示例 2：
 * <p>
 * 输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * 输出：[1,2]
 * 解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
 * <p>
 * 提示：
 * <p>
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j]、words[i][j] 都由小写英文字母组成
 *
 * @author weijiaduo
 * @since 2023/6/10
 */
public class NumSmallerByFrequency {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        return countSort(queries, words);
    }

    /**
     * 官方题解，有点厉害~~
     * <p>
     * 思路：计数+累计和，把每个最小频率的次数统计起来，形成累计和数组
     * <p>
     * 复杂度：时间 O((m + n)l) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:42.8 MB,击败了22.50% 的Java用户
     */
    private int[] countSort(String[] queries, String[] words) {
        // 单词最长是 10
        int[] count = new int[12];
        for (String word : words) {
            count[frequency(word)]++;
        }

        // 累计和（倒过来统计）
        for (int i = 10; i >= 0; i--) {
            count[i] += count[i + 1];
        }

        // 统计每次查询的结果
        int m = queries.length;
        int[] fc = new int[m];
        for (int i = 0; i < m; i++) {
            int qc = frequency(queries[i]);
            fc[i] = count[qc + 1];
        }
        return fc;
    }

    /**
     * 思路：二分，先统计所有单词的频率，然后排序，利用二分法快速定位到大于某个值的位置，就能快速统计到数量
     * <p>
     * 复杂度：时间 O(nl + nlogn)  空间 O(n)
     * <p>
     * 执行耗时:15 ms,击败了25.00% 的Java用户
     * 内存消耗:42.8 MB,击败了22.50% 的Java用户
     */
    private int[] sortAndBinary(String[] queries, String[] words) {
        int m = queries.length, n = words.length;

        // 统计每个单词的频率
        int[] wc = new int[n];
        for (int i = 0; i < n; i++) {
            wc[i] = frequency(words[i]);
        }
        // 对频率进行排序
        Arrays.sort(wc);

        // 统计每次查询的结果
        int[] fc = new int[m];
        for (int i = 0; i < m; i++) {
            int qc = frequency(queries[i]);
            int idx = findFirstGreatThan(wc, qc);
            fc[i] = idx >= 0 ? n - idx : 0;
        }
        return fc;
    }

    /**
     * 查找第一个大于等于指定值的索引
     *
     * @param arr 数组
     * @param num 指定值
     * @return 索引
     */
    private int findFirstGreatThan(int[] arr, int num) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] > num) {
                if (m == 0 || arr[m - 1] <= num) {
                    return m;
                }
                r = m - 1;
            } else {
                l = l + 1;
            }
        }
        return -1;
    }

    /**
     * 统计单词的最小字母频率
     * <p>
     * 官方题解写的比我好多了，抄过来
     *
     * @param s 单词
     * @return 最小字母频率
     */
    private int frequency(String s) {
        int cnt = 0;
        int n = s.length();
        char mc = 'z';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c < mc) {
                mc = c;
                cnt = 1;
            } else if (c == mc) {
                cnt++;
            }
        }
        return cnt;
    }

}
