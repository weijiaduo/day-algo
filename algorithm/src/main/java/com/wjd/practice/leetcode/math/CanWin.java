package com.wjd.practice.leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 464. 我能赢吗
 * <p>
 * 给定两个整数 maxChoosableInteger （整数池中可选择的最大数）和 desiredTotal（累计和），
 * <p>
 * 若先出手的玩家是否能稳赢则返回true ，否则返回 false 。
 * <p>
 * 假设两位玩家游戏时都表现 最佳 。
 * <p>
 *
 * @since 2022/5/22
 */
public class CanWin {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0) {
            return true;
        }
        if ((1 + maxChoosableInteger) * (maxChoosableInteger) / 2 < desiredTotal) {
            return false;
        }
        Map<Integer, Boolean> memo = new HashMap<>();
        return deepFind(maxChoosableInteger, 0, desiredTotal, memo);
    }

    /**
     * 赢不了，不会了不会了，直接抄答案
     * <p>
     * 执行耗时:244 ms,击败了19.93% 的Java用户
     * 内存消耗:87.2 MB,击败了9.14% 的Java用户
     */
    public boolean deepFind(int maxChoosableInteger, int usedNumbers, int total, Map<Integer, Boolean> memo) {
        Boolean result = memo.get(usedNumbers);
        if (result != null) {
            return result;
        }

        boolean flag = false;
        for (int i = 0; i < maxChoosableInteger; i++) {
            if (((usedNumbers >> i) & 1) != 0) {
                continue;
            }
            if (i + 1 >= total) {
                flag = true;
                break;
            }
            if (!deepFind(maxChoosableInteger, usedNumbers | (1 << i), total - (i + 1), memo)) {
                flag = true;
                break;
            }
        }
        memo.put(usedNumbers, flag);
        return flag;
    }

}
