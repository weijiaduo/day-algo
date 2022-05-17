package com.wjd.algorithm.practice.leetcode.string;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * @since 2022/5/17
 * 953. 验证外星语字典
 * <p>
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order。
 * <p>
 * 只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回false。
 * <p>
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * <p>
 * 输出：true
 * <p>
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 */
public class AlienSorted implements Solution<Boolean> {

    @Override
    public Boolean solve(Object args) {
        String[] words = {"zezwvpdhkhc","nldmzkh","qvjpbis","gxntgh","knkdjzzxkv","qyymcxdjut","htjghmlc","qxgxzmgbodnj","hkmhfenu","tlbjlaw"};
        String order = "pojvhubakxzqtlesmcwydinrfg";
        boolean result = isAlienSorted(words, order);
        System.out.println(result);
        return result;
    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] orders = new int[26];
        for (int i = 0; i < order.length(); i++) {
            int index = order.charAt(i) - 'a';
            orders[index] = i;
        }

        int i = 0;
        while (i < words.length - 1) {
            if (!isInOrder(words[i], words[++i], orders)) {
                return false;
            }
        }
        return true;
    }

    private boolean isInOrder(String w1, String w2, int[] orders) {
        int length = Math.min(w1.length(), w2.length());
        for (int i = 0; i < length; i++) {
            int index1 = w1.charAt(i) - 'a';
            int index2 = w2.charAt(i) - 'a';
            if (orders[index1] == orders[index2]) {
                continue;
            }
            return orders[index1] < orders[index2];
        }
        // 前面都相同的情况下，短的优先
        return w1.length() <= w2.length();
    }

}
