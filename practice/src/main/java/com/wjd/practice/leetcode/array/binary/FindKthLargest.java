package com.wjd.practice.leetcode.array.binary;

import com.wjd.practice.TestCase;

/**
 * 215. 数组中的第K个最大元素
 * <p>
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 10⁵
 * -10⁴ <= nums[i] <= 10⁴
 *
 * @author weijiaduo
 * @since 2022/7/16
 */
public class FindKthLargest {

    /**
     * 思路：快速排序的二分法，每次可将数据分成2份，再判断k再那边，然后再继续二分
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:4 ms,击败了97.91% 的Java用户
     * 内存消耗:55.03MB MB,击败了30.66% 的Java用户
     */
    @TestCase(input = {"[3,2,1,5,6,4]", "2", "[3,2,3,1,2,4,5,5,6]", "4"},
            output = {"5", "4"})
    public int recursive(int[] nums, int k) {
        return recursive(nums, 0, nums.length, k - 1);
    }

    private int recursive(int[] nums, int start, int end, int k) {
        if (k < start || k >= end) {
            return -1;
        }

        int p = partition(nums, start, end);
        if (p == k) {
            return nums[p];
        } else if (p > k) {
            return recursive(nums, start, p, k);
        } else {
            return recursive(nums, p + 1, end, k);
        }
    }

    /**
     * 思路：递归改成迭代
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:5 ms,击败了94.00% 的Java用户
     * 内存消耗:55.16MB,击败了23.16% 的Java用户
     */
    @TestCase(input = {"[3,2,1,5,6,4]", "2", "[3,2,3,1,2,4,5,5,6]", "4"},
            output = {"5", "4"})
    public int iterate(int[] nums, int k) {
        k -= 1;
        int start = 0, end = nums.length;
        while (start < end) {
            int p = partition(nums, start, end);
            if (p == k) {
                return nums[p];
            } else if (p > k) {
                end = p;
            } else {
                start = p + 1;
            }
        }
        return -1;
    }

    /**
     * 二分数组，这种方式的代码简洁一点
     *
     * @param nums  数组
     * @param start [start, end)
     * @param end   [start, end)
     * @return 分隔点索引
     */
    private int partition(int[] nums, int start, int end) {
        // 随机对于某些特殊情况而言，性能提升很多
        int p = pivot(nums, start, end - 1);
        swap(nums, start, p);
        int ref = nums[start];
        int lp = start, rp = end;
        // 将数据与分区点对比，分成小于和大于2部分
        while (lp < rp) {
            // 对于大量重复值的情况，这种写法能够尽量均分数组
            do rp--; while (lp < rp && nums[rp] < ref);
            do lp++; while (lp < rp && nums[lp] > ref);
            if (lp < rp) {
                swap(nums, lp, rp);
            }
        }
        // 将分区点放到它最终的位置
        swap(nums, start, rp);
        return rp;
    }

    /**
     * 选择分区点（选择三个点的中值位置）
     *
     * @param arr 数组
     * @param i   [i, j]
     * @param j   [i, j]
     * @return 分区点索引
     */
    private int pivot(int[] arr, int i, int j) {
        int mid = i + (j - i) / 2;
        if (arr[i] < arr[j]) {
            return arr[mid] > arr[i] ? mid : j;
        } else {
            return arr[mid] < arr[i] ? mid : i;
        }
    }

    private void swap(int[] a, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
