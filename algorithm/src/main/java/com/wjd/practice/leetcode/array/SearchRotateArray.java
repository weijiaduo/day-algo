package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

/**
 * 81. 搜索旋转排序数组
 * <p>
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k],
 * nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,
 * 2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值
 * target ，则返回 true ，否则返回 false 。
 * <p>
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 * <p>
 * @since 2022/6/5
 */
public class SearchRotateArray implements Solution<Boolean> {

    @Override
    public Boolean solve(Object... args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        int target = 2;
        boolean result = search(nums, target);
        System.out.println(result);
        return result;
    }

    /**
     * 二分法
     *
     * 思路：即使旋转了，还是有序的，依旧可以使用二分法，只是判断特殊一点。另外需要注意重复值的特殊处理
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41 MB,击败了73.74% 的Java用户
     */
    public boolean search(int[] nums, int target) {
        int lp = 0, rp = nums.length - 1;
        while (lp <= rp) {
            if (nums[lp] == nums[rp]) {
                // 没办法判断左边还是右边
                if (nums[lp] == target) {
                    return true;
                } else {
                    lp++;
                    rp--;
                }
                continue;
            }

            int mp = lp + (rp - lp) / 2;
            if (nums[mp] == target) {
                return true;
            }
            if (nums[mp] >= nums[lp]) {
                if (nums[lp] <= target && target < nums[mp]) {
                    rp = mp - 1;
                } else {
                    lp = mp + 1;
                }
            } else {
                if (nums[mp] < target && target <= nums[rp]) {
                    lp = mp + 1;
                } else {
                    rp = mp - 1;
                }
            }
        }
        return false;
    }

}
