package com.wjd.practice.leetcode.array.transform;

import com.wjd.practice.TestCase;

/**
 * 80. 删除有序数组中的重复项
 * <p>
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 说明：
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢？
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 10⁴
 * -10⁴ <= nums[i] <= 10⁴
 * nums 已按升序排列
 *
 * @since 2022/6/5
 */
public class RemoveDuplicates2 {

    /**
     * 思路：双指针，前指针遍历，后指针指向新位置即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.5 MB,击败了66.39% 的Java用户
     */
    @TestCase(input = {"[1,1,1,2,2,3]", "[0,0,1,1,1,1,2,3,3]"},
            output = {"5", "7"})
    public int doublePoint(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int lp = 2, rp = 2;
        while (rp < n) {
            if (nums[lp - 2] != nums[rp]) {
                nums[lp++] = nums[rp];
            }
            rp++;
        }
        return lp;
    }

    /**
     * 思路：双指针，前指针遍历，后指针指向新位置即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 	内存消耗:42.5 MB,击败了68.47% 的Java用户
     */
    @TestCase(input = {"[1,1,1,2,2,3]", "[0,0,1,1,1,1,2,3,3]"},
            output = {"5", "7"})
    public int doublePoint2(int[] nums) {
        int p = 0, k = 2;
        for (int num : nums) {
            if (p < k || nums[p - k] != num) {
                nums[p++] = num;
            }
        }
        return p;
    }

}
