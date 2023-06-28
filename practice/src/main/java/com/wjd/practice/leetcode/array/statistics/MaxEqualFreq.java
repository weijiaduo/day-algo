package com.wjd.practice.leetcode.array.statistics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1224. 最大相等频率
 * <p>
 * 给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度：
 * <p>
 * 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。
 * <p>
 * 输入：nums = [2,2,1,1,5,3,3,5]
 * 输出：7
 * 解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4] = 5，就可以得到 [2,2,1,1,3,3]，里面每个数
 * 字都出现了两次。
 *
 * @author weijiaduo
 * @since 2022/8/18
 */
public class MaxEqualFreq {

    /**
     * 思路：哈希表统计每个数字的数量，然后从后往前遍历数组，减少数字数量，直到满足要求为止
     * <p>
     * 复杂度：时间 O(n * nlongn) 空间 O(n)
     *
     * @param nums 数组
     * @return 最大相等频率
     */
    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            int count = freq.getOrDefault(num, 0);
            freq.put(num, count + 1);
        }

        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            if (check(freq)) {
                return i + 1;
            }
            int count = freq.get(nums[i]);
            if (count == 1) {
                freq.remove(nums[i]);
            } else {
                freq.put(nums[i], count - 1);
            }
        }
        return 0;
    }

    private boolean check(Map<Integer, Integer> map) {
        if (map.size() <= 1) {
            return true;
        }
        int n = map.size();
        Integer[] values = map.values().toArray(new Integer[0]);
        Arrays.sort(values);
        if (values[0] == 1 && values[1] - values[n - 1] == 0) {
            return true;
        }
        if (values[n - 2] - values[0] == 0 && values[n - 1] - values[n - 2] == 1) {
            return true;
        }
        return false;
    }

    /**
     * 思路：一个哈希记录数字出现次数，一个哈希记录次数频率
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:60 ms,击败了26.67% 的Java用户
     * 内存消耗:49.7 MB,击败了63.33% 的Java用户
     *
     * @param nums 数组
     * @return 最大相等频率
     */
    private int maxEqualFreq2(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, Integer> freqs = new HashMap<>();
        int n = nums.length;
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];

            // 统计数字出现次数
            int count = counts.getOrDefault(num, 0);
            counts.put(num, count + 1);
            maxCount = Math.max(maxCount, count + 1);

            // 统计次数的频率
            int freq = freqs.getOrDefault(count, 0);
            if (freq > 0) {
                // 频率升高了，需要减掉当前频率
                freqs.put(count, freq - 1);
            }
            freqs.put(count + 1, freqs.getOrDefault(count + 1, 0) + 1);

            // 1、数字出现次数都是1，随便删除其中1个即可
            // 2、有一个次数是1，其他的次数都相同
            // 3、有一个次数比其他次数大1，其他次数都相同
            boolean isAccept = maxCount == 1 ||
                    freqs.get(1) == 1 && 1 + freqs.get(maxCount) * maxCount == i + 1 ||
                    freqs.get(maxCount) == 1 && freqs.get(maxCount - 1) * (maxCount - 1) + maxCount == i + 1;
            if (isAccept) {
                ans = i + 1;
            }
        }
        return ans;
    }

}
