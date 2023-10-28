package com.wjd.practice.leetcode.greedy;

import com.wjd.practice.TestCase;

/**
 * 134. 加油站
 * <p>
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
 * <p>
 * 你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。
 * <p>
 * 如果存在解，则 保证 它是 唯一 的。
 * <p>
 * 示例 1:
 * <p>
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * <p>
 * 示例 2:
 * <p>
 * 输入: gas = [2,3,4], cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 * <p>
 * 提示:
 * <p>
 * gas.length == n
 * cost.length == n
 * 1 <= n <= 10⁵
 * 0 <= gas[i], cost[i] <= 10⁴
 *
 * @author weijiaduo
 * @since 2022/6/27
 */
public class CanCompleteCircuit {

    /**
     * 思路：最小差值前缀和，
     * <p>
     * 当差值前缀和最小时，表示此时最缺油，这个站应该是最后一站，等别的站救助
     * <p>
     * 复杂度：时间 O(n) ，空间 O(1)
     * <p>
     * 执行耗时:2 ms,击败了89.17% 的Java用户
     * 内存消耗:54 MB,击败了59.06% 的Java用户
     */
    @TestCase(input = {"[1,2,3,4,5]", "[3,4,5,1,2]", "[2,3,4]", "[3,4,3]"},
            output = {"3", "-1"})
    public int prefix(int[] gas, int[] cost) {
        int min = Integer.MAX_VALUE;
        int sum = 0, index = -1;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            if (sum <= min) {
                min = sum;
                index = i;
            }
        }
        return sum < 0 ? -1 : (index + 1) % n;
    }

    /**
     * 思路：从前往后，逐个遍历判断是否可环绕一周，
     * <p>
     * 复杂度：时间 O(n) ，空间 O(1)
     * <p>
     * 执行耗时:3 ms,击败了21.24% 的Java用户
     * 内存消耗:61.1 MB,击败了31.91% 的Java用户
     */
    @TestCase(input = {"[1,2,3,4,5]", "[3,4,5,1,2]", "[2,3,4]", "[3,4,3]"},
            output = {"3", "-1"})
    public int greedy(int[] gas, int[] cost) {
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
