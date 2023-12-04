package com.wjd.practice.leetcode.heap;

import com.wjd.practice.TestCase;

import java.util.*;

/**
 * 373. 查找和最小的 K 对数字
 * <p>
 * 给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * <p>
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * <p>
 * 请找到和最小的 k 个数对 (u1,v1), (u2,v2) ... (uk,vk) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * <p>
 * 示例 3:
 * <p>
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 * <p>
 * 提示:
 * <p>
 * 1 <= nums1.length, nums2.length <= 10⁵
 * -10⁹ <= nums1[i], nums2[i] <= 10⁹
 * nums1 和 nums2 均为升序排列
 * 1 <= k <= 10⁴
 *
 * @author weijiaduo
 * @since 2023/12/4
 */
public class KSmallestPairs {

    /**
     * 思路：小顶堆，堆顶就是当前最小的值
     * <p>
     * 复杂度：时间 O(klogk) 空间 O(k)
     * <p>
     * 执行耗时:30 ms,击败了60.03% 的Java用户
     * 内存消耗:57.7 MB,击败了12.80% 的Java用户
     */
    @TestCase(input = {"[1,7,11]", "[2,4,6]", "3",
            "[1,1,2]", "[1,2,3]", "2",
            "[1,2]", "[3]", "3"},
            output = {"[[1,2],[1,4],[1,6]]", "[[1,1],[1,1]]", "[[1,3],[2,3]]"})
    public List<List<Integer>> heap(int[] nums1, int[] nums2, int k) {
        // 小顶堆定义
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);

        // 提前将所有起始索引添加到堆中，用于后面数对去重
        int m = nums1.length, n = nums2.length;
        for (int i = 0; i < m && i < k; i++) {
            queue.offer(new int[]{i, 0});
        }

        // 找出最小的 k 个数对
        List<List<Integer>> ans = new ArrayList<>(k);
        while (k-- > 0 && !queue.isEmpty()) {
            int[] pair = queue.poll();
            ans.add(Arrays.asList(nums1[pair[0]], nums2[pair[1]]));
            if (pair[1] + 1 < n) {
                // 只对 pair[1] 索引进行增加，避免重复数对
                queue.offer(new int[]{pair[0], pair[1] + 1});
            }
        }
        return ans;
    }

}
