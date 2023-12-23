package com.wjd.practice.book.cracking.bit;

import com.wjd.practice.TestCase;

/**
 * 面试题 05.02. 二进制数转字符串
 * <p>
 * 给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。
 * <p>
 * 如果该数字无法精确地用32位以内的二进制表示，则打印 “ERROR”。
 * <p>
 * 示例1:
 * <p>
 * 输入：0.625
 * 输出："0.101"
 * <p>
 * 示例2:
 * <p>
 * 输入：0.1
 * 输出："ERROR"
 * 提示：0.1无法被二进制准确表示
 * <p>
 * 提示：
 * <p>
 * 32位包括输出中的 "0." 这两位。
 * 题目保证输入用例的小数位数最多只有 6 位
 *
 * @author weijiaduo
 * @since 2023/7/14
 */
public class PrintBin {

    /**
     * 思路：将实数的十进制表示转换成二进制表示的方法是：每次将实数乘以 2
     * <p>
     * 将此时的整数部分添加到二进制表示的末尾，然后将整数部分置为 0
     * <p>
     * 重复上述操作，直到小数部分变成 0 或者小数部分出现循环时结束操作。
     * <p>
     * 复杂度：时间 O(C) 空间 O(1)
     * <p>
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了76.04%的用户
     */
    @TestCase(input = {"0.625", "0.1"},
            output = {"0.101", "ERROR"})
    public String bin(double num) {
        StringBuilder sb = new StringBuilder();
        int d = (int) num;
        sb.append("0.");
        num -= d;
        for (int i = 0; i < 32 && num != 0; i++) {
            num *= 2;
            d = (int) num;
            sb.append(d);
            num -= d;
        }
        return sb.length() <= 32 ? sb.toString() : "ERROR";
    }

}
