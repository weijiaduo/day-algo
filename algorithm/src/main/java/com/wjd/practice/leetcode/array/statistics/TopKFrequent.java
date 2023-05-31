package com.wjd.practice.leetcode.array.statistics;

import java.util.*;

/**
 * 347. 前K个高频元素
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。
 * <p>
 * 你可以按 任意顺序 返回答案。
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * @author weijiaduo
 * @since 2022/9/8
 */
public class TopKFrequent {

    /**
     * 思路：用哈希表统计数字频率，再用有序哈希表倒排索引数字频率到数字，最后直接拿前k个元素即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:12 ms,击败了90.27% 的Java用户
     * 内存消耗:44 MB,击败了45.39% 的Java用户
     */
    public int[] topKFrequent(int[] nums, int k) {
        // 统计频率
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            int c = count.getOrDefault(num, 0);
            count.put(num, c + 1);
        }

        // 倒排索引，按照频率从高到低排序
        Map<Integer, List<Integer>> map = new TreeMap<>((a, b) -> b - a);
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int c = entry.getValue();
            List<Integer> list = map.computeIfAbsent(c, t -> new ArrayList<>());
            list.add(num);
        }

        // 获取频率最高的k个元素
        int i = 0;
        int[] ans = new int[k];
        for (List<Integer> list : map.values()) {
            for (int num : list) {
                ans[i++] = num;
                if (i == k) {
                    return ans;
                }
            }
        }
        return ans;
    }

}
