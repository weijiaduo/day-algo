package com.wjd.practice.leetcode.array;

import com.wjd.practice.Solution;

import java.util.Arrays;

/**
 * 1652. 拆炸弹
 * <p>
 * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
 * <p>
 * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
 * <p>
 * 如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
 * 如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
 * 如果 k == 0 ，将第 i 个数字用 0 替换。
 * <p>
 * 由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
 * <p>
 * 给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
 * <p>
 * 输入：code = [5,7,1,4], k = 3
 * 输出：[12,10,16,13]
 * 解释：每个数字都被接下来 3 个数字之和替换。解密后的密码为 [7+1+4, 1+4+5, 4+5+7, 5+7+1]。注意到数组是循环连接的。
 *
 * @author weijiaduo
 * @since 2022/9/24
 */
public class Decrypt implements Solution<int[]> {

    @Override
    public int[] solve(Object... args) {
        int[] code = {5, 7, 1, 4};
        int k = 3;
        int[] result = decrypt(code, k);
        System.out.println(Arrays.toString(result));
        return result;
    }

    /**
     * 思路：滑动窗口，直接模拟
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.4 MB,击败了58.93% 的Java用户
     */
    private int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) {
            return ans;
        }

        // 窗口区间
        int l, r;
        if (k > 0) {
            l = 1;
            r = k;
        } else {
            l = n + k;
            r = n - 1;
        }

        // 滑动窗口
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += code[i];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = sum;
            sum -= code[l];
            l = (l + 1) % n;
            r = (r + 1) % n;
            sum += code[r];
        }
        return ans;
    }

}
