package com.wjd.practice.leetcode.array.statistics;

import com.wjd.practice.TestCase;

import java.util.Arrays;

/**
 * 274. H指数
 * <p>
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 * <p>
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且每篇论文 至少 被引用 h 次。
 * <p>
 * 如果 h 有多种可能的值，h 指数 是其中最大的那个。
 * <p>
 * 示例 1：
 * <p>
 * 输入：citations = [3,0,6,1,5]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 * 由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
 * <p>
 * 示例 2：
 * <p>
 * 输入：citations = [1,3,1]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * n == citations.length
 * 1 <= n <= 5000
 * 0 <= citations[i] <= 1000
 *
 * @author weijiaduo
 * @since 2022/9/6
 */
public class HIndex {

    /**
     * 思路：排序，从小到大遍历，逐个判断引用次数大于等于后面的论文篇数
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(1)
     * <p>
     * 执行耗时:1 ms,击败了78.08% 的Java用户
     * 内存消耗:39.5 MB,击败了50.11% 的Java用户
     */
    @TestCase(input = {"[3,0,6,1,5]", "[1,3,1]"},
            output = {"3", "1"})
    public int sort(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0, i = n - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

    /**
     * 思路：计数排序，记录每种引用数量的论文数量，倒序找到第一个满足条件的h值
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.1 MB,击败了93.23% 的Java用户
     */
    @TestCase(input = {"[3,0,6,1,5]", "[1,3,1]"},
            output = {"3", "1"})
    public int countSort(int[] citations) {
        // 统计各种引用数量的论文数量
        int n = citations.length;
        int[] count = new int[n + 1];
        for (int c : citations) {
            if (c > n) {
                // 大于 n 的都归类到 n
                count[n]++;
            } else {
                count[c]++;
            }
        }

        // 论文数量
        int num = 0;
        for (int h = n; h >= 0; h--) {
            num += count[h];
            if (num >= h) {
                return h;
            }
        }
        return 0;
    }

    /**
     * 思路：二分法，h 范围是 [0, n]，采用二分法分割范围
     * <p>
     * 每次统计数组内 >= h 的数量是否 >= h
     * <p>
     * 复杂度：时间 O(nlogn) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.5 MB,击败了14.48% 的Java用户
     */
    @TestCase(input = {"[3,0,6,1,5]", "[1,3,1]"},
            output = {"3", "1"})
    public int binary(int[] citations) {
        int lp = 0, rp = citations.length;
        while (lp < rp) {
            // 当 lp 可能不变时，采用向上取整
            // 当 rp 可能不变时，采用向下取整
            // 向上取整，避免边界问题
            int mp = rp - (rp - lp) / 2;
            if (check(citations, mp)) {
                lp = mp;
            } else {
                rp = mp - 1;
            }
        }
        return lp;
    }

    /**
     * 检查引用次数 >= h 的论文数量是否 >= h
     *
     * @param citations 论文引用次数
     * @param h         引用次数
     * @return true/false
     */
    private boolean check(int[] citations, int h) {
        int cnt = 0;
        int n = citations.length, i = 0;
        while (i < n && cnt < h) {
            if (citations[i++] >= h) {
                cnt++;
            }
        }
        return cnt >= h;
    }

}
