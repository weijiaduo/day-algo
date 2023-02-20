package com.wjd.practice.leetcode.stack;

import com.wjd.practice.Solution;

import java.util.*;

/**
 * 6190. 找到所有好下标
 *
 * @author weijiaduo
 * @since 2022/9/25
 */
public class GoodIndices implements Solution<List<Integer>> {

    @Override
    public List<Integer> solve(Object... args) {
        int[] nums = {2, 1, 1, 2};
        int k = 2;
        List<Integer> result = goodIndices(nums, k);
        System.out.println(result);
        return result;
    }

    private List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] upStack = new int[n];
        int[] downStack = new int[n];
        for (int i = 0; i < n; i++) {
            upStack[i] = i;
            downStack[i] = i;
        }

        // 升序
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                int max = stack.pop();
                while (!stack.isEmpty()) {
                    upStack[stack.pop()] = max;
                }
            }
            stack.push(i);
        }
        if (!stack.isEmpty()) {
            int max = stack.pop();
            while (!stack.isEmpty()) {
                upStack[stack.pop()] = max;
            }
        }

        // 降序
        for (int i = n - 1; i >= 0; i--) {
            if (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                int max = stack.pop();
                while (!stack.isEmpty()) {
                    downStack[stack.pop()] = max;
                }
            }
            stack.push(i);
        }
        if (!stack.isEmpty()) {
            int max = stack.pop();
            while (!stack.isEmpty()) {
                downStack[stack.pop()] = max;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = k; i < n - k; i++) {
            if (upStack[i + 1] - i < k || i - downStack[i - 1] < k) {
                continue;
            }
            ans.add(i);
        }

        return ans;
    }

}
