package com.wjd.practice.leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数
 * <p>
 * 给你一个整数 n，按字典序返回范围 [1, n] 内所有整数。
 * <p>
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 13
 * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：[1,2]
 *
 * @author weijiaduo
 * @since 2023/4/1
 */
public class LexicalOrder {

    public List<Integer> lexicalOrder(int n) {
        return iterator(n);
    }

    /**
     * 思路：深度优先遍历的迭代法
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:4 ms,击败了77.41% 的Java用户
     * 内存消耗:45.9 MB,击败了53.83% 的Java用户
     *
     * @param n 最大值
     * @return 按照字典顺序排好的数字
     */
    private List<Integer> iterator(int n) {
        List<Integer> list = new ArrayList<>();
        int num = 1, cnt = 0;
        while (cnt < n) {
            if (num <= n) {
                list.add(num);
                num = num * 10;
                cnt++;
            } else {
                while (num % 10 == 9) {
                    num /= 10;
                }
                num++;
            }
        }
        return list;
    }

    /**
     * 思路：深度优先遍历，按照1-9的顺序遍历所有[1, n]范围内的数字
     * <p>
     * 复杂度：时间 O(n) 空间 O(L)
     * <p>
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:45.8 MB,击败了55.99% 的Java用户
     *
     * @param n 最大值
     * @return 按照字典顺序排好的数字
     */
    private List<Integer> dfs(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            collect(i, n, list);
        }
        return list;
    }

    /**
     * 按字典顺序收集所有数字
     *
     * @param num   基础数字
     * @param limit 最大值
     * @param list  收集列表
     */
    private void collect(int num, int limit, List<Integer> list) {
        if (num > limit) {
            return;
        }
        list.add(num);
        int base = num * 10;
        for (int i = 0; i < 10; i++) {
            int temp = base + i;
            if (temp > limit) {
                return;
            }
            collect(temp, limit, list);
        }
    }

}
