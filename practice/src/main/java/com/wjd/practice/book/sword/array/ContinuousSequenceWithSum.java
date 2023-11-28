package com.wjd.practice.book.sword.array;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * 57.2 和为 S 的连续正数序列
 * <p>
 * 输出所有和为S的连续正数序列。
 * <p>
 * 序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序。
 * <p>
 * 例如：输入 15，由于 1+2+3+4+5 = 4+5+6 = 7+8 = 15，所以输出 3 个连续序列 1~5、4~6 和 7~8。
 *
 * @author weijiaduo
 * @since 2023/11/28
 */
public class ContinuousSequenceWithSum {

    /**
     * 思路：滑动窗口
     * <p>
     * 当窗口内的数字和小于 sum 时，窗口右边界向右移动，扩大窗口
     * <p>
     * 当窗口内的数字和大于 sum 时，窗口左边界向右移动，缩小窗口
     * <p>
     * 当窗口内的数字和等于 sum 时，记录窗口内的数字
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     */
    @TestCase(input = {"0", "4", "3", "15"},
            output = {"[]", "[]", "[[1,2]]", "[[1,2,3,4,5],[4,5,6],[7,8]]"})
    public List<List<Integer>> findContinuousSequence(int sum) {
        List<List<Integer>> res = new ArrayList<>();
        int l = 1, r = 1, num = 0;
        while (r <= sum) {
            if (num == sum) {
                // 记录窗口内的数字
                List<Integer> t = new ArrayList<>();
                for (int i = l; i < r; i++) {
                    t.add(i);
                }
                res.add(t);
            }
            if (num >= sum) {
                // 缩小窗口
                num -= l++;
            } else {
                // 扩大窗口
                num += r++;
            }
        }
        return res;
    }

}
