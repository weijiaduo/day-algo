package com.wjd.practice.leetcode.array.permutation;

import com.wjd.practice.leetcode.TestCase;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * <p>
 * 整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
 * <p>
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：
 * <p>
 * [1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * <p>
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。
 * <p>
 * 更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，
 * <p>
 * 那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。
 * <p>
 * 如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * <p>
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * <p>
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 *
 * @since 2021-07-07
 */
public class NextPermutation {

    /**
     * 思路：逆序值，从后往前找第一个逆序值
     * <p>
     * 这个逆序值就是需要交换的数字之一，比如 [1,2,4,3] 里的 2
     * <p>
     * 然后在逆序值之后比它大的最小值，它就是交换的另外一个数字，
     * <p>
     * 比如 [1,2,4,3] 里面的 3，两者交换后得到 [1,3,4,2]
     * <p>
     * 最后再对逆序值之后的数字进行升序排序，得到 [1,3,2,4]
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.1 MB,击败了87.90% 的Java用户
     */
    @TestCase(input = {"[1,2,3]", "[3,2,1]", "[1,1,5]"},
            output = {"[1,3,2]", "[1,2,3]", "[1,5,1]"})
    public void reverseOrder(int[] nums) {
        // 寻找第一个逆序值
        int n = nums.length;
        int index = n - 2;
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }
        // 交换比逆序值大的最小值
        for (int i = n - 1; index >= 0 && i > index; i--) {
            if (nums[i] > nums[index]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }
        // 后面这部分是降序的，倒过来转成升序
        int lp = index + 1, rp = n - 1;
        while (lp < rp) {
            int temp = nums[lp];
            nums[lp++] = nums[rp];
            nums[rp--] = temp;
        }
    }

    /**
     * 思路：和寻找逆序值的一样，只是通过二分法查找而已
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了37.92% 的Java用户
     * 内存消耗:41.5 MB,击败了42.17% 的Java用户
     */
    @TestCase(input = {"[1,2,3]", "[3,2,1]", "[1,1,5]"},
            output = {"[1,3,2]", "[1,2,3]", "[1,5,1]"})
    public void binary(int[] nums) {
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            int index = findMinMax(nums, nums[i], i + 1, n);
            if (index > -1) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                Arrays.sort(nums, i + 1, n);
                return;
            }
        }
        Arrays.sort(nums);
    }

    /**
     * 查找比k大的最小值的索引
     *
     * @param nums  数组
     * @param k     指定值
     * @param start 起始索引
     * @param end   结束索引
     * @return 索引，或-1
     */
    private int findMinMax(int[] nums, int k, int start, int end) {
        int maxIndex = -1;
        for (int i = start; i < end; i++) {
            if (nums[i] <= k) {
                continue;
            }
            if (maxIndex == -1 || nums[maxIndex] > nums[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
