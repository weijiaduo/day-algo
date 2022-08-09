package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 2021-05-31
 * <p>
 * 448. 找到所有数组中消失的数字
 * <p>
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 */
public class DisappearedNumbers implements Solution<List<Integer>> {

    @Override
    public List<Integer> solve(Object ...args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 6};
        List<Integer> result = findDisappearedNumbers(nums);
        System.out.println(result);
        return result;
    }

    /**
     * 找到所有数组中消失的数字
     *
     * @param nums 数组
     * @return 消失的数字
     */
    private List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>(nums.length);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int t = nums[i] - 1;
            while (0 <= t && t < n && nums[t] != nums[i]) {
                // 循环交换到正确的位置
                nums[t] = nums[t] ^ nums[i];
                nums[i] = nums[t] ^ nums[i];
                nums[t] = nums[t] ^ nums[i];
                t = nums[i] - 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
