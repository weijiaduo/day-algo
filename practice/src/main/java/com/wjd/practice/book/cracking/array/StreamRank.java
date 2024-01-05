package com.wjd.practice.book.cracking.array;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 10.10. 数字流的秩
 * <p>
 * 假设你正在读取一串整数。每隔一段时间，你希望能找出数字 x 的秩(小于或等于 x 的值的个数)。
 * <p>
 * 请实现数据结构和算法来支持这些操作，也就是说：
 * <p>
 * 实现 track(int x) 方法，每读入一个数字都会调用该方法；
 * <p>
 * 实现 getRankOfNumber(int x) 方法，返回小于或等于 x 的值的个数。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例:
 * <p>
 * 输入:
 * ["StreamRank", "getRankOfNumber", "track", "getRankOfNumber"]
 * [[], [1], [0], [0]]
 * 输出:
 * [null,0,null,1]
 * <p>
 * 提示：
 * <p>
 * x <= 50000
 * track 和 getRankOfNumber 方法的调用次数均不超过 2000 次
 *
 * @author weijiaduo
 * @since 2024/1/5
 */
public class StreamRank {

    // 元素动态数组
    List<Integer> elems;

    /**
     * 思路：排序数组+二分查找
     * <p>
     * 流中的数字插入到排序数组中，可以采用二分插入
     * <p>
     * 查找指定数字的秩，也可以采用二分法
     * <p>
     * 执行耗时:18 ms,击败了50.34% 的Java用户
     * 内存消耗:43.6 MB,击败了27.52% 的Java用户
     */
    public StreamRank() {
        elems = new ArrayList<>();
    }

    /**
     * 复杂度：时间 O(n) 空间 O(1)
     */
    public void track(int x) {
        elems.add(firstGreat(x), x);
    }

    /**
     * 复杂度：时间 O(logn) 空间 O(1)
     */
    public int getRankOfNumber(int x) {
        return firstGreat(x);
    }

    /**
     * 找到第一个大于指定值 x 的位置
     *
     * @param x 指定值
     * @return 下标
     */
    private int firstGreat(int x) {
        int l = 0, r = elems.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (elems.get(m) > x) {
                if (m == l || elems.get(m - 1) <= x) {
                    return m;
                }
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    @TestCase(input = {"1"})
    public void test(int unused) {
        StreamRank streamRank = new StreamRank();
        System.out.println(streamRank.getRankOfNumber(1)); // 0
        streamRank.track(0);
        System.out.println(streamRank.getRankOfNumber(0)); // 1
    }

}
