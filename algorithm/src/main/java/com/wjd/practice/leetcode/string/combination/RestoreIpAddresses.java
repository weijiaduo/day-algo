package com.wjd.practice.leetcode.string.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原IP地址
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
 * 和 "192.168@1.1" 是 无效 IP 地址。
 * <p>
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
 * <p>
 * 你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * <p>
 *
 * @since 2022/6/11
 */
public class RestoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        dfs(s, 0, 4, "", ans);
        return ans;
    }

    /**
     * 回溯法
     * <p>
     * 执行耗时:1 ms,击败了95.23% 的Java用户
     * 内存消耗:41.5 MB,击败了48.48% 的Java用户
     */
    private void dfs(String s, int k, int n, String ip, List<String> ans) {
        // 快速剪枝，判断长度还是很必要的
        if (n < 0 || s.length() - k > n * 3) {
            return;
        }

        if (k >= s.length()) {
            // 正解
            if (n == 0) {
                ans.add(ip);
            }
            return;
        }

        if (ip.length() > 0) {
            ip += ".";
        }
        int length = s.charAt(k) == '0' ? 1 : 3;
        for (int i = 1; i <= length; i++) {
            if (k + i > s.length()) {
                return;
            }

            String str = s.substring(k, k + i);
            int num = Integer.parseInt(str);
            if (num > 255) {
                return;
            }

            // 寻找ip的下一个数值
            dfs(s, k + i, n - 1, ip + str, ans);
        }
    }
}
