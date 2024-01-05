package com.wjd.practice.book.cracking.array;

import com.wjd.practice.TestCase;

import java.util.Arrays;

/**
 * 面试题 10.11. 峰与谷
 * <p>
 * 在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。
 * <p>
 * 例如，在数组{5, 8, 4, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。
 * <p>
 * 现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。
 * <p>
 * 示例:
 * <p>
 * 输入: [5, 3, 1, 2, 3]
 * 输出:[5, 1, 3, 2, 3]
 * <p>
 * 提示：
 * <p>
 * nums.length <= 10000
 *
 * @author weijiaduo
 * @since 2024/1/5
 */
public class WiggleSort {

    /**
     * 思路：排序，分成 2 段后交替摆放
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     * <p>
     * 执行耗时:3 ms,击败了62.79% 的Java用户
     * 内存消耗:44.4 MB,击败了12.21% 的Java用户
     */
    @TestCase(input = {"[5, 3, 1, 2, 3]"},
            output = {"[5, 1, 3, 2, 3]"})
    public void sort(int[] nums) {
        int n = nums.length;
        int[] tmp = Arrays.copyOf(nums, n);
        Arrays.sort(tmp);
        int i = 0, j = n - 1;
        for (int k = 0; k < n; k++) {
            if (k % 2 == 0) {
                nums[k] = tmp[j--];
            } else {
                nums[k] = tmp[i++];
            }
        }
    }

    /**
     * 思路：贪心
     * <p>
     * 若 i 是峰的位置，当 nums[i] < nums[i-1] 时，swap(i,i-1)
     * <p>
     * 若 i 是谷的位置，当 nums[i] > nums[i-1] 时，swap(i,i-1)
     * <p>
     * 证明：假设 [0,i] 已经满足了峰谷交替的情况
     * <p>
     * 那么对于 i+1，可分为 2 两种情况，i+1 是峰和谷
     * <p>
     * 若 i+1 是峰的位置，当 nums[i+1] < nums[i] 时，swap(i+1,i)
     * <p>
     * 由前面的条件可知 nums[i-1] >= nums[i] 的，因此 swap(i+1,i) 之后
     * <p>
     * 满足 nums[i-1] >= nums[i] < nums[i+1]，符合峰谷交替的要求
     * <p>
     * 同理，若 i+1 是谷的位置，交换后也满足峰谷交替要求
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:44.6 MB,击败了7.56% 的Java用户
     */
    @TestCase(input = {"[5, 3, 1, 2, 3]"},
            output = {"[5, 1, 3, 2, 3]"})
    public void greedy(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            boolean swap;
            if (i % 2 == 0) {
                // 峰的位置
                swap = nums[i] < nums[i - 1];
            } else {
                // 谷的位置
                swap = nums[i] > nums[i - 1];
            }
            if (swap) {
                int tmp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = tmp;
            }
        }
    }

}
