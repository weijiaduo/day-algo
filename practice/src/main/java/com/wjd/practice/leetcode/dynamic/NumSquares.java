package com.wjd.practice.leetcode.dynamic;

import com.wjd.practice.leetcode.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * 279. 完全平方数
 * <p>
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * <p>
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10⁴
 *
 * @author weijiaduo
 * @since 2023/7/4
 */
public class NumSquares {

    /**
     * 思路：递归，先找到最接近 n 的平方数 k
     * <p>
     * 然后递归寻找 n - k*k 的结果
     * <p>
     * 因为 1 也是平方数，所以肯定能保证最后能有结果
     * <p>
     * 复杂度：时间 O(sqrt(n)^n) 空间 O(n)
     * <p>
     * Time Limit Exceeded
     */
    @TestCase(input = {"12", "13"},
            output = {"3", "2"})
    private int dfs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int ans = n;
        for (int i = (int) Math.sqrt(n); i > 0; i--) {
            ans = Math.min(dfs(n - i * i) + 1, ans);
        }
        return ans;
    }

    /**
     * 思路：记忆化搜索，直接递归可能会有重复的计算，缓存起来
     * <p>
     * 复杂度：时间 O(n*sqrt(n)) 空间 O(n)
     * <p>
     * 执行耗时:283 ms,击败了6.56% 的Java用户
     * 内存消耗:42.5 MB,击败了6.04% 的Java用户
     */
    @TestCase(input = {"12", "13"},
            output = {"3", "2"})
    private int cacheDfs(int n) {
        return cacheDfs(n, new HashMap<>());
    }

    private int cacheDfs(int n, Map<Integer, Integer> cache) {
        Integer ans = cache.get(n);
        if (ans != null) {
            return ans;
        }
        if (n == 0) {
            ans = 0;
        } else if (n == 1) {
            ans = 1;
        } else {
            ans = n;
            for (int i = (int) Math.sqrt(n); i > 0; i--) {
                ans = Math.min(cacheDfs(n - i * i, cache) + 1, ans);
            }
        }
        cache.put(n, ans);
        return ans;
    }

    /**
     * 思路：动态规划，把倒推的递推转成正向的动态规划
     * <p>
     * 复杂度：时间 O(n*sqrt(n)) 空间 O(n)
     * <p>
     * 执行耗时:46 ms,击败了31.61% 的Java用户
     * 内存消耗:40.1 MB,击败了94.53% 的Java用户
     */
    @TestCase(input = {"12", "13"},
            output = {"3", "2"})
    private int dynamic1(int n) {
        // 创建动态数组
        // dp[i] 表示 i 用平方数表示的最少数量
        int[] dp = new int[n + 1];
        // 初始化状态
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        // 状态转移
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }

    /**
     * 官方题解
     * <p>
     * 思路：四平方和定理
     * <p>
     * 四平方和定理证明了任意一个正整数都可以被表示为至多四个正整数的平方和
     * <p>
     * 当且仅当 n != 4^k * (8m + 7) 时，n 最多可用3个正整数的平方和
     * <p>
     * 复杂度：时间 O(sqrt(n)) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.4 MB,击败了99.35% 的Java用户
     */
    @TestCase(input = {"12", "13"},
            output = {"3", "2"})
    private int math(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        if (checkAnswer4(n)) {
            return 4;
        }
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }
        return 3;
    }

    /**
     * 判断是否为完全平方数
     */
    public boolean isPerfectSquare(int x) {
        int y = (int) Math.sqrt(x);
        return y * y == x;
    }

    /**
     * 判断是否能表示为 4^k*(8m+7)
     */
    public boolean checkAnswer4(int x) {
        while (x % 4 == 0) {
            x /= 4;
        }
        return x % 8 == 7;
    }

}
