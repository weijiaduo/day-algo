package com.wjd.practice.leetcode.array.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 229. 多数元素2
 * <p>
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 * 输入：nums = [3,2,3]
 * 输出：[3]
 *
 * @author weijiaduo
 * @since 2022/9/3
 */
public class MajorityElement2 {

    public List<Integer> majorElement(int[] nums) {
        // return map(nums);
        return vote(nums);
    }

    /**
     * 思路：暴力计数，统计每个数字的出现次数
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:10 ms,击败了43.74% 的Java用户
     * 内存消耗:44.9 MB,击败了63.11% 的Java用户
     */
    private List<Integer> map(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            int c = count.getOrDefault(num, 0);
            count.put(num, c + 1);
        }

        List<Integer> ans = new ArrayList<>();
        int c = n / 3;
        for (Integer num : count.keySet()) {
            Integer nc = count.get(num);
            if (nc > c) {
                ans.add(num);
            }
        }
        return ans;
    }

    /**
     * 思路：投票法，每3个不同元素进行一次消除，最后剩下的元素必定大于等于 n/3
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了99.86% 的Java用户
     * 内存消耗:45.6 MB,击败了10.71% 的Java用户
     *
     * @param nums 数组
     * @return 大于 n/3 的元素
     */
    private List<Integer> vote(int[] nums) {
        // 每3个不同元素进行一次消除
        int num1 = 0, vote1 = 0;
        int num2 = 0, vote2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && num == num1) {
                vote1++;
            } else if (vote2 > 0 && num == num2) {
                vote2++;
            } else if (vote1 == 0) {
                num1 = num;
                vote1++;
            } else if (vote2 == 0) {
                num2 = num;
                vote2++;
            } else {
                vote1--;
                vote2--;
            }
        }

        // 统计实际的出现次数
        int count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == num1 && vote1 > 0) {
                count1++;
            } else if (num == num2 && vote2 > 0) {
                count2++;
            }
        }

        // 返回大于 n/3 的元素
        List<Integer> ans = new ArrayList<>(2);
        int threshold = nums.length / 3;
        if (count1 > threshold) {
            ans.add(num1);
        }
        if (count2 > threshold) {
            ans.add(num2);
        }
        return ans;
    }

}
