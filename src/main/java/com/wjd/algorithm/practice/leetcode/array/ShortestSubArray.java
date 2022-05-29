package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @since 2021-06-05
 * <p>
 * 697. 数组的度
 * <p>
 * 给定一个非空且只包含非负数的整数数组nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是在 nums 中找到与nums拥有相同大小的度的最短连续子数组，返回其长度。
 */
public class ShortestSubArray implements Solution<Integer> {

    @Override
    public Integer solve(Object ...args) {
        int[] nums = {1, 2, 2, 3, 1, 4, 2};
        int result = findShortestSubArray(nums);
        System.out.println(result);
        return result;
    }

    /**
     * 找到与nums拥有相同大小的度的最短连续子数组，返回其长度
     *
     * @param nums 数组
     * @return 长度
     */
    private int findShortestSubArray(int[] nums) {
        // 计算每个数的度数，以及最大度数
        int maxCount = 0;
        Map<Integer, int[]> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int[] count = countMap.get(nums[i]);
            if (count == null) {
                count = new int[3];
                count[1] = i;
            }
            count[0]++;
            count[2] = i;
            countMap.put(nums[i], count);
            if (count[0] > maxCount) {
                maxCount = count[0];
            }
        }

        // 计算最大度数数字的最短数组长度
        int minLen = nums.length;
        for (Map.Entry<Integer, int[]> entry : countMap.entrySet()) {
            int[] count = entry.getValue();
            if (count[0] == maxCount) {
                int len = count[2] - count[1] + 1;
                if (len < minLen) {
                    minLen = len;
                }
            }
        }

        return minLen;
    }

}
