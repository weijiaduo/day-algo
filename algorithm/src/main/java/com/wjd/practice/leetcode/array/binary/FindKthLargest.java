package com.wjd.practice.leetcode.array.binary;

/**
 * 215. 数组中的第K个最大元素
 * <p>
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 *
 * @author weijiaduo
 * @since 2022/7/16
 */
public class FindKthLargest {

    private int findKthLargest(int[] nums, int k) {
        // return new QuickSort().findKth(nums, nums.length - k);
        // return recursive(nums, 0, nums.length, nums.length - k);
        return iteration(nums, k - 1);
    }

    /**
     * 思路：快速排序的二分法，每次可将数据分成2份，再判断k再那边，然后再继续二分
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:15 ms,击败了18.43% 的Java用户
     * 内存消耗:49.1 MB,击败了5.07% 的Java用户
     *
     * @param nums  数组
     * @param start [start, end)
     * @param end   [start, end)
     * @param k     索引k
     * @return nums[k]
     */
    private int recursive(int[] nums, int start, int end, int k) {
        if (k < start || k >= end) {
            return -1;
        }

        int rp = part(nums, start, end);
        if (rp == k) {
            return nums[rp];
        } else if (rp > k) {
            return recursive(nums, start, rp, k);
        } else {
            return recursive(nums, rp + 1, end, k);
        }
    }

    /**
     * 思路： 递归改成迭代
     * <p>
     * 复杂度：时间 O(n) 空间 O(logn)
     * <p>
     * 执行耗时:18 ms,击败了15.68% 的Java用户
     * 内存消耗:48.7 MB,击败了5.07% 的Java用户
     *
     * @param nums 数组
     * @param k    索引k
     * @return 第K大的值
     */
    private int iteration(int[] nums, int k) {
        int n = nums.length;
        if (k < 0 || k >= n) {
            return -1;
        }
        int start = 0, end = n;
        while (start < end) {
            int rp = partition(nums, start, end);
            if (rp == k) {
                return nums[rp];
            } else if (rp > k) {
                end = rp;
            } else {
                start = rp + 1;
            }
        }
        return -1;
    }

    /**
     * 二分数组
     *
     * @param nums  数组
     * @param start [start, end)
     * @param end   [start, end)
     * @return 分隔点索引
     */
    private int part(int[] nums, int start, int end) {
        int ref = nums[start];
        int lp = start, rp = end - 1;
        while (lp < rp) {
            while (lp < rp && nums[rp] <= ref) {
                rp--;
            }
            while (lp < rp && nums[lp] >= ref) {
                lp++;
            }
            if (lp < rp) {
                swap(nums, lp, rp);
            }
        }
        if (lp != start) {
            swap(nums, start, rp);
        }
        return rp;
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
        int ref = nums[start];
        int lp = start;
        for (int i = lp + 1; i < end; i++) {
            if (nums[i] >= ref) {
                swap(nums, ++lp, i);
            }
        }
        swap(nums, start, lp);
        return lp;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
