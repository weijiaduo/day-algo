package com.wjd.practice.leetcode.string.transform;

/**
 * 1694. 重新格式化电话号码
 * <p>
 * 给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。
 * <p>
 * 请你按下述方式重新格式化电话号码。
 * <p>
 * 首先，删除 所有的空格和破折号。
 * 其次，将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
 * <p>
 * 2 个数字：单个含 2 个数字的块。
 * 3 个数字：单个含 3 个数字的块。
 * 4 个数字：两个分别含 2 个数字的块。
 * <p>
 * 最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，并且 最多 生成两个含 2 个数字的块。
 * <p>
 * 返回格式化后的电话号码。
 * <p>
 * 输入：number = "1-23-45 6"
 * 输出："123-456"
 * 解释：数字是 "123456"
 * 步骤 1：共有超过 4 个数字，所以先取 3 个数字分为一组。第 1 个块是 "123" 。
 * 步骤 2：剩下 3 个数字，将它们放入单个含 3 个数字的块。第 2 个块是 "456" 。
 * 连接这些块后得到 "123-456" 。
 *
 * @author weijiaduo
 * @since 2022/10/1
 */
public class ReformatNumber {

    /**
     * 思路：直接模拟，每3个数字一个破折号，判断最后是否是4个数字即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:1 ms,击败了97.83% 的Java用户
     * 内存消耗:39.3 MB,击败了96.39% 的Java用户
     */
    public String reformatNumber(String number) {
        int size = number.length();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            char ch = number.charAt(i);
            if (ch == ' ' || ch == '-') {
                continue;
            }
            sb.append(ch);
            count++;
            if (count == 3) {
                sb.append('-');
                count = 0;
            }
        }

        // 删除末尾的破折号
        if (sb.length() > 3 && sb.length() % 4 == 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        // 针对末尾是 4 位数字的情况特殊处理成 2-2
        if (sb.length() > 4 && sb.length() % 4 == 1) {
            sb.deleteCharAt(sb.length() - 2);
            sb.insert(sb.length() - 2, '-');
        }
        return sb.toString();
    }
}
