package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

/**
 * 1217. 玩筹码
 * <p>
 * 有 n 个筹码。第 i 个筹码的位置是 position[i] 。
 * <p>
 * 我们需要把所有筹码移到同一个位置。在一步中，我们可以将第 i 个筹码的位置从 position[i] 改变为:
 * <p>
 * position[i] + 2 或 position[i] - 2 ，此时 cost = 0
 * position[i] + 1 或 position[i] - 1 ，此时 cost = 1
 * <p>
 * 返回将所有筹码移动到同一位置上所需要的 最小代价 。
 * <p>
 * 输入：position = [2,2,2,3,3]
 * 输出：2
 * 解释：我们可以把位置3的两个筹码移到位置2。每一步的成本为1。总成本= 2。
 *
 * @author weijiaduo
 * @since 2022/7/8
 */
public class MinCostToMoveChips implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[] position = {2, 2, 2, 3, 3};
        int result = minCostToMoveChips(position);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：偶数步移动无需代价，那么就先把偶数位置的筹码都放一起，只多只剩2个位置有筹码，判断哪个位置的筹码最小即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.3 MB,击败了12.71% 的Java用户
     *
     * @param position 筹码
     * @return 最小代价
     */
    private int minCostToMoveChips(int[] position) {
        int odds = 0, evens = 0;
        for (int p : position) {
            if (p % 2 == 0) {
                evens++;
            } else {
                odds++;
            }
        }
        return Math.min(odds, evens);
    }

}
