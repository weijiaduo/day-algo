package com.wjd.practice.leetcode.array.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * <p>
 * 请你找出所有和为 0 且不重复的三元组。
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
     * 思路：三数之和 nums[i] + nums[j] + nums[k] = 0，等价于 nums[j] + nums[k] = -nums[i]
     * <p>
     * 先定好 nums[i]，然后去数组中找出两数之和 nums[j] + nums[k]
     * <p>
     * 并且假设 nums[i] <= nums[j] <= nums[k]，
     * <p>
     * 因为它们3个数加起来等于 0，那么必定有 nums[i] <= 0 且 nums[k] >= 0
     * <p>
     * 复杂度：时间 O(nlogn + n^2) 空间 O(1)
     * <p>
     * 执行耗时:32 ms,击败了61.33% 的Java用户
     * 内存消耗:49.5 MB,击败了17.95% 的Java用户
     *
     * @param nums 数组
     * @return 所有三元组
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 3) {
            return result;
        }
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[n - 1] < 0) {
            return result;
        }
        for (int i = 0; i < n && nums[i] <= 0; i++) {
            List<List<Integer>> sumList = twoSum(nums, -nums[i], i + 1, n - 1);
            if (sumList.size() > 0) {
                result.addAll(sumList);
            }
            // 去重
            while (i < n - 1 && nums[i] == nums[i + 1]) {
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
