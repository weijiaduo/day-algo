package com.wjd.practice.leetcode.string;

import com.wjd.practice.leetcode.Solution;

import java.util.HashSet;
import java.util.Set;

/**
 * 929. 独特的电子邮件地址
 * <p>
 * 每个 有效电子邮件地址 都由一个 本地名 和一个 域名 组成，以 '@' 符号分隔。除小写字母之外，电子邮件地址还可以含有一个或多个 '.' 或 '+' 。
 * <p>
 * 例如，在 alice@leetcode.com中， alice 是 本地名 ，而 leetcode.com 是 域名 。
 * <p>
 * 1、如果在电子邮件地址的 本地名 部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名中没有点的同一地址。请注意，此规则 不适用于域名 。
 * <p>
 * 2、如果在 本地名 中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件。同样，此规则 不适用于域名 。
 * <p>
 * 可以同时使用这两个规则。
 * <p>
 * 给你一个字符串数组 emails，我们会向每个 emails[i] 发送一封电子邮件。返回实际收到邮件的不同地址数目。
 * <p>
 * 输入：emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * 输出：2
 * 解释：实际收到邮件的是 "testemail@leetcode.com" 和 "testemail@lee.tcode.com"。
 * <p>
 * @since 2022/6/4
 */
public class NumUniqueEmails implements Solution<Integer> {

    @Override
    public Integer solve(Object... args) {
        String[] emails = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        int result = numUniqueEmails(emails);
        System.out.println(result);
        return result;
    }

    /**
     * 暴力法
     *
     * 思路：拆分字符串，解析本地名称，先用 + 号截断本地名称，然后替换 . 号为空串
     *
     * split 的性能貌似比 indexOf + substring 差啊
     *
     * 执行耗时:5 ms,击败了98.48% 的Java用户
     * 内存消耗:41.5 MB,击败了70.21% 的Java用户
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int i = email.indexOf("@");
            if (i <= 0) {
                continue;
            }
            String local = email.substring(0, i);
            int j = local.indexOf("+");
            if (j > -1) {
                local = local.substring(0, j);
            }
            local = local.replace(".", "");
            set.add(local + email.substring(i));
        }
        return set.size();
    }


}
