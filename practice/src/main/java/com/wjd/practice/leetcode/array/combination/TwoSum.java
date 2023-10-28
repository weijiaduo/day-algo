package com.wjd.practice.leetcode.array.combination;

import com.wjd.practice.TestCase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 10⁴
 * -10⁹ <= nums[i] <= 10⁹
 * -10⁹ <= target <= 10⁹
 * 只会存在一个有效答案
 *
 * @author weijiaduo
 * @since 2022/10/1
 */
public class TwoSum {

    /**
     * 思路：暴力法，直接验证所有的数字，判断结果
     * <p>
     * 复杂度：时间 O(n^2) 空间 O(1)
     * <p>
     * 执行耗时:50 ms,击败了32.94% 的Java用户
     * 内存消耗:41.3 MB,击败了83.54% 的Java用户
     */
    @TestCase(input = {"[2,7,11,15]", "9", "[3,2,4]", "6", "[3,3]", "6"},
            output = {"[0,1]", "[1,2]", "[0,1]"})
    public int[] brute(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 思路：双指针，根据和的大小移动左右指针
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     * <p>
     * 执行耗时:7 ms,击败了45.36% 的Java用户
     * 内存消耗:41.9 MB,击败了15.42% 的Java用户
     */
    @TestCase(input = {"[2,7,11,15]", "9", "[3,2,4]", "6", "[3,3]", "6"},
            output = {"[0,1]", "[1,2]", "[0,1]"})
    public int[] sort(int[] nums, int target) {
        int n = nums.length;
        Integer[] indexes = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, Comparator.comparingInt(a -> nums[a]));

        // 双指针收缩
        int l = 0, r = n - 1;
        while (l < r) {
            int sum = nums[indexes[l]] + nums[indexes[r]];
            if (sum == target) {
                return new int[]{indexes[l], indexes[r]};
            }
            if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return null;
    }

    /**
     * 思路：哈希表，保存已遍历过的元素，判断后面的元素时，直接验证  target - num 存不存在
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了99.67% 的Java用户
     * 内存消耗:41.3 MB,击败了89.56% 的Java用户
     */
    @TestCase(input = {"[2,7,11,15]", "9", "[3,2,4]", "6", "[3,3]", "6"},
            output = {"[0,1]", "[1,2]", "[0,1]"})
    public int[] hash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
