package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 857. 雇佣 K 名工人的最低成本
 * <p>
 * 有 n 名工人。
 * <p>
 * 给定两个数组 quality 和 wage ，其中，quality[i] 表示第 i 名工人的工作质量，其最低期望工资为 wage[i]。
 * <p>
 * 现在我们想雇佣 k 名工人组成一个工资组。在雇佣 一组 k 名工人时，我们必须按照下述规则向他们支付工资：
 * <p>
 * 对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。
 * <p>
 * 工资组中的每名工人至少应当得到他们的最低期望工资。
 * <p>
 * 给定整数 k ，返回 组成满足上述条件的付费群体所需的最小金额 。在实际答案的 10⁻⁵ 以内的答案将被接受。
 * <p>
 * 输入： quality = [10,20,5], wage = [70,50,30], k = 2
 * 输出： 105.00000
 * 解释： 我们向 0 号工人支付 70，向 2 号工人支付 35。
 *
 * @author weijiaduo
 * @since 2022/9/11
 */
public class MinCostToHireWorkers implements Solution<Double> {

    @Override
    public Double solve(Object... args) {
        int[] quality = {10, 20, 5};
        int[] wage = {70, 50, 30};
        int k = 2;
        double result = minCostToHIreWorks(quality, wage, k);
        System.out.println(result);
        return result;
    }

    static class Node {
        int index;
        double quality;

        public Node(int index, int quality) {
            this.index = index;
            this.quality = quality;
        }
    }

    /**
     * 思路：贪心原则，要求最低成本，那么 k 个人里肯定有一个人拿最低工资。
     * <p>
     * 假设 x 拿了最低工资，那么总成本 sumW = wage[x] / quality[x] * sumQ。
     * <p>
     * 其中，sumW = k个人的工资和，sumQ = k个人的工作质量和。
     * <p>
     * 其他人的工资分别是 salary[i] = sumW * quality[i] / sumQ。
     * <p>
     * 题目要求 salary[i] >= wage[i]，代入公式后得到：
     * <p>
     * wage[x] / quality[x] >= wage[i] / quality[i]
     * <p>
     * 所以在 k 个人中拿最低工资的那个，就是 k 个人里面 wage[i]/quality[i] 最大的那个。
     * <p>
     * 先按照 wage[x]/quality[x] 排序，然后枚举每个人拿基本工资的情况去判断最低成本。
     *
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(n)
     * <p>
     * 执行耗时:23 ms,击败了100.00% 的Java用户
     * 内存消耗:41.8 MB,击败了91.26% 的Java用户
     */
    private double minCostToHIreWorks(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] indexes = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        // 按 wage[i]/quality[i] 从小到大排序
        Arrays.sort(indexes, (a, b) -> wage[a] * quality[b] - wage[b] * quality[a]);

        // 前 k-1 个人不可能拿最低工资，最低工资只能是 wage[i]/quality[i] 最大的那个
        // 最大值堆负责维护遍历过的所有人中，前 k-1 小的质量
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int sumQ = 0;
        for (int i = 0; i < k - 1; i++) {
            int q = quality[indexes[i]];
            sumQ += q;
            queue.offer(q);
        }

        // 枚举每个人拿最低工资的情况
        double ans = Double.MAX_VALUE;
        for (int x = k - 1; x < n; x++) {
            // i 号工人拿最低工资
            int i = indexes[x];

            // 加上 i 号工人的质量
            sumQ += quality[i];
            queue.offer(quality[i]);

            // 总的工资和
            double sumW = 1.0 * wage[i] / quality[i] * sumQ;
            ans = Math.min(sumW, ans);

            // 已遍历过的前 k-1 小的质量和 sumQ
            sumQ -= queue.poll();
        }
        return ans;
    }

}
