package com.wjd.practice.book.sword.string;

import com.wjd.practice.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 17. 打印从1到最大的n位数
 * <p>
 * 输入数字n，按顺序打印出从1到最大的n位十进制数。
 * <p>
 * 比如输入3，则打印出1、2、3一直到最大的3位数即999。
 *
 * @author weijiaduo
 * @since 2023/11/24
 */
public class Print1ToMaxOfNDigits {

    /**
     * 思路：全排列，递归
     * <p>
     * 从前往后遍历n位数，每一位都有0~9共10种选择，
     * <p>
     * 每次选择一位，然后继续选择下一位，直到选择完n位
     * <p>
     * 复杂度：时间 O(10^n) 空间 O(n)
     */
    @TestCase(input = {"1"},
            output = {"[1,2,3,4,5,6,7,8,9]"})
    public List<String> dfs(int n) {
        List<String> list = new ArrayList<>();
        char[] num = new char[n];
        dfs(num, 0, list);
        return list;
    }

    /**
     * 递归遍历
     *
     * @param num   数字
     * @param index 当前遍历到的下标
     * @param list  结果集
     */
    private void dfs(char[] num, int index, List<String> list) {
        if (index == num.length) {
            String str = toStr(num);
            if (!str.isEmpty()) {
                list.add(str);
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            num[index] = (char) (i + '0');
            dfs(num, index + 1, list);
        }
    }

    /**
     * 思路：全排列，迭代
     * <p>
     * 从后往前遍历，每次加1，直到最大值
     * <p>
     * 复杂度：时间 O(10^n) 空间 O(n)
     */
    @TestCase(input = {"1"},
            output = {"[1,2,3,4,5,6,7,8,9]"})
    public List<String> iterate(int n) {
        List<String> list = new ArrayList<>();
        char[] num = new char[n];
        Arrays.fill(num, '0');
        while (true) {
            int i = n - 1;
            while (i >= 0 && num[i] == '9') {
                num[i] = '0';
                i--;
            }
            if (i < 0) {
                break;
            }
            num[i]++;
            String str = toStr(num);
            if (!str.isEmpty()) {
                list.add(str);
            }
        }
        return list;
    }

    /**
     * 转成字符串，去掉前面的0
     *
     * @param num 数字
     * @return 字符串
     */
    private String toStr(char[] num) {
        int n = num.length, i = 0;
        while (i < n && num[i] == '0') {
            i++;
        }
        return new String(num, i, n - i);
    }

}
