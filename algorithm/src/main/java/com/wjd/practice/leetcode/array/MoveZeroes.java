package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;
import com.wjd.util.ArrayUtil;

/**
 * @since 2021-05-29
 * <p>
 * 283. 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class MoveZeroes implements Solution<Void> {

    @Override
    public Void solve(Object ...args) {
        int[] nums = {2, 1, 0, 3, 12};
        moveZeroes(nums);
        ArrayUtil.print(nums);
        return null;
    }

    /**
     * 移动零到数组尾部
     *
     * @param nums 数组
     */
    private void moveZeroes(int[] nums) {
        int lp = 0, rp = 0;
        while (rp < nums.length) {
            if (nums[rp] != 0) {
                int temp = nums[lp];
                nums[lp] = nums[rp];
                nums[rp] = temp;
                lp++;
            }
            rp++;
        }
    }
}
