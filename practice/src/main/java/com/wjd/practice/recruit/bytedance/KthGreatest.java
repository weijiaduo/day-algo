package com.wjd.practice.recruit.bytedance;

import java.util.*;

/**
 * 给定一个字符串数组，求按照字符串频率排序的 k 个最大的字符串
 * <p>
 * 如果频率相等，则按字符串字典序输出
 * <p>
 * 要求时间复杂度是 O(nlogk)
 *
 * @author weijiaduo
 * @since 2023/12/19
 */
public class KthGreatest {

    static class Pair implements Comparable<Pair> {
        String s;
        int count;

        public Pair(String s, int count) {
            this.s = s;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            if (o == this) {
                return 0;
            }
            if (count < o.count) {
                return -1;
            } else if (count > o.count) {
                return 1;
            } else {
                return o.s.compareTo(s);
            }
        }

        @Override
        public String toString() {
            return "[" + s + "," + count + "]";
        }
    }

    /**
     * 思路：小顶堆，维护一个 k 个数量的小顶堆
     * <p>
     * 如果当前元素大于堆顶，则移除堆顶，放入新元素
     * <p>
     * 复杂度：时间 O(nlogk) 空间 O(n)
     */
    public List<Pair> getKth(String[] strs, int k) {
        if (k <= 0 || strs == null) {
            return new ArrayList<>();
        }

        // 统计字符串的频率
        Map<String, Integer> cntMap = new HashMap<>();
        for (String s : strs) {
            int cnt = cntMap.getOrDefault(s, 0);
            cntMap.put(s, cnt + 1);
        }

        // 维护 k 个值的小顶堆
        Queue<Pair> heap = new PriorityQueue<>();
        for (String s : cntMap.keySet()) {
            Pair pair = new Pair(s, cntMap.get(s));
            if (heap.size() < k) {
                heap.offer(pair);
                continue;
            }
            if (pair.compareTo(heap.peek()) > 0) {
                heap.poll();
                heap.offer(pair);
            }
        }

        // 获取结果
        List<Pair> ans = new ArrayList<>(heap.size());
        while (!heap.isEmpty()) {
            ans.add(heap.poll());
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"1", "2", "3"};
        int k = 1;
        List<Pair> ans = new KthGreatest().getKth(strs, k);
        System.out.println(ans);
    }

}
