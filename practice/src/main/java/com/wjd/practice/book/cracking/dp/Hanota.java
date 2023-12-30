package com.wjd.practice.book.cracking.dp;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.06. 汉诺塔问题
 * <p>
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。
 * <p>
 * 一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。
 * <p>
 * 移动圆盘时受到以下限制:
 * <p>
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 * <p>
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 * <p>
 * 你需要原地修改栈。
 * <p>
 * 示例1:
 * <p>
 * 输入：A = [2, 1, 0], B = [], C = []
 * 输出：C = [2, 1, 0]
 * <p>
 * 示例2:
 * <p>
 * 输入：A = [1, 0], B = [], C = []
 * 输出：C = [1, 0]
 * <p>
 * 提示:
 * <p>
 * A中盘子的数目不大于14个。
 *
 * @author weijiaduo
 * @since 2023/12/30
 */
public class Hanota {

    @TestCase(input = {"[2,1,0]"},
            output = {"[2,1,0]"})
    public List<Integer> hanota(List<Integer> a) {
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        dfs(a, b, c);
        return c;
    }

    /**
     * 思路：递归
     * <p>
     * 将 a 的圆盘借助 b 搬移到 c 可分为 3 个步骤
     * <p>
     * 1. 将 a 的 n-1 个圆盘搬移到 b 中
     * <p>
     * 2. 再将最大的 1 个圆盘搬移到 c 中
     * <p>
     * 3. 最后再将 b 的 n-1 个圆盘搬移到 c 中
     * <p>
     * 复杂度：时间 O(3^n) 空间 O(n)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.2 MB,击败了6.62% 的Java用户
     */
    private void dfs(List<Integer> a, List<Integer> b, List<Integer> c) {
        dfs(a, a.size(), b, c);
    }

    /**
     * 递归
     *
     * @param a 初始圆盘，需要搬移的圆盘
     * @param n 搬移的圆盘数量
     * @param b 临时圆盘
     * @param c 目标圆盘，接收圆盘的地方
     */
    private void dfs(List<Integer> a, int n, List<Integer> b, List<Integer> c) {
        if (n <= 0) {
            return;
        }

        // 先将 a 的 n-1 个圆盘搬到 b
        dfs(a, n - 1, c, b);
        // 再将 a 的 i 搬到 c
        c.add(a.remove(a.size() - 1));
        // 最后将临时放到 b 的 n-1 个圆盘搬到 c
        dfs(b, n - 1, a, c);
    }

}
