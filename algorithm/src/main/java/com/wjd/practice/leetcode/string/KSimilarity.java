package com.wjd.practice.leetcode.string;

import com.wjd.practice.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 854. 相似度为 K 的字符串
 * <p>
 * 对于某些非负整数 k ，如果交换 s1 中两个字母的位置恰好 k 次，能够使结果字符串等于 s2 ，则认为字符串 s1 和 s2 的 相似度为 k 。
 * <p>
 * 给你两个字母异位词 s1 和 s2 ，返回 s1 和 s2 的相似度 k 的最小值。
 * <p>
 * 输入：s1 = "ab", s2 = "ba"
 * 输出：1
 *
 * @author weijiaduo
 * @since 2022/9/21
 */
public class KSimilarity implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        String s1 = "abccaacceecdeea";
        String s2 = "bcaacceeccdeaae";
        // String s1 = "abc";
        // String s2 = "bca";
        int result = kSimilarity(s1, s2);
        System.out.println(result);
        return result;
    }

    Map<Long, Integer> cache;


    private int kSimilarity(String s1, String s2) {
        // return stateCompress(s1, s2);
        backtrace(s1.toCharArray(), s2.toCharArray(), 0, 0);
        return ans;
    }

    int ans = Integer.MAX_VALUE;

    /**
     * 思路：回溯法，每次换位都确保有 1 位能够在正确位置上，从左往右逐个换位
     * <p>
     * 执行耗时:21 ms,击败了81.61% 的Java用户
     * 内存消耗:39.1 MB,击败了98.85% 的Java用户
     */
    private void backtrace(char[] s1, char[] s2, int index, int cnt) {
        // 快速剪枝，交换次数比最小值大了
        if (cnt >= ans) {
            return;
        }

        // 2 个字符串已经相等了
        if (index >= s1.length) {
            ans = cnt;
            return;
        }

        // 当前位相同，无需交换，进行下一步
        if (s1[index] == s2[index]) {
            backtrace(s1, s2, index + 1, cnt);
            return;
        }

        int n = s1.length;
        for (int i = index + 1; i < n; i++) {
            // 回溯交换，把 index 的字符换位到 2 者相等
            if (s1[i] == s2[index] && s1[i] != s2[i]) {
                swap(s1, index, i);
                backtrace(s1, s2, index + 1, cnt + 1);
                swap(s1, i, index);

                /*
                 * 交换后 2 个位置都相等
                 * 已经是最优解，无需遍历下一种情况
                 *
                 * 这个地方的剪枝非常重要
                 * 执行耗时:2 ms,击败了92.53% 的Java用户
                 * 内存消耗:39.2 MB,击败了93.10% 的Java用户
                 */
                if (s1[index] == s2[i]) {
                    break;
                }
            }
        }
    }

    private void swap(char[] sc, int i, int j) {
        char temp = sc[i];
        sc[i] = sc[j];
        sc[j] = temp;
    }

    /**
     * 思路：状态压缩 + 记忆化搜索
     * <p>
     * 每次对比字符串耗时比较长，而且还要交换字符位置，需要大量操作字符串
     * <p>
     * 字符范围限制为 a~f 这6个，且字符长度 <=20
     * <p>
     * 6个字符刚好可以用 3bit 表示，20 * 3 = 60bit，刚好可以用 long 长整数表示
     * <p>
     * 所以可以通过压缩状态，用一个 long 表示一个字符串
     * <p>
     * 复杂度：时间 O(n * n!) 空间 O(n!)
     * <p>
     * 执行耗时:45 ms,击败了73.56% 的Java用户
     * 内存消耗:47.1 MB,击败了44.25% 的Java用户
     */
    private int stateCompress(String s1, String s2) {
        // 压缩状态，将字符串改用 long 表示
        long l1 = 0, l2 = 0;
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            char ch1 = s1.charAt(i);
            l1 = l1 | ((long) (ch1 - 'a') << (i * 3));
            char ch2 = s2.charAt(i);
            l2 = l2 | ((long) (ch2 - 'a') << (i * 3));
        }
        // 记忆缓存，记录已访问状态
        cache = new HashMap<>();

        return dfs(l1, l2, 0, n);
    }

    /**
     * 递归遍历
     */
    private int dfs(long l1, long l2, int index, int n) {
        if (index >= n) {
            return -1;
        }
        // 找到结果
        if (l1 == l2) {
            return 0;
        }
        // 状态去重
        int c = cache.getOrDefault(l1, -1);
        if (c != -1) {
            return c;
        }

        long indexMask = (7L << (index * 3));
        // 从 l2 中取出 index 的值
        long l2IndexValue = (l2 & indexMask) >> (index * 3);
        // 从 l1 中取出 index 的值
        long l1IndexValue = (l1 & indexMask) >> (index * 3);

        // 不交换 index 的情况
        if (l1IndexValue == l2IndexValue) {
            return dfs(l1, l2, index + 1, n);
        }

        int min = -1;
        for (int i = index + 1; i < n; i++) {
            // 从 l1 中取出 i 的值
            long iMask = (7L << (i * 3));
            long iValue = (l1 & iMask) >> (i * 3);
            if (iValue != l2IndexValue) {
                continue;
            }

            // 交换 index 和 i 的值
            long newL1 = l1;
            newL1 = (newL1 & ~iMask) | (l1IndexValue << (i * 3));
            newL1 = (newL1 & ~indexMask) | (iValue << (index * 3));

            // 验证下一种状态
            int ret = dfs(newL1, l2, index + 1, n);
            if (ret != -1) {
                // 需加上和 index 交换的 1 次
                min = min < 0 ? ret + 1 : Math.min(min, ret + 1);
            }
        }

        // 记忆化存储状态
        cache.put(l1, min);
        return min;
    }


}
