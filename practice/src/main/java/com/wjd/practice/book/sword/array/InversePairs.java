package com.wjd.practice.book.sword.array;

import com.wjd.practice.TestCase;

import java.util.Arrays;

/**
 * 51. 数组中的逆序对
 * <p>
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * <p>
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * <p>
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * @author weijiaduo
 * @since 2023/11/28
 */
public class InversePairs {

    /**
     * 思路：归并排序
     * <p>
     * 逆序对的总数 = 左边数组中的逆序对的数量 + 右边数组中逆序对的数量 + 左右结合成新的顺序数组时中出现的逆序对的数量
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     */
    @TestCase(input = {"[1,2,3,4,5,6,7,0]", "[7,5,6,4]"},
            output = {"0", "5"})
    public int inversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] copy = Arrays.copyOf(nums, nums.length);
        return inversePairs(nums, copy, 0, nums.length - 1);
    }

    /**
     * 归并排序计算逆序对
     *
     * @param nums 数组
     * @param buf  临时数组
     * @param low  [low, high]
     * @param high [low, high]
     * @return 逆序对的数量
     */
    private int inversePairs(int[] nums, int[] buf, int low, int high) {
        if (low >= high) {
            return 0;
        }

        long sum = 0;
        int mid = low + (high - low) / 2;

        // 交换 nums 和 buf 可避免复制数组
        // 左边数组中的逆序对的数量
        sum += inversePairs(buf, nums, low, mid);
        // 右边数组中逆序对的数量
        sum += inversePairs(buf, nums, mid + 1, high);

        // 合并排序数组区间
        int i = mid, j = high, k = high;
        while (i >= low && j > mid) {
            if (nums[i] > nums[j]) {
                // 合并时产生的新的逆序对
                sum += j - mid;
                buf[k--] = nums[i--];
            } else {
                buf[k--] = nums[j--];
            }
        }
        while (i >= low) {
            buf[k--] = nums[i--];
        }
        while (j > mid) {
            buf[k--] = nums[j--];
        }

        return (int) (sum % 1000000007);
    }

}
