package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.Arrays;

/**
 * 698. 划分为k个相等的子集
 * <p>
 * 给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *
 * @author weijiaduo
 * @since 2022/9/20
 */
public class CanPartitionKSubsets implements Solution<Boolean> {

    @Override
    public Boolean solve(Object... args) {
        int[] nums = {1, 2, 3, 4};
        int k = 4;
        boolean result = canPartitionKSubsets(nums, k);
        System.out.println(result);
        return result;
    }

    // 搜索数组
    int[] nums;
    // 状态缓存
    boolean[] cache;
    // 目标值
    int target = 0;

    /**
     * 思路：状态压缩 + 记忆搜索
     * <p>
     * 复杂度：O(n * 2^n) 空间 O(2^n)
     * <p>
     * 执行耗时:17 ms,击败了67.38% 的Java用户
     * 内存消耗:40.9 MB,击败了30.37% 的Java用户
     */
    private boolean canPartitionKSubsets(int[] nums, int k) {
        // 判断总和够不够均分
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }

        // 平均值
        int avg = sum / k;

        // 排序，方便剪枝
        Arrays.sort(nums);

        // 最大值比平均值大，不可能均分
        int n = nums.length;
        if (avg < nums[n - 1]) {
            return false;
        }

        // 状态压缩，用 n 位 1 表示
        int state = (1 << n) - 1;
        this.nums = nums;
        this.target = avg;
        this.cache = new boolean[state + 1];
        Arrays.fill(this.cache, true);

        return dfs(state, 0);
    }

    /**
     * 递归遍历
     *
     * @param state 状态
     * @param sum   总和
     * @return true/false
     */
    private boolean dfs(int state, int sum) {
        // 分配成功
        if (state == 0) {
            return true;
        }
        // 记忆状态去重
        if (!cache[state]) {
            return false;
        }

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // num[i] 已被使用
            boolean used = ((state >> i) & 1) == 0;
            if (used) {
                continue;
            }
            // 快速剪枝，排序了后面的比前面大
            if (nums[i] + sum > target) {
                break;
            }

            // 设置第 i 位为 0，标记 num[i] 已被使用
            int nextState = state ^ (1 << i);
            // 加够一个 target 后，重新从 0 开始
            int nextSum = (sum + nums[i]) % target;

            // 递归，验证下一个状态是否可行
            if (dfs(nextState, nextSum)) {
                return true;
            }
        }

        // 状态记忆存储
        cache[state] = false;
        return false;
    }

}
