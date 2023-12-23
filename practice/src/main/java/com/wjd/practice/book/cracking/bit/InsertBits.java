package com.wjd.practice.book.cracking.bit;

import com.wjd.practice.TestCase;

/**
 * 面试题 05.01. 插入
 * <p>
 * 给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。
 * <p>
 * 编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐。具体插入过程如图所示。
 * <p>
 * 题目保证从 i 位到 j 位足以容纳 M， 例如： M = 10011，则 i～j 区域至少可容纳 5 位。
 * <p>
 * 示例1:
 * <p>
 * 输入：N = 1024(10000000000), M = 19(10011), i = 2, j = 6
 * 输出：N = 1100(10001001100)
 * <p>
 * 示例2:
 * <p>
 * 输入： N = 0, M = 31(11111), i = 0, j = 4
 * 输出：N = 31(11111)
 *
 * @author weijiaduo
 * @since 2023/12/23
 */
public class InsertBits {

    /**
     * 思路：先生成掩码，然后再做与操作
     * <p>
     * 比如 i=2, j=5, m=10011, n=10000000
     * <p>
     * 先取掩码 mask=(1<<(j-i+1))-1=1111
     * <p>
     * 取出 m 的值并移位到指定位置 m = (m & mask) << i = 1100
     * <p>
     * 将 n[i,j] 的位置置为 0，n = n & ~(mask << i) = 10000000
     * <p>
     * 最后将 m 的值设置到 n 里面 n = n | m = 10001100
     * <p>
     * 复杂度：时间 O(1) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.2 MB,击败了5.45% 的Java用户
     */
    @TestCase(input = {"1024", "19", "2", "6",
            "0", "31", "0", "4"},
            output = {"1100", "31"})
    public int insert(int n, int m, int i, int j) {
        int mask = (1 << (j - i + 1)) - 1;
        m = (m & mask) << i;
        n = n & ~(mask << i);
        n |= m;
        return n;
    }

}
