package com.wjd.practice.leetcode.array.statistics;

import com.wjd.practice.TestCase;

import java.util.*;

/**
 * 347. 前K个高频元素
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * <p>
 * <p>
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n是数组大小。
 *
 * @author weijiaduo
 * @since 2022/9/8
 */
public class TopKFrequent {

    /**
     * 思路：哈希+最小堆，哈希统计频率，再将最大频率的k个数字放入最小值堆中
     * <p>
     * 最小值堆中只维护 k 个数字
     * <p>
     * 复杂度：时间 O(nlogk) 空间 O(n)
     * <p>
     * 执行耗时:14 ms,击败了26.92% 的Java用户
     * 内存消耗:46.3 MB,击败了42.07% 的Java用户
     */
    @TestCase(input = {"[1,1,1,2,2,3]", "2", "[1]", "1"},
            output = {"[1,2]", "[1]"})
    private int[] heap(int[] nums, int k) {
        // 统计频率
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            int c = count.getOrDefault(num, 0);
            count.put(num, c + 1);
        }

        // 维护频率最大的 k 个数字
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a[1]));
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int c = entry.getValue();
            if (minHeap.size() < k) {
                minHeap.offer(new int[]{num, c});
            } else {
                if (c > minHeap.peek()[1]) {
                    minHeap.poll();
                    minHeap.offer(new int[]{num, c});
                }
            }
        }

        int i = 0;
        int[] ans = new int[k];
        while (!minHeap.isEmpty()) {
            ans[i++] = minHeap.poll()[0];
        }
        return ans;
    }

    /**
     * 思路：用哈希表统计数字频率，再用有序哈希表倒排索引数字频率到数字，最后直接拿前k个元素即可
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(n)
     * <p>
     * 执行耗时:12 ms,击败了90.27% 的Java用户
     * 内存消耗:44 MB,击败了45.39% 的Java用户
     */
    @TestCase(input = {"[1,1,1,2,2,3]", "2", "[1]", "1"},
            output = {"[1,2]", "[1]"})
    private int[] treeMap(int[] nums, int k) {
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
