package com.wjd.practice.leetcode.array.statistics;

import java.util.HashMap;
import java.util.Map;

/**
 * 第 310 场周赛
 * <p>
 * 6176. 出现最频繁的偶数元素
 * <p>
 * 给你一个整数数组 nums ，返回出现最频繁的偶数元素。
 * <p>
 * 如果存在多个满足条件的元素，只需要返回 最小 的一个。如果不存在这样的元素，返回 -1 。
 * <p>
 * 输入：nums = [0,1,2,2,4,4,1]
 * 输出：2
 * 解释：
 * 数组中的偶数元素为 0、2 和 4 ，在这些元素中，2 和 4 出现次数最多。
 * 返回最小的那个，即返回 2 。
 *
 * @author weijiaduo
 * @since 2022/9/11
 */
public class MostFrequentEven {

    /**
     * 思路：哈希表统计数字频率，频率相同的情况优先返回小的那个
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行用时：16 ms, 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗：41.4 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums 数组
     * @return 频率最大的数字
     */
    public int mostFrequentEven(int[] nums) {
        // 统计所有偶数的频率
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (num % 2 != 0) {
                continue;
            }
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // 找出最大频率的最小值
        int minNum = -1, maxCount = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int value = entry.getValue();
            if (value > maxCount) {
                minNum = entry.getKey();
                maxCount = value;
            } else if (value == maxCount) {
                if (minNum == -1 || entry.getKey() < minNum) {
                    minNum = entry.getKey();
                }
            }
        }
        return minNum;
    }

}
