package com.wjd.practice.leetcode.array.transform;

/**
 * 80. 删除有序数组中的重复项
 * <p>
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * <p>
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
 * <p>
 *
 * @since 2022/6/5
 */
public class RemoveDuplicates {

    /**
     * 思路：双指针，前指针遍历，后指针指向新位置即可
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.8 MB,击败了11.22% 的Java用户
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int p = 0, q = 0, n = nums.length;
        while (p < n) {
            // 保留后2位相同的数字，如果是前2位有可能会判断失误
            if (p + 2 >= n || nums[p] != nums[p + 2]) {
                nums[q++] = nums[p];
            }
            p++;
        }
        return q;
    }

}
