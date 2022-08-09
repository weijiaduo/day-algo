package com.wjd.practice.leetcode.array;

import com.wjd.practice.leetcode.Solution;

/**
 * 565. 数组嵌套
 * <p>
 * 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，
 * <p>
 * 其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
 * <p>
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 * <p>
 * 输入: A = [5,4,0,3,1,6,2]
 * 输出: 4
 * 解释:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 * <p>
 * 其中一种最长的 S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 *
 * @author weijiaduo
 * @since 2022/7/17
 */
public class ArrayNesting implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        int result = arrayNesting(nums);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：每次找未访问过的位置遍历，直到遇到访问过的节点
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行用时：4 ms, 在所有 Java 提交中击败了 79.91% 的用户
     * 内存消耗：50 MB, 在所有 Java 提交中击败了 79.17% 的用户
     *
     * @param nums 数组
     * @return 最大集合的大小
     */
    private int arrayNesting(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }

        int ans = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            // 遍历所有未访问过的节点
            int count = 0, k = i;
            for (; !visited[k]; k = nums[k]) {
                count++;
                visited[k] = true;
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }

    /**
     * 官解：原地修改数组，不适用额外空间。正常置于范围是 [0,n-1]，修改数组值为阈值外的值，比如n，可当作被访问过了
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行用时：3 ms, 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗：57.8 MB, 在所有 Java 提交中击败了 10.94% 的用户
     *
     * @param nums 数组
     * @return 最大集合的大小
     */
    public int arrayNesting2(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            while (nums[i] < n) {
                int num = nums[i];
                nums[i] = n;
                i = num;
                ++cnt;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

}
