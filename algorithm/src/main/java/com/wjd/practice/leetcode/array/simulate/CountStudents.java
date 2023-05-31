package com.wjd.practice.leetcode.array.simulate;

/**
 * 1700. 无法吃午餐的学生数量
 * <p>
 * 学校的自助午餐提供圆形和方形的三明治，分别用数字 0 和 1 表示。
 * <p>
 * 所有学生站在一个队列里，每个学生要么喜欢圆形的要么喜欢方形的。
 * <p>
 * 餐厅里三明治的数量与学生的数量相同。所有三明治都放在一个 栈 里，每一轮：
 * <p>
 * 如果队列最前面的学生 喜欢 栈顶的三明治，那么会 拿走它 并离开队列。
 * <p>
 * 否则，这名学生会 放弃这个三明治 并回到队列的尾部。
 * <p>
 * 这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止。
 * <p>
 * 给你两个整数数组 students 和 sandwiches ，其中 sandwiches[i] 是栈里面第 i 个三明治的类型（i = 0 是栈的顶部）
 * ， students[j] 是初始队列里第 j 名学生对三明治的喜好（j = 0 是队列的最开始位置）。
 * <p>
 * 请你返回无法吃午餐的学生数量。
 * <p>
 * 输入：students = [1,1,0,0], sandwiches = [0,1,0,1]
 * 输出：0
 *
 * @author weijiaduo
 * @since 2022/10/19
 */
public class CountStudents {

    /**
     * 思路：模拟，按照要求直接模拟出栈和出队即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39 MB,击败了95.77% 的Java用户
     */
    public int solve(int[] students, int[] sandwiches) {
        // 统计喜欢0和1的学生数量
        int s0 = 0, s1 = 0;
        int n = students.length;
        for (int s : students) {
            s1 += s;
        }
        s0 = n - s1;

        // 学生的顺序不影响结果
        int i = 0;
        while (i < n) {
            int num = sandwiches[i];
            if (num == 0 && s0 > 0) {
                s0--;
            } else if (num == 1 && s1 > 0) {
                s1--;
            } else {
                break;
            }
            i++;
        }
        return n - i;
    }

}
