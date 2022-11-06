package com.wjd.practice.leetcode.string;

/**
 * 1678. 设计 Goal 解析器
 * <p>
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。
 * <p>
 * command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。
 * <p>
 * Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。
 * <p>
 * 然后，按原顺序将经解释得到的字符串连接成一个字符串。
 * <p>
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 * <p>
 * 输入：command = "G()(al)"
 * 输出："Goal"
 * 解释：Goal 解析器解释命令的步骤如下所示：
 * G -> G
 * () -> o
 * (al) -> al
 * 最后连接得到的结果是 "Goal"
 *
 * @author weijiaduo
 * @since 2022/11/6
 */
public class InterpretGoal {

    /**
     * 思路：直接按顺序解析即可
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.3 MB,击败了87.43% 的Java用户
     */
    public String solve(String command) {
        StringBuilder sb = new StringBuilder();
        int n = command.length();
        for (int i = 0; i < n; i++) {
            char c = command.charAt(i);
            if (c == 'G') {
                sb.append('G');
            } else if (c == '(') {
                if (i < n - 1 && command.charAt(i + 1) == 'a') {
                    sb.append("al");
                    i += 3;
                } else {
                    sb.append('o');
                    i++;
                }
            }
        }
        return sb.toString();
    }

}
