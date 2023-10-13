package com.wjd.practice.leetcode.heap;

import com.wjd.practice.leetcode.TestCase;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2542. 最大子序列的分数
 * <p>
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，两者长度都是 n ，再给你一个正整数 k 。
 * <p>
 * 你必须从 nums1 中选一个长度为 k 的子序列 对应的下标。
 * <p>
 * 对于选择的下标 i0 ，i1 ，...， ik - 1 ，你的 分数 定义如下：
 * <p>
 * nums1 中下标对应元素求和，乘以 nums2 中下标对应元素的 最小值 。
 * <p>
 * 用公式表示： (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]) 。
 * <p>
 * 请你返回 最大 可能的分数。
 * <p>
 * 一个数组的 子序列 下标是集合 {0, 1, ..., n-1} 中删除若干元素得到的剩余集合，也可以不删除任何元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
 * 输出：12
 * 解释：
 * 四个可能的子序列分数为：
 * - 选择下标 0 ，1 和 2 ，得到分数 (1+3+3) * min(2,1,3) = 7 。
 * - 选择下标 0 ，1 和 3 ，得到分数 (1+3+2) * min(2,1,4) = 6 。
 * - 选择下标 0 ，2 和 3 ，得到分数 (1+3+2) * min(2,3,4) = 12 。
 * - 选择下标 1 ，2 和 3 ，得到分数 (3+3+2) * min(1,3,4) = 8 。
 * 所以最大分数为 12 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,2,3,1,1], nums2 = [7,5,10,9,6], k = 1
 * 输出：30
 * 解释：
 * 选择下标 2 最优：nums1[2] * nums2[2] = 3 * 10 = 30 是最大可能分数。
 * <p>
 * 提示：
 * <p>
 * n == nums1.length == nums2.length
 * 1 <= n <= 10⁵
 * 0 <= nums1[i], nums2[j] <= 10⁵
 * 1 <= k <= n
 *
 * @author weijiaduo
 * @since 2023/10/13
 */
public class MaxScore {

    /**
     * 思路：最小堆
     * <p>
     * 将两个数组联合起来 {nums1, nums2}，按照 nums2 递减排序
     * <p>
     * 枚举 nums2[i] 作为最小值，则 nums1 只能从 <= i 的索引范围内选取 k 个数
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     * <p>
     * 执行耗时:75 ms,击败了67.18% 的Java用户
     * 内存消耗:62.4 MB,击败了5.11% 的Java用户
     */
    @TestCase(input = {"[1,3,3,2]", "[2,1,3,4]", "3",
            "[4,2,3,1,1]", "[7,5,10,9,6]", "1"},
            output = {"12", "30"})
    public long maxScore(int[] nums1, int[] nums2, int k) {
        // 按照 nums2 递减排序
        int n = nums2.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (i, j) -> nums2[j] - nums2[i]);

        // 利用最小值堆维护 k 个最大值
        long sum = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            int num = nums1[ids[i]];
            minHeap.offer(num);
            sum += num;
        }
        long ans = sum * nums2[ids[k - 1]];
        for (int i = k; i < n; i++) {
            int num = nums1[ids[i]];
            int min = nums2[ids[i]];
            // 当大于栈顶时，替换栈顶元素
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                int tmp = minHeap.poll();
                minHeap.offer(num);
                sum = sum - tmp + num;
            }
            ans = Math.max(sum * min, ans);
        }
        return ans;
    }

}
