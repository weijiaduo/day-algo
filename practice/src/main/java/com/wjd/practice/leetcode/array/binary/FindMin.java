package com.wjd.practice.leetcode.array.binary;

import com.wjd.practice.leetcode.TestCase;

/**
 * 153. 寻找旋转排序数组中的最小值
 * <p>
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
 * <p>
 * 例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * <p>
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * <p>
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * <p>
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组
 * <p>
 * [a[n-1], a[0], a[1], a[2],..., a[n-2]] 。
 * <p>
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。
 * <p>
 * 请你找出并返回数组中的 最小元素 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [11,13,15,17]
 * 输出：11
 * 解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 中的所有整数 互不相同
 * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 *
 * @author weijiaduo
 * @since 2022/7/1
 */
public class FindMin {

    /**
     * 思路：二分查找，判断中值处于左边大值部分，还是右边的小值部分
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.4 MB,击败了5.08% 的Java用户
     */
    @TestCase(input = {"[3,4,5,1,2]", "[4,5,6,7,0,1,2]", "[11,13,15,17]"},
            output = {"1", "0", "11"})
    public int binary(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                // 中值处于旋转到前面的大值部分
                low = mid + 1;
            } else {
                // 中值处于后面的小值部分，中值有可能就是最小值，所以不能+1
                high = mid;
            }
        }
        return nums[low];
    }

    /**
     * 思路：二分查找，判断中值处于左边大值部分，还是右边的小值部分
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.7 MB,击败了65.72% 的Java用户
     */
    @TestCase(input = {"[3,4,5,1,2]", "[4,5,6,7,0,1,2]", "[11,13,15,17]"},
            output = {"1", "0", "11"})
    public int binary2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= nums[high]) {
                // 中值处于右半部分
                if (mid == 0 || nums[mid] < nums[mid - 1]) {
                    // 最小值
                    return nums[mid];
                }
                high = mid - 1;
            } else {
                // 中值处于左半部分
                low = mid + 1;
            }
        }
        return -1;
    }

}
