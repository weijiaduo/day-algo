package com.wjd.practice.leetcode.string.statistics;

import com.wjd.practice.TestCase;

/**
 * 1419. 数青蛙
 * <p>
 * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。
 * <p>
 * 由于同一时间可以有多只青蛙呱呱作响，所以croakOfFrogs 中会混合多个 “croak” 。
 * <p>
 * 请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 * <p>
 * 要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。
 * <p>
 * 如果没有输出全部五个字母，那么它就不会发出声音。
 * <p>
 * 如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：croakOfFrogs = "croakcroak"
 * 输出：1
 * 解释：一只青蛙 “呱呱” 两次
 * <p>
 * 示例 2：
 * <p>
 * 输入：croakOfFrogs = "crcoakroak"
 * 输出：2
 * 解释：最少需要两只青蛙，“呱呱” 声用黑体标注
 * 第一只青蛙 "crcoakroak"
 * 第二只青蛙 "crcoakroak"
 * <p>
 * 示例 3：
 * <p>
 * 输入：croakOfFrogs = "croakcrook"
 * 输出：-1
 * 解释：给出的字符串不是 "croak" 的有效组合。
 * <p>
 * 提示：
 * <p>
 * 1 <= croakOfFrogs.length <= 10⁵
 * 字符串中的字符只有 'c', 'r', 'o', 'a' 或者 'k'
 *
 * @author weijiaduo
 * @since 2023/12/10
 */
public class MinNumberOfFrogs {

    /**
     * 思路：计数
     * <p>
     * 分别对 croak 这 5 个字符进行计数，并且保证后面字符的数量不能超过前面字符的数量
     * <p>
     * 比如 count(c) >= count(r) >= count(o) >= count(a) >= count(k)
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:7 ms,击败了90.52% 的Java用户
     * 内存消耗:42.9 MB,击败了16.67% 的Java用户
     */
    @TestCase(input = {"croakcroak", "crcoakroak", "croakcrook"},
            output = {"1", "2", "-1"})
    public int count(String croakOfFrogs) {
        int count = 0;
        int[] cnt = new int[5];
        int n = croakOfFrogs.length();
        for (int i = 0; i < n; i++) {
            char ch = croakOfFrogs.charAt(i);
            if (ch == 'c') {
                cnt[0]++;
                if (count > 0) {
                    // 复用青蛙
                    count--;
                }
            } else if (ch == 'r') {
                cnt[1]++;
                if (cnt[1] > cnt[0]) {
                    return -1;
                }
            } else if (ch == 'o') {
                cnt[2]++;
                if (cnt[2] > cnt[1]) {
                    return -1;
                }
            } else if (ch == 'a') {
                cnt[3]++;
                if (cnt[3] > cnt[2]) {
                    return -1;
                }
            } else if (ch == 'k') {
                cnt[4]++;
                if (cnt[4] > cnt[3]) {
                    return -1;
                }
                // 增加青蛙
                count++;
            }
        }

        // 每个字符的数量要保持相同
        if (cnt[0] != cnt[1] || cnt[1] != cnt[2]
            || cnt[2] != cnt[3] || cnt[3] != cnt[4]) {
            return -1;
        }

        return count;
    }

}
