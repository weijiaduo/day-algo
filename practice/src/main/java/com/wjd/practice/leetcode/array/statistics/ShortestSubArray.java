package com.wjd.practice.leetcode.array.statistics;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. 数组的度
 * <p>
 * 给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,3,1]
 * 输出：2
 * 解释：
 * 输入数组的度是 2 ，因为元素 1 和 2 的出现频数最大，均为 2 。
 * 连续子数组里面拥有相同度的有如下所示：
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组 [2, 2] 的长度为 2 ，所以返回 2 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,2,3,1,4,2]
 * 输出：6
 * 解释：
 * 数组的度是 3 ，因为元素 2 重复出现 3 次。
 * 所以 [2,2,3,1,4,2] 是最短子数组，因此返回 6 。
 *
 * @since 2021-06-05
 */
public class ShortestSubArray {

    /**
     * 思路：记录每个数的频率、起始索引、结束索引。
     * <p>
     * 就能得到最短连续子数组的长度：结束索引 - 起始索引 + 1
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:10 ms,击败了91.60% 的Java用户
     * 内存消耗:46.5 MB,击败了16.03% 的Java用户
     *
     * @param nums 数组
     * @return 长度
     */
    public int findShortestSubArray(int[] nums) {
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
