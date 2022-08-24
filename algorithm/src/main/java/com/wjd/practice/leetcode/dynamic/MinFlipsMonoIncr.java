package com.wjd.practice.leetcode.dynamic;

import com.wjd.practice.Solution;

/**
 * 926. 将字符串翻转到单调递增
 * <p>
 * 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。
 * <p>
 * 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0
 * <p>
 * 返回使 s 单调递增的最小翻转次数。
 * <p>
 * @since 2022/6/11
 */
public class MinFlipsMonoIncr implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        String s = "00011000";
        int result = minFlipsMonoIncr(s);
        System.out.println(result);
        return result;
    }

    /**
     * 动态规划
     *
     * 思路：先得到长度为n的字符串翻转成以0结尾和以1结尾的最小代价，然后根据第 n+1 个字符的情况，也分别计算这2种转换代价
     *
     * 执行耗时:10 ms,击败了81.27% 的Java用户
     * 内存消耗:41.7 MB,击败了84.22% 的Java用户
     */
    public int minFlipsMonoIncr(String s) {
        int minFlipOf0 = 0; // 以0结尾的最小翻转次数
        int minFlipOf1 = 0; // 以1结尾的最小翻转次数
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                // 以1结尾，需翻转1次，把当前的0转成1
                minFlipOf1++;
            } else {
                // 以1结尾有2种情况：
                // 1. 前面已经是1结尾了，此时无需再翻转
                // 2. 前面都是0，此时末尾加上1，也无需翻转
                minFlipOf1 = Math.min(minFlipOf1, minFlipOf0);
                // 以0结尾，需翻转1次，把当前的1转成0
                minFlipOf0++;
            }
        }
        return Math.min(minFlipOf0, minFlipOf1);
    }

}
