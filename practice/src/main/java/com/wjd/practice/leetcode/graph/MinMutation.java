package com.wjd.practice.leetcode.graph;

import com.wjd.practice.TestCase;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 433. 最小基因变化
 * <p>
 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 * <p>
 * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 * <p>
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * <p>
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
 * <p>
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。
 * <p>
 * 如果无法完成此基因变化，返回 -1 。
 * <p>
 * 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
 * <p>
 * 示例 1：
 * <p>
 * 输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
 * 输出：1
 * <p>
 * 示例 2：
 * <p>
 * 输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * 输出：2
 * <p>
 * 示例 3：
 * <p>
 * 输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
 * 输出：3
 * <p>
 * 提示：
 * <p>
 * start.length == 8
 * end.length == 8
 * 0 <= bank.length <= 10
 * bank[i].length == 8
 * start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成
 *
 * @author weijiaduo
 * @since 2023/12/10
 */
public class MinMutation {

    /**
     * 思路：广度优先搜索
     * <p>
     * 从 start 出发，利用广度优先搜索找到最近的变化
     * <p>
     * 直到最后找到 end，或者找不到 end
     * <p>
     * 复杂度：时间 O(n) 空间 O(n^2)
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.6 MB,击败了15.50% 的Java用户
     */
    @TestCase(input = {"AACCGGTT", "AACCGGTA", "[\"AACCGGTA\"]",
            "AACCGGTT", "AAACGGTA", "[\"AACCGGTA\",\"AACCGCTA\",\"AAACGGTA\"]",
            "AAAAACCC", "AACCCCCC", "[\"AAAACCCC\",\"AAACCCCC\",\"AACCCCCC\"]"},
            output = {"1", "2", "3"})
    public int bfs(String startGene, String endGene, String[] bank) {
        // 构建无向图
        int n = bank.length, target = -1;
        boolean[][] matrix = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s1 = bank[i];
            if (s1.equals(endGene)) {
                target = i;
            }
            for (int j = 0; j < i; j++) {
                String s2 = bank[j];
                matrix[i][j] = matrix[j][i] = isNeighbour(s1, s2);
            }
        }
        // 目标字符串不在集合中
        if (target == -1) {
            return -1;
        }

        // 广度优先搜索
        int level = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (isNeighbour(startGene, bank[i])) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int idx = queue.poll();
                if (idx == target) {
                    return level;
                }

                visited[idx] = true;
                for (int j = 0; j < n; j++) {
                    if (!visited[j] && matrix[idx][j]) {
                        queue.offer(j);
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 两个字符串是否相邻，即只有1个字符变化
     *
     * @param s1 字符串
     * @param s2 字符串
     * @return true/false
     */
    private boolean isNeighbour(String s1, String s2) {
        int diff = 0;
        int n = s1.length();
        for (int i = 0; i < n && diff < 2; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

}
