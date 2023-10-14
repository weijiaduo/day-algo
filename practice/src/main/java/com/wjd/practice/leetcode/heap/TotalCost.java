package com.wjd.practice.leetcode.heap;

import com.wjd.practice.leetcode.TestCase;

import java.util.PriorityQueue;

/**
 * 2462. 雇佣 K 位工人的总代价
 * <p>
 * 给你一个下标从 0 开始的整数数组 costs ，其中 costs[i] 是雇佣第 i 位工人的代价。
 * <p>
 * 同时给你两个整数 k 和 candidates 。我们想根据以下规则恰好雇佣 k 位工人：
 * <p>
 * 总共进行 k 轮雇佣，且每一轮恰好雇佣一位工人。
 * <p>
 * 在每一轮雇佣中，从最前面 candidates 和最后面 candidates 人中选出代价最小的一位工人，
 * <p>
 * 如果有多位代价相同且最小的工人，选择下标更小的一位工人。
 * <p>
 * 比方说，costs = [3,2,7,7,1,2] 且 candidates = 2 ，第一轮雇佣中，我们选择第 4 位工人，因为他的代价最小 [3,2,
 * 7,7,1,2] 。
 * 第二轮雇佣，我们选择第 1 位工人，因为他们的代价与第 4 位工人一样都是最小代价，而且下标更小，[3,2,7,7,2] 。
 * <p>
 * 注意每一轮雇佣后，剩余工人的下标可能会发生变化。
 * <p>
 * 如果剩余员工数目不足 candidates 人，那么下一轮雇佣他们中代价最小的一人，
 * <p>
 * 如果有多位代价相同且最小的工人，选择下标更小的一位工人。一位工人只能被选择一次。
 * <p>
 * 返回雇佣恰好 k 位工人的总代价。
 * <p>
 * 示例 1：
 * <p>
 * 输入：costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
 * 输出：11
 * 解释：我们总共雇佣 3 位工人。总代价一开始为 0 。
 * - 第一轮雇佣，我们从 [17,12,10,2,7,2,11,20,8] 中选择。最小代价是 2 ，有两位工人，我们选择下标更小的一位工人，即第 3 位工人
 * 。总代价是 0 + 2 = 2 。
 * - 第二轮雇佣，我们从 [17,12,10,7,2,11,20,8] 中选择。最小代价是 2 ，下标为 4 ，总代价是 2 + 2 = 4 。
 * - 第三轮雇佣，我们从 [17,12,10,7,11,20,8] 中选择，最小代价是 7 ，下标为 3 ，总代价是 4 + 7 = 11 。注意下标为 3
 * 的工人同时在最前面和最后面 4 位工人中。
 * 总雇佣代价是 11 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：costs = [1,2,4,1], k = 3, candidates = 3
 * 输出：4
 * 解释：我们总共雇佣 3 位工人。总代价一开始为 0 。
 * - 第一轮雇佣，我们从 [1,2,4,1] 中选择。最小代价为 1 ，有两位工人，我们选择下标更小的一位工人，即第 0 位工人，总代价是 0 + 1 = 1
 * 。注意，下标为 1 和 2 的工人同时在最前面和最后面 3 位工人中。
 * - 第二轮雇佣，我们从 [2,4,1] 中选择。最小代价为 1 ，下标为 2 ，总代价是 1 + 1 = 2 。
 * - 第三轮雇佣，少于 3 位工人，我们从剩余工人 [2,4] 中选择。最小代价是 2 ，下标为 0 。总代价为 2 + 2 = 4 。
 * 总雇佣代价是 4 。
 * <p>
 * 提示：
 * <p>
 * 1 <= costs.length <= 105
 * 1 <= costs[i] <= 10⁵
 * 1 <= k, candidates <= costs.length
 *
 * @author weijiaduo
 * @since 2023/10/14
 */
public class TotalCost {

    /**
     * 思路：最小值堆
     * <p>
     * 分别对左右两边的 candidates 建立最小值堆
     * <p>
     * 每次从这两个堆里面获取最小值即可
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     * <p>
     * 执行耗时:46 ms,击败了74.83% 的Java用户
     * 内存消耗:56.7 MB,击败了12.30% 的Java用户
     */
    @TestCase(input = {"[17,12,10,2,7,2,11,20,8]", "3", "4",
            "[1,2,4,1]", "3", "3",
            "[10,1,11,10]", "2", "1"},
            output = {"11", "4", "11"})
    public long heap(int[] costs, int k, int candidates) {
        int n = costs.length;
        int left = Math.min(candidates - 1, n - 1);
        // 避免两个堆之间相交，不相交的话就不需要处理重复值的问题
        int right = Math.max(Math.max(n - candidates, 0), left + 1);

        PriorityQueue<Integer> lh = new PriorityQueue<>();
        PriorityQueue<Integer> rh = new PriorityQueue<>();
        for (int i = 0; i <= left; i++) {
            lh.offer(costs[i]);
        }
        for (int i = n - 1; i >= right; i--) {
            rh.offer(costs[i]);
        }

        long total = 0;
        for (int i = 0; i < k; i++) {
            int lc = lh.isEmpty() ? Integer.MAX_VALUE : lh.peek();
            int rc = rh.isEmpty() ? Integer.MAX_VALUE : rh.peek();
            if (lc <= rc) {
                // 注意相等时优先取下标更小的
                total += lc;
                lh.poll();
                // 补充堆元素
                if (left + 1 < right) {
                    lh.offer(costs[++left]);
                }
            } else {
                total += rc;
                rh.poll();
                // 补充堆元素
                if (left + 1 < right) {
                    rh.offer(costs[--right]);
                }
            }
        }
        return total;
    }

}
