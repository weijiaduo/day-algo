package com.wjd.practice.leetcode.string.combination;

import com.wjd.practice.TestCase;

import java.util.*;

/**
 * 30. 串联所有单次的字串
 * <p>
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 * <p>
 * s 中的 串联子串 是指一个包含 words 中所有字符串以任意顺序排列连接起来的子串。
 * <p>
 * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"， "efabcd"， 和 "efcdab" 都是串联子串。
 * <p>
 * "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 * <p>
 * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
 * 子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
 * 子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
 * 输出顺序无关紧要。返回 [9,0] 也是可以的。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
 * s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
 * 所以我们返回一个空数组。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 输出：[6,9,12]
 * 解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
 * 子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
 * 子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
 * 子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10⁴
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * words[i] 和 s 由小写英文字母组成
 *
 * @since 2022/5/22
 */
public class FindSubstring {

    /**
     * 思路：暴力法（啧啧啧，真够慢的~）
     * <p>
     * 按字符串长度分割，再排序
     * <p>
     * O(nlogn): 遍历 O(n) * 排序 O(logn)
     * <p>
     * 执行耗时:223 ms,击败了29.35% 的Java用户
     * 内存消耗:41.8 MB,击败了72.54% 的Java用户
     */
    @TestCase(input = {"barfoothefoobarman", "[\"foo\",\"bar\"]",
            "wordgoodgoodgoodbestword", "[\"word\",\"good\",\"best\",\"word\"]",
            "barfoofoobarthefoobarman", "[\"bar\",\"foo\",\"the\"]"},
            output = {"[0,9]", "[]", "[6,9,12]"})
    public List<Integer> sort(String s, String[] words) {
        List<Integer> indexes = new ArrayList<>();
        Arrays.sort(words);
        for (int i = 0; i < s.length(); i++) {
            if (isMatch(s, i, words)) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    private boolean isMatch(String s, int start, String[] words) {
        int wordLength = words[0].length();
        int length = words.length * wordLength;
        if (start + length > s.length()) {
            return false;
        }
        String subString = s.substring(start, start + length);
        String[] ss = new String[words.length];
        for (int i = 0; i < ss.length; i++) {
            int index = i * wordLength;
            ss[i] = subString.substring(index, index + wordLength);
        }
        Arrays.sort(ss);
        return Arrays.equals(words, ss);
    }

    /**
     * 思路：滑动窗口，多个滑动窗口，每次滑动距离不是1，而是 word.length
     * <p>
     * 有点意思，大家的想法都差不多，我还以为其他方法
     * <p>
     * 复杂度：O(n): 单字符串长度遍历 O(m) * 字符串数量 O(n/m)
     * <p>
     * 执行耗时:7 ms,击败了96.00% 的Java用户
     * 内存消耗:41.9 MB,击败了62.26% 的Java用户
     */
    @TestCase(input = {"barfoothefoobarman", "[\"foo\",\"bar\"]",
            "wordgoodgoodgoodbestword", "[\"word\",\"good\",\"best\",\"word\"]",
            "barfoofoobarthefoobarman", "[\"bar\",\"foo\",\"the\"]"},
            output = {"[0,9]", "[]", "[6,9,12]"})
    public List<Integer> slide(String s, String[] words) {
        // 统计所有 word 的数量
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        List<Integer> indexes = new ArrayList<>();
        int n = s.length(), m = words.length;
        int d = words[0].length();
        for (int i = 0; i < d; i++) {
            // 定长分割字符串
            int size = (n - i) / d;
            List<String> subs = new ArrayList<>(size);
            for (int j = 0; j < size; j++) {
                int index = i + j * d;
                subs.add(s.substring(index, index + d));
            }

            int left = 0, right = 0;
            Map<String, Integer> subMap = new HashMap<>(m);
            while (right < size && size - left >= m) {
                // 滑动窗口右边扩展
                String sub = subs.get(right++);
                if (!wordMap.containsKey(sub)) {
                    // 如果不在 words 中，重新开始，快速滑动
                    subMap.clear();
                    left = right;
                    continue;
                }

                // 计算 word 的数量
                subMap.put(sub, subMap.getOrDefault(sub, 0) + 1);

                // word 数量一致时，才验证是否相同
                if (right - left != m) {
                    continue;
                }

                // 验证所有 word 是否都匹配，利用 size 相等判断避免 Map 遍历
                if (subMap.size() == wordMap.size() && subMap.equals(wordMap)) {
                    indexes.add(i + left * d);
                }

                // 滑动窗口左边收缩
                String first = subs.get(left++);
                int cnt = subMap.get(first);
                if (cnt > 1) {
                    // 存在重复 word
                    subMap.put(first, cnt - 1);
                } else {
                    subMap.remove(first);
                }
            }
        }
        return indexes;
    }

}
