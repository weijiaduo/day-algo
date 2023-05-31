package com.wjd.practice.leetcode.array.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * @since 2021-06-30
 */
public class ThreeSum {

    /**
     * 三数之和
     *
     * @param nums 数组
     * @return 所有三元组
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return result;
        }
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            List<List<Integer>> sumList = twoSum(nums, -nums[i], i + 1, nums.length - 1);
            if (sumList.size() > 0) {
                result.addAll(sumList);
            }
            // 去重
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    /**
     * 求2数之和
     *
     * @param nums  升序数组
     * @param sum   两数和
     * @param start 起始地址
     * @param end   结束地址
     * @return 两数，或null
     */
    private List<List<Integer>> twoSum(int[] nums, int sum, int start, int end) {
        List<List<Integer>> result = new ArrayList<>();
        int lp = start, rp = end;
        while (lp < rp) {
            int temp = nums[lp] + nums[rp];
            if (temp == sum) {
                List<Integer> sumList = new ArrayList<>(3);
                sumList.add(-sum);
                sumList.add(nums[lp]);
                sumList.add(nums[rp]);
                result.add(sumList);
                // 去重
                while (lp < rp && nums[lp] == nums[++lp]) ;
                while (lp < rp && nums[rp] == nums[--rp]) ;
            } else if (temp < sum) {
                lp++;
            } else {
                rp--;
            }
        }
        return result;
    }

}
