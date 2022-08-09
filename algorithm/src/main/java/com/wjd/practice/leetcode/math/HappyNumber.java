package com.wjd.practice.leetcode.math;

import com.wjd.practice.leetcode.Solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * <p>
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」 定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * <p>
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 1² + 9² = 82
 * 8² + 2² = 68
 * 6² + 8² = 100
 * 1² + 0² + 0² = 1
 *
 * @author weijiaduo
 * @since 2022/7/13
 */
public class HappyNumber implements Solution<Boolean> {

    @Override
    public Boolean solve(Object... args) {
        int n = 2;
        boolean result = isHappy(n);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：暴力法，按照规则处理，使用哈希表判断循环
     * <p>
     * 执行耗时:1 ms,击败了79.06% 的Java用户
     * 内存消耗:39.1 MB,击败了9.48% 的Java用户
     */
    private boolean isHappy(int n) {
        Set<Integer> numbers = new HashSet<>();
        int num = n;
        while (!numbers.contains(num)) {
            numbers.add(num);
            num = getNext(num);
            if (num == 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 官解：快慢指针，最终的计算结果不是1，就是进入循环，用快慢指针识别环
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39 MB,击败了16.91% 的Java用户
     */
    private boolean isHappy2(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }

    private static Set<Integer> cycleMembers =
            new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));

    /**
     * 官解：数学法，所有情况里面只有一种循环，其他都是回到1
     * <p>
     * 执行耗时:1 ms,击败了79.06% 的Java用户
     * 内存消耗:38.8 MB,击败了30.93% 的Java用户
     */
    public boolean isHappy3(int n) {
        while (n != 1 && !cycleMembers.contains(n)) {
            n = getNext(n);
        }
        return n == 1;
    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

}
