package com.wjd.practice.recruit.bytedance;

import com.wjd.practice.TestCase;

import java.util.Arrays;

/**
 * 给定一个数 n 如 23121。给定一组数字 a 如 [2 4 9]
 * <p>
 * 求由 a 中元素组成的小于 n 的最大数
 *
 * @author weijiaduo
 * @since 2023/10/31
 */
public class MaxNumber {

    /**
     * 备选数字，升序
     */
    int[] digits;
    /**
     * 最大值，排除在外
     */
    int max = 0;
    /**
     * 最终结果
     */
    int ans = 0;

    @TestCase(input = {"23121", "[2,4,9]",
            "23121", "[1,2,3]",
            "23121", "[4,9]"},
            output = {"22999", "23113", "9999"})
    public int dfs(int n, int[] a) {
        char[] s = String.valueOf(n).toCharArray();
        Arrays.sort(a);

        digits = a;
        max = n;
        ans = 0;
        dfs(s, 0, true, false, 0);
        return ans;
    }

    /**
     * 遍历所有小于 s 的数字
     *
     * @param nums    数字
     * @param i       当前位置
     * @param isLimit 是否限制当前位置的值
     * @param isNum   是否已经有选择数字了
     * @param sum     当前数字
     */
    private void dfs(char[] nums, int i, boolean isLimit, boolean isNum, int sum) {
        if (i == nums.length) {
            if (sum < max) {
                ans = Math.max(sum, ans);
            }
            return;
        }

        // 还没有数字
        if (!isNum) {
            dfs(nums, i + 1, false, false, sum);
        }

        // 当前位置的数字上限
        int up = isLimit ? nums[i] - '0' : digits[digits.length - 1];
        for (int d : digits) {
            if (d > up) {
                break;
            }
            int t = sum * 10 + d;
            // isLimit：如果当前受到 n 的约束，且填的数字等于上限，那么后面仍然会受到 n 的约束
            // isNum：因为选择了数字，所以是 true
            dfs(nums, i + 1, isLimit && digits[i] == up, true, t);
        }
    }

}
