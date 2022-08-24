package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @since 2021-05-29
 *
 * 219. 存在重复元素 II
 *
 * 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 至多为 k。
 *
 */
public class ContainsNearbyDuplicate implements Solution<Boolean> {

    @Override
    public Boolean solve(Object ...args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        boolean result = containsNearbyDuplicate(nums, k);
        System.out.println(result);
;       return result;
    }

    /**
     * 存在重复元素 II
     * @param nums 数组
     * @param k 间隔
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
