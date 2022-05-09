package com.wjd.algorithm.practice.leetcode.array;

import com.wjd.algorithm.practice.leetcode.Solution;
import com.wjd.util.ArrayUtil;

/**
 * @since 2021-07-13
 *
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 */
public class SearchRange implements Solution<int[]> {

    @Override
    public int[] solve(Object args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 4;
        int[] result = searchRange(nums, target);
        ArrayUtil.print(result);
        return result;
    }

    /**
     * 搜索指定目标值的范围
     * @param nums 数组
     * @param target 目标值
     * @return 索引范围
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = result[1] = -1;
        int lp = findIndex(nums, target, 0, nums.length);
        if (0 <= lp && lp < nums.length && nums[lp] == target) {
            result[0] = lp;
            result[1] = findIndex(nums, target + 1, lp, nums.length) - 1;
        }
        return result;
    }

    /**
     * 查找大于等于 target 的第一个位置
     * @param nums 数组
     * @param target 目标值
     * @param start 起始位置
     * @param end 结束位置，不包括
     * @return 大于等于target的第一个位置，或-1，或end
     */
    private int findIndex(int[] nums, int target, int start, int end) {
        if (end <= start) {
            return -1;
        }
        int lp = start, rp = end;
        while (lp < rp) {
            int m = lp + ((rp - lp) >> 1);
            if (target <= nums[m]) {
                rp = m;
            } else {
                lp = m + 1;
            }
        }
        return rp;
    }
}
