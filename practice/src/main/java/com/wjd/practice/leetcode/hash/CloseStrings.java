package com.wjd.practice.leetcode.hash;

import com.wjd.practice.TestCase;

import java.util.Arrays;

/**
 * 1657. 确定两个字符串是否接近
 * <p>
 * 如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
 * <p>
 * 操作 1：交换任意两个 现有 字符。
 * <p>
 * 例如，abcde -> aecdb
 * <p>
 * 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
 * <p>
 * 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
 * <p>
 * <p>
 * 你可以根据需要对任意一个字符串多次使用这两种操作。
 * <p>
 * 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "abc", word2 = "bca"
 * 输出：true
 * 解释：2 次操作从 word1 获得 word2 。
 * 执行操作 1："abc" -> "acb"
 * 执行操作 1："acb" -> "bca"
 * <p>
 * 示例 2：
 * <p>
 * 输入：word1 = "a", word2 = "aa"
 * 输出：false
 * 解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
 * <p>
 * 示例 3：
 * <p>
 * 输入：word1 = "cabbba", word2 = "abbccc"
 * 输出：true
 * 解释：3 次操作从 word1 获得 word2 。
 * 执行操作 1："cabbba" -> "caabbb"
 * 执行操作 2："caabbb" -> "baaccc"
 * 执行操作 2："baaccc" -> "abbccc"
 * <p>
 * 示例 4：
 * <p>
 * 输入：word1 = "cabbba", word2 = "aabbss"
 * 输出：false
 * 解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
 * <p>
 * 提示：
 * <p>
 * 1 <= word1.length, word2.length <= 10⁵
 * word1 和 word2 仅包含小写英文字母
 *
 * @author weijiaduo
 * @since 2023/10/7
 */
public class CloseStrings {

    /**
     * 思路：哈希，两个字符串要相近，必须满足2个条件
     * <p>
     * 1. 不同字符的要一样，比如 [a,b,c] 和 [b,c,a]
     * <p>
     * 2. 出现频率在总体上一样的，比如 [1,3,2] 和 [2,1,3]，顺序不重要，重要的是值一样
     * <p>
     * 满足要求后，两个字符串就是相近的
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:11 ms,击败了67.78% 的Java用户
     * 内存消耗:43.6 MB,击败了24.22% 的Java用户
     */
    @TestCase(input = {"abc", "bca", "a", "aa", "cabbba", "abbccc", "cabbba", "aabbss"},
            output = {"true", "false", "true", "false"})
    public boolean hash(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        int[] cnt1 = new int[127];
        int[] cnt2 = new int[127];
        for (int i = 0; i < n1; i++) {
            cnt1[word1.charAt(i)]++;
        }
        for (int i = 0; i < n2; i++) {
            cnt2[word2.charAt(i)]++;
        }

        // 验证不同字符是一样的
        for (int i = 0; i < cnt1.length; i++) {
            if (cnt1[i] > 0 && cnt2[i] == 0 ||
                    cnt2[i] > 0 && cnt1[i] == 0) {
                return false;
            }
        }

        // 验证不同频率是一样的
        Arrays.sort(cnt1);
        Arrays.sort(cnt2);
        for (int i = 0; i < cnt1.length; i++) {
            if (cnt1[i] != cnt2[i]) {
                return false;
            }
        }
        return true;
    }

}
