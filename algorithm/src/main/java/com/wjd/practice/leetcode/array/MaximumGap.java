package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.Arrays;

/**
 * 164. 最大间距
 * <p>
 * 给定一个无序的数组 nums，返回 数组在排序之后，相邻元素之间最大的差值 。
 * <p>
 * 如果数组元素个数小于 2，则返回 0 。
 * <p>
 * 您必须编写一个在「线性时间」内运行并使用「线性额外空间」的算法。
 * <p>
 * 输入: nums = [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 *
 * @author weijiaduo
 * @since 2022/7/2
 */
public class MaximumGap implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[] nums = {100, 3, 2, 1};
        int result = maximumGap(nums);
        System.out.println(result);
        return result;
    }

    private int maximumGap(int[] nums) {
        // return bucketSort(nums);
        return radixSort(nums);
    }

    /**
     * 思路：桶排序，相邻元素的最大间距肯定不小于 d = (max - min) / (n - 1)，只要设置桶大小为 d，那么桶内的元素就肯定不是最大间距
     * <p>
     * 复杂度：时间 O(n) 空间 O(s)
     * <p>
     * 执行耗时:46 ms,击败了26.05% 的Java用户
     * 内存消耗:51.8 MB,击败了84.43% 的Java用户
     *
     * @param nums 数组
     * @return 相邻元素的最大间距
     */
    private int bucketSort(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        // 找出数据范围
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();

        // 桶大小d以及桶数量size
        int n = nums.length;
        int d = Math.max(1, (max - min) / (n - 1));
        int size = (max - min) / d + 1;

        // 初始化桶
        int[][] buckets = new int[size][2];
        for (int i = 0; i < size; i++) {
            Arrays.fill(buckets[i], -1);
        }

        // 记录桶内的最大最小值
        for (int num : nums) {
            int i = (num - min) / d;
            if (buckets[i][0] == -1) {
                buckets[i][0] = buckets[i][1] = num;
            } else {
                buckets[i][0] = Math.min(buckets[i][0], num);
                buckets[i][1] = Math.max(buckets[i][1], num);
            }
        }

        // 找出桶之间的最大差值
        int[] prev = buckets[0];
        int maxGap = prev[1] - prev[0];
        for (int i = 1; i < size; i++) {
            int[] cur = buckets[i];
            if (cur[0] == -1) {
                continue;
            }
            maxGap = Math.max(maxGap, cur[0] - prev[1]);
            prev = cur;
        }

        return maxGap;
    }

    /**
     * 思路：先基数排序，最后循环一轮即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:40 ms,击败了56.65% 的Java用户
     * 内存消耗:54.9 MB,击败了37.28% 的Java用户
     *
     * @param nums 数组
     * @return 相邻元素的最大间距
     */
    private int radixSort(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        // 基数，使用计数排序
        int max = Arrays.stream(nums).max().getAsInt();
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(nums, exp);
        }

        // 找出最大间距
        int maxGap = 0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
        }
        return maxGap;
    }

    /**
     * 计数排序
     *
     * @param nums 数组
     * @param exp  指数
     */
    private void countSort(int[] nums, int exp) {
        // 基数 0~9
        int[] count = new int[10];

        // 统计各数字的频率
        for (int num : nums) {
            int idx = (num / exp) % 10;
            count[idx]++;
        }

        // 累计频率和
        int m = count.length;
        for (int i = 1; i < m; i++) {
            count[i] += count[i - 1];
        }

        // 根据计数倒序排序
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);
        for (int i = n - 1; i >= 0; i--) {
            int num = copy[i];
            int idx = (num / exp) % 10;
            nums[--count[idx]] = num;
        }
    }

}
