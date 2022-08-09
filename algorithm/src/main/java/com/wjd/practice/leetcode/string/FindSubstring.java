package com.wjd.practice.leetcode.string;

import com.wjd.practice.leetcode.Solution;

import java.util.*;

/**
 * 30. 串联所有单次的字串
 * <p>
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * <p>
 * @since 2022/5/22
 */
public class FindSubstring implements Solution<List<Integer>> {

    @Override
    public List<Integer> solve(Object ...args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar","foo","the"};
        List<Integer> result = findSubstring(s, words);
        List<Integer> result2 = findSubstring2(s, words);
        System.out.println(result);
        System.out.println(result2);
        return result;
    }

    /**
     * 暴力法（啧啧啧，真够慢的~）
     *
     * 按字符串长度分割，再排序
     *
     * O(nlogn): 遍历 O(n) * 排序 O(logn)
     *
     * 执行耗时:223 ms,击败了29.35% 的Java用户
     * 内存消耗:41.8 MB,击败了72.54% 的Java用户
     */
    public List<Integer> findSubstring(String s, String[] words) {
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
        for (int i = 0; i < ss.length; i++) {
            if (!ss[i].equals(words[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 滑动窗口
     *
     * 有点意思，大家的想法都差不多，我还以为其他方法
     *
     * O(n): 单字符串长度遍历 O(m) * 字符串数量 O(n/m)
     *
     * 执行耗时:7 ms,击败了96.00% 的Java用户
     * 内存消耗:41.9 MB,击败了62.26% 的Java用户
     */
    public List<Integer> findSubstring2(String s, String[] words) {
        // 统计所有 word 的数量
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        List<Integer> indexes = new ArrayList<>();
        int wordLength = words[0].length();
        for (int i = 0; i < wordLength; i++) {
            // 滑动定长分割字符串
            int size = (s.length() - i) / wordLength;
            List<String> strs = new ArrayList<>(size);
            for (int j = 0; j < size; j++) {
                int index = i + j * wordLength;
                strs.add(s.substring(index, index + wordLength));
            }

            int left = 0, right = 0;
            Map<String, Integer> strMap = new HashMap<>(words.length);
            while (right < size && size - left >= words.length) {
                String str = strs.get(right++);
                if (!wordMap.containsKey(str)) {
                    // 如果不在 words 中，重新开始
                    strMap.clear();
                    left = right;
                    continue;
                }

                // 计算 word 的数量
                strMap.put(str, strMap.getOrDefault(str, 0) + 1);

                // word 数量一致时，才验证是否相同
                if (right - left != words.length) {
                    continue;
                }

                // 验证所有 word 是否都匹配，利用 size 相等判断避免 Map 遍历
                if (strMap.size() == wordMap.size() && strMap.equals(wordMap)) {
                    indexes.add(i + left * wordLength);
                }

                // 移除滑动窗口的第一个位置
                String first = strs.get(left++);
                int n = strMap.get(first);
                if (n > 1) {
                    // 存在重复 word
                    strMap.put(first, n - 1);
                } else {
                    strMap.remove(first);
                }
            }
        }
        return indexes;
    }

}
