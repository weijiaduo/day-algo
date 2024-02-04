package com.wjd.practice.leetcode.string.transform;

import com.wjd.practice.TestCase;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 151. 颠倒字符串中的单词
 * <p>
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
 * <p>
 * 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = " hello world "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "a good  example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10⁴
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 *
 * @author weijiaduo
 * @since 2022/6/29
 */
public class ReverseWords {

    /**
     * 思路：先将单词翻转，然后将整条字符串翻转
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:3 ms,击败了92.00% 的Java用户
     * 内存消耗:39.17MB,击败了96.30% 的Java用户
     */
    @TestCase(input = {"the sky is blue", " hello world ", "a good  example"},
            output = {"blue is sky the", "world hello", "example good a"})
    public String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length(), r = 0, l;
        while (r < n) {
            // 跳过连续的空格
            while (r < n && s.charAt(r) == ' ') {
                r++;
            }
            // 统计单词字符数量
            l = r;
            while (r < n && s.charAt(r) != ' ') {
                r++;
            }
            // 单词之间增加一个空格，但要避免最后的空格
            if (sb.length() > 0 && r - l > 0) {
                sb.append(' ');
            }
            // 单词倒着添加
            for (int k = r - 1; k >= l; k--) {
                sb.append(s.charAt(k));
            }
        }
        // 翻转整条字符串
        return sb.reverse().toString();
    }

    /**
     * 哈哈哈，写多了算法，API不会调用了
     * <p>
     * 官解：无情的API
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:8 ms,击败了34.54% 的Java用户
     * 内存消耗:41.6 MB,击败了10.52% 的Java用户
     */
    @TestCase(input = {"the sky is blue", " hello world ", "a good  example"},
            output = {"blue is sky the", "world hello", "example good a"})
    public String api(String s) {
        // 去掉左右空格
        s = s.trim();
        // 按照空格拆分字符串
        List<String> list = Arrays.asList(s.split("\\s+"));
        // 翻转字符串顺序
        Collections.reverse(list);
        // 重新连接字符串
        return String.join(" ", list);
    }

    /**
     * 思路：从右往左遍历，倒着放单词
     * <p>
     * 复杂度：时间 O(n) 空间 O(1)
     * <p>
     * 执行耗时:3 ms,击败了92.00% 的Java用户
     * 内存消耗:39.60MB,击败了72.46% 的Java用户
     */
    @TestCase(input = {"the sky is blue", " hello world ", "a good  example"},
            output = {"blue is sky the", "world hello", "example good a"})
    public String sfPoint(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = n - 1, j = n - 1;
        while (i >= 0) {
            // 跳过空格
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if (i < 0) {
                break;
            }

            // 找出单词
            j = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            String word = s.substring(i + 1, j + 1);
            sb.append(word).append(" ");
        }
        // 去掉末尾多余的空格
        return sb.substring(0, sb.length() - 1);
    }

}
