package com.wjd.practice.leetcode.array.combination;

import java.util.Arrays;

/**
 * 473. 火柴拼正方形
 * <p>
 * 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。
 * <p>
 * 你要用 所有的火柴棍 拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
 * <p>
 * 如果你能使这个正方形，则返回 true ，否则返回 false 。
 * <p>
 * 输入: matchsticks = [1,1,2,2,2]
 * 输出: true
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * <p>
 *
 * @since 2022/6/1
 */
public class MakeSquare {

    /**
     * 执行耗时:956 ms,击败了8.75% 的Java用户
     * 内存消耗:39 MB,击败了80.31% 的Java用户
     */
    public boolean makesquare(int[] matchsticks) {
        // 计算周长
        int perimeter = 0;
        for (int matchstick : matchsticks) {
            perimeter += matchstick;
        }
        // 如果不够四边分，直接返回
        if (perimeter == 0 || perimeter % 4 != 0) {
            return false;
        }
        // 正方形边长
        int side = perimeter / 4;

        // 排序，回溯遍历
        Arrays.sort(matchsticks);
        /*
         * 倒排的效率更高
         * 执行耗时:4 ms,击败了71.63% 的Java用户
         * 内存消耗:39.1 MB,击败了65.95% 的Java用户
         */
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        boolean[] visited = new boolean[matchsticks.length];
        return backtrack(matchsticks, visited, side, 0);
    }

    /**
     * 回溯剪枝法
     * <p>
     * 思路：回溯遍历所有火柴，一条边一条边地构造，弄好一条边后再试下一条边
     */
    private boolean backtrack(int[] matchsticks, boolean[] visited, int side, int k) {
        // 寻找还未用到的火柴
        int next = -1;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                next = i;
                break;
            }
        }

        // 刚好拼成一条边
        if (k == side) {
            if (next == -1) {
                // 所有火柴都用完了
                return true;
            } else {
                // 还有火柴没用完，继续遍历下一条边
                return backtrack(matchsticks, visited, side, 0);
            }
        }

        // 回溯遍历所有未遍历的火柴
        for (int i = next; i < visited.length; i++) {
            // 存在重复数字的情况，2222 只能按照 2222，222，22，2 这样遍历，避免循环
            if (visited[i] || i > 0 && matchsticks[i] == matchsticks[i - 1] && !visited[i - 1]) {
                continue;
            }
            // 快速剪枝
            if (matchsticks[i] + k > side) {
                return false;
            }

            visited[i] = true;
            if (backtrack(matchsticks, visited, side, k + matchsticks[i])) {
                return true;
            }
            visited[i] = false;
        }

        return false;
    }


}
