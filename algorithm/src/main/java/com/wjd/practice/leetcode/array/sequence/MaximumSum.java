package com.wjd.practice.leetcode.array.sequence;

/**
 * 1186. 删除一次得到子数组最大和
 * <p>
 * 给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。
 * <p>
 * 换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），
 * <p>
 * （删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。
 * <p>
 * 注意，删除一个元素后，子数组 不能为空。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,-2,0,3]
 * 输出：4
 * 解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [1,-2,-2,3]
 * 输出：3
 * 解释：我们直接选出 [3]，这就是最大和。
 * <p>
 * 示例 3：
 * <p>
 * 输入：arr = [-1,-1,-1,-1]
 * 输出：-1
 * 解释：最后得到的子数组不能为空，所以我们不能选择 [-1] 并从中删去 -1 来得到 0。
 * <p>
 * 我们应该直接选择 [-1]，或者选择 [-1, -1] 再从中删去一个 -1。
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10⁵
 * -10⁴ <= arr[i] <= 10⁴
 *
 * @author weijiaduo
 * @since 2023/6/27
 */
public class MaximumSum {

    public int maximumSum(int[] arr) {
        return dynamic2(arr);
        // return dynamic1(arr);
    }

    /**
     * 官方题解
     * <p>
     * 思路：动态规划
     * <p>
     * 以 i 为结尾的子数组最大值和可以分为 2 种情况
     * <p>
     * 1、删除了0个数字的最大和 dp[i][0] = sum(arr[j..i])
     * <p>
     * 2、删除了1个数字的最大和 dp[i][1] = sum(arr[j..i]) - arr[k]
     * <p>
     * 它们的递推公式是：
     * <p>
     * 1、dp[i][0] = max(dp[i - 1][0] + arr[i], 0)
     * <p>
     * 2、dp[i][1] = max(dp[i - 1][0], dp[i - 1][1] + arr[i])
     * <p>
     * 然后根据递推公式算出最后的结果
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:10 ms,击败了31.42% 的Java用户
     * 内存消耗:50.2 MB,击败了73.65% 的Java用户
     */
    private int dynamic2(int[] arr) {
        int ans;

        // 创建动态数组
        int n = arr.length;
        int[][] dp = new int[n][2];

        // 初始化状态
        dp[0][0] = arr[0];
        dp[0][1] = 0;

        // 状态转移
        ans = arr[0];
        for (int i = 1; i < n; i++) {
            // 继续扩展子数组/重新开始子数组
            dp[i][0] = Math.max(dp[i - 1][0], 0) + arr[i];
            // 删除当前的数字/删除之前的数字
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
            ans = Math.max(Math.max(dp[i][0], dp[i][1]), ans);
        }
        return ans;
    }

    /**
     * 官方题解
     * <p>
     * 思路：动态规划，滚动数组，状态转移只和上一轮结果有关，不需要数组维护
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:5 ms,击败了88.89% 的Java用户
     * 内存消耗:50.5 MB,击败了55.55% 的Java用户
     */
    private int dynamic1(int[] arr) {
        // dp0 表示 arr[i..j] 删除了0个数字后的子数组最大和
        // dp1 表示 arr[i..j] 删除了1个数字后的子数组最大和
        int dp0 = arr[0], dp1 = 0, res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // 删除当前的数字/删除之前的数字
            dp1 = Math.max(dp0, dp1 + arr[i]);
            // 继续扩展子数组/重新开始子数组
            dp0 = Math.max(dp0, 0) + arr[i];
            res = Math.max(res, Math.max(dp0, dp1));
        }
        return res;
    }

}
