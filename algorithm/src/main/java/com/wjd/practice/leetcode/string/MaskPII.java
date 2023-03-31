package com.wjd.practice.leetcode.string;

/**
 * 831. 隐藏个人信息
 * <p>
 * 给你一条个人信息字符串 s ，可能表示一个 邮箱地址 ，也可能表示一串 电话号码 。返回按如下规则 隐藏 个人信息后的结果：
 * <p>
 * 电子邮件地址：
 * <p>
 * 一个电子邮件地址由以下部分组成：
 * <p>
 * 一个 名字 ，由大小写英文字母组成，后面跟着
 * 一个 '@' 字符，后面跟着
 * 一个 域名 ，由大小写英文字母和一个位于中间的 '.' 字符组成。'.' 不会是域名的第一个或者最后一个字符。
 * <p>
 * 要想隐藏电子邮件地址中的个人信息：
 * <p>
 * 名字 和 域名 部分的大写英文字母应当转换成小写英文字母。
 * 名字 中间的字母（即，除第一个和最后一个字母外）必须用 5 个 "*****" 替换。
 * <p>
 * 电话号码：
 * <p>
 * 一个电话号码应当按下述格式组成：
 * <p>
 * 电话号码可以由 10-13 位数字组成
 * 后 10 位构成 本地号码
 * 前面剩下的 0-3 位，构成 国家代码
 * 利用 {'+', '-', '(', ')', ' '} 这些 分隔字符 按某种形式对上述数字进行分隔
 * <p>
 * 要想隐藏电话号码中的个人信息：
 * <p>
 * 移除所有 分隔字符
 * 隐藏个人信息后的电话号码应该遵从这种格式：
 * <p>
 * "***-***-XXXX" 如果国家代码为 0 位数字
 * "+*-***-***-XXXX" 如果国家代码为 1 位数字
 * "+**-***-***-XXXX" 如果国家代码为 2 位数字
 * "+***-***-***-XXXX" 如果国家代码为 3 位数字
 * <p>
 * "XXXX" 是最后 4 位 本地号码
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "LeetCode@LeetCode.com"
 * 输出："l*****e@leetcode.com"
 * 解释：s 是一个电子邮件地址。
 * 名字和域名都转换为小写，名字的中间用 5 个 * 替换。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "AB@qq.com"
 * 输出："a*****b@qq.com"
 * 解释：s 是一个电子邮件地址。
 * 名字和域名都转换为小写，名字的中间用 5 个 * 替换。
 * 注意，尽管 "ab" 只有两个字符，但中间仍然必须有 5 个 * 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "1(234)567-890"
 * 输出："***-***-7890"
 * 解释：s 是一个电话号码。
 * 共计 10 位数字，所以本地号码为 10 位数字，国家代码为 0 位数字。
 * 因此，隐藏后的电话号码应该是 "***-***-7890" 。
 * <p>
 * 示例 4：
 * <p>
 * 输入：s = "86-(10)12345678"
 * 输出："+**-***-***-5678"
 * 解释：s 是一个电话号码。
 * 共计 12 位数字，所以本地号码为 10 位数字，国家代码为 2 位数字。
 * 因此，隐藏后的电话号码应该是 "+**-***-***-7890" 。
 * <p>
 * 提示：
 * <p>
 * s 是一个 有效 的电子邮件或者电话号码
 * 如果 s 是一个电子邮件：
 * <p>
 * 8 <= s.length <= 40
 * s 是由大小写英文字母，恰好一个 '@' 字符，以及 '.' 字符组成
 * <p>
 * 如果 s 是一个电话号码：
 * <p>
 * 10 <= s.length <= 20
 * s 是由数字、空格、字符 '('、')'、'-' 和 '+' 组成
 *
 * @author weijiaduo
 * @since 2023/4/1
 */
public class MaskPII {

    /**
     * 思路：分2种情况处理，分别进行字符串替换和拼接
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:9 ms,击败了10.00% 的Java用户
     * 内存消耗:40.1 MB,击败了19.44% 的Java用户
     *
     * @param s 字符串
     * @return 加密后的字符串
     */
    public String maskPII(String s) {
        if (s == null) {
            return null;
        }
        if (s.contains("@")) {
            return maskEmail(s);
        } else {
            return maskPhoneNumber(s);
        }
    }

    /**
     * 加密电子邮件地址
     *
     * @param emailAddress 电子右键地址
     * @return 加密后的电子邮件地址
     */
    private String maskEmail(String emailAddress) {
        String[] ss = emailAddress.split("@");
        String name = ss[0];
        name = name.charAt(0) + "*****" + name.charAt(name.length() - 1);
        String domain = ss[1];
        return name.toLowerCase() + "@" + domain.toLowerCase();
    }

    /**
     * 电话号码加密
     *
     * @param phoneNumber 电话号码
     * @return 加密后的电话号码
     */
    private String maskPhoneNumber(String phoneNumber) {
        String numbers = phoneNumber.replaceAll("[^0-9]", "");
        String code = numbers.substring(0, numbers.length() - 10);
        String localNumber = numbers.substring(numbers.length() - 10);
        if (!code.isEmpty()) {
            code = "+" + code.replaceAll("\\d", "*") + "-";
        }
        localNumber = "***-***-" + localNumber.substring(6, 10);
        return code + localNumber;
    }

}
