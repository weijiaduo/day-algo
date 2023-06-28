package com.wjd.practice.leetcode.array.transform;

/**
 * 283. 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 10⁴
 * -2³¹ <= nums[i] <= 2³¹ - 1
 *
 * @since 2021-05-29
 */
public class MoveZeroes {

    /**
     * 思路：前后指针，前指针遍历数组，后指针指向0值
     * <p>
     * 当前指针遇到非0值时，和后指针的值进行交换
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:44.2 MB,击败了7.40% 的Java用户
     *
     * @param nums 数组
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int lp = 0, rp = 0;
        while (rp < n) {
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
