package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

/**
 * 134. 加油站
 * <p>
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 * <p>
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 *
 * @author weijiaduo
 * @since 2022/6/27
 */
public class CanCompleteCircuit implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        int result = canCompleteCircuit(gas, cost);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：从前往后，逐个遍历判断是否可环绕一周，
     * <p>
     * 复杂度：时间 O(n) ，空间 O(1)
     * <p>
     * 执行耗时:3 ms,击败了21.24% 的Java用户
     * 内存消耗:61.1 MB,击败了31.91% 的Java用户
     */
    private int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; ) {
            boolean flag = true;
            int remain = 0;
            for (int j = 0; j < n; j++) {
                int k = (i + j) % n;
                remain = remain + gas[k] - cost[k];
                if (remain >= 0) {
                    continue;
                }
                // 回头了，也就不可能再走完一周了
                // 因为遍历是从头开始的，之前走不完，那回头了依旧不行
                if (i > k) {
                    return -1;
                }
                // 因为 i 到不了 k+1，那么 [i+1, k] 这些
                // 肯定也都到不了 k+1，所以下一个从 k+1 开始
                i = k + 1;
                flag = false;
                break;
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

}
