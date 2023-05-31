package com.wjd.practice.leetcode.array.traversal;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. 存在重复元素 II
 * <p>
 * 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 至多为 k。
 *
 * @since 2021-05-29
 */
public class ContainsNearbyDuplicate {

    /**
     * 存在重复元素 II
     *
     * @param nums 数组
     * @param k    间隔
     * @return true/false
     */
    private boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer j = map.get(nums[i]);
            if (j != null && i - j <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

}
