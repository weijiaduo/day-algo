package com.wjd.practice.leetcode.greedy;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 * <p>
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * <p>
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * <p>
 * 返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "eccbbbbdec"
 * 输出：[10]
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s 仅由小写英文字母组成
 *
 * @author weijiaduo
 * @since 2023/7/4
 */
public class PartitionLabels {

    /**
     * 思路：贪心法，统计每个字母的最远位置，
     * <p>
     * 如果两个区间之间有交集，则合并在一起，否则单独放
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:3 ms,击败了74.30% 的Java用户
     * 内存消耗:40 MB,击败了81.79% 的Java用户
     */
    @TestCase(input = {"ababcbacadefegdehijhklij", "eccbbbbdec"},
            output = {"[9,7,8]", "[10]"})
    public List<Integer> greedy(String s) {
        // 记录字母的最远位置
        int[] indexes = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            indexes[idx] = i;
        }

        // 统计所有独立区间（没有交集）的个数
        List<Integer> ans = new ArrayList<>();
        int nowEnd = 0, lastEnd = -1;
        for (int start = 0; start < n; start++) {
            // 当前字母区间 [start, end]
            int idx = s.charAt(start) - 'a';
            int end = indexes[idx];
            nowEnd = Math.max(end, nowEnd);
            // 提前结束
            if (nowEnd >= n) {
                ans.add(n - 1 - lastEnd);
                break;
            }
            // 独立区间结束
            if (start == nowEnd) {
                ans.add(nowEnd - lastEnd);
                lastEnd = nowEnd;
            }
        }
        return ans;
    }

}
