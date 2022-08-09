package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @since 2021-07-01
 *
 * 18. 四数之和
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
 * d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：答案中不可以包含重复的四元组。
 *
 * 0 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 */
public class FourSum implements Solution<List<List<Integer>>> {

    @Override
    public List<List<Integer>> solve(Object ...args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> result = fourSum(nums, target);
        System.out.println(result);
        return result;
    }

    /**
     * 四数之和
     * @param nums 数组
     * @param target 目标值
     * @return 四元组列表
     */
    private List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> values = new ArrayList<>(4);
        for (int i = 0; i < nums.length - 3; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            values.add(nums[i]);
            List<List<Integer>> sumList = threeSum(nums, target - nums[i], i + 1, nums.length - 1, values);
            if (sumList.size() > 0) {
                result.addAll(sumList);
            }
            values.remove(values.size() - 1);
        }
        return result;
    }

    /**
     * 三数之和
     * @param nums 数组
     * @return 所有三元组
     */
    private List<List<Integer>> threeSum(int[] nums, int target, int start, int end, List<Integer> values) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i < nums.length - 2; i++) {
            // 去重
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            values.add(nums[i]);
            List<List<Integer>> sumList = twoSum(nums, target - nums[i], i + 1, nums.length - 1, values);
            if (sumList.size() > 0) {
                result.addAll(sumList);
            }
            values.remove(values.size() - 1);
        }
        return result;
    }

    /**
     * 求2数之和
     * @param nums 升序数组
     * @param target 两数和
     * @param start 起始地址
     * @param end 结束地址
     * @return 两数，或null
     */
    private List<List<Integer>> twoSum(int[] nums, int target, int start, int end, List<Integer> values) {
        List<List<Integer>> result = new ArrayList<>();
        int lp = start, rp = end;
        int size = values.size() + 2;
        while (lp < rp) {
            int temp = nums[lp] + nums[rp];
            if (temp == target) {
                List<Integer> sumList = new ArrayList<>(size);
                sumList.addAll(values);
                sumList.add(nums[lp]);
                sumList.add(nums[rp]);
                result.add(sumList);
                // 去重
                while (lp < rp && nums[lp] == nums[++lp]);
                while (lp < rp && nums[rp] == nums[--rp]);
            } else if (temp < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return result;
    }
}
