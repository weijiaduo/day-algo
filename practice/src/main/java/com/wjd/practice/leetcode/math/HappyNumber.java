package com.wjd.practice.leetcode.math;

import com.wjd.practice.TestCase;

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
 * <p>
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * <p>
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * <p>
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 1² + 9² = 82
 * 8² + 2² = 68
 * 6² + 8² = 100
 * 1² + 0² + 0² = 1
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2³¹ - 1
 *
 * @author weijiaduo
 * @since 2022/7/13
 */
public class HappyNumber {

    /**
     * 思路：暴力法，按照规则处理，使用哈希表判断循环
     * <p>
     * 复杂度：时间 O(logn) 空间 O(logn)
     * <p>
     * 执行耗时:1 ms,击败了79.06% 的Java用户
     * 内存消耗:39.1 MB,击败了9.48% 的Java用户
     */
    @TestCase(input = {"19", "2"},
            output = {"true", "false"})
    public boolean hashset(int n) {
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
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39 MB,击败了16.91% 的Java用户
     */
    @TestCase(input = {"19", "2"},
            output = {"true", "false"})
    public boolean fastSlowPoint(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }

    private static final Set<Integer> cycleMembers =
            new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));

    /**
     * 官解：数学法，所有情况里面只有一种循环，其他都是回到1
     * <p>
     * 复杂度：时间 O(logn) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了79.06% 的Java用户
     * 内存消耗:38.8 MB,击败了30.93% 的Java用户
     */
    @TestCase(input = {"19", "2"},
            output = {"true", "false"})
    public boolean math(int n) {
        while (n != 1 && !cycleMembers.contains(n)) {
            n = getNext(n);
        }
        return n == 1;
    }

    /**
     * 下一个快乐数
     *
     * @param n 当前数字
     * @return 下一个快乐数
     */
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
