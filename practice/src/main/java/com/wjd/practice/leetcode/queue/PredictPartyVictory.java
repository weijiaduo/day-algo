package com.wjd.practice.leetcode.queue;

import com.wjd.practice.leetcode.TestCase;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 649. Dota2 参议院
 * <p>
 * Dota2 的世界里有两个阵营：Radiant（天辉）和 Dire（夜魇）
 * <p>
 * Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。
 * <p>
 * 他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议员都可以行使两项权利中的 一 项：
 * <p>
 * <p>
 * 禁止一名参议员的权利：参议员可以让另一位参议员在这一轮和随后的几轮中丧失 所有的权利 。
 * <p>
 * 宣布胜利：如果参议员发现有权利投票的参议员都是 同一个阵营的 ，他可以宣布胜利并决定在游戏中的有关变化。
 * <p>
 * <p>
 * 给你一个字符串 senate 代表每个参议员的阵营。字母 'R' 和 'D'分别代表了 Radiant（天辉）和 Dire（夜魇）。
 * <p>
 * 然后，如果有 n 个参议员，给定字符串的大小将是 n。
 * <p>
 * 以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。
 * <p>
 * 所有失去权利的参议员将在过程中被跳过。
 * <p>
 * 假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。
 * <p>
 * 输出应该是 "Radiant"或 "Dire" 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：senate = "RD"
 * 输出："Radiant"
 * 解释：
 * 第 1 轮时，第一个参议员来自 Radiant 阵营，他可以使用第一项权利让第二个参议员失去所有权利。
 * 这一轮中，第二个参议员将会被跳过，因为他的权利被禁止了。
 * 第 2 轮时，第一个参议员可以宣布胜利，因为他是唯一一个有投票权的人。
 * <p>
 * 示例 2：
 * <p>
 * 输入：senate = "RDD"
 * 输出："Dire"
 * 解释：
 * 第 1 轮时，第一个来自 Radiant 阵营的参议员可以使用第一项权利禁止第二个参议员的权利。
 * 这一轮中，第二个来自 Dire 阵营的参议员会将被跳过，因为他的权利被禁止了。
 * 这一轮中，第三个来自 Dire 阵营的参议员可以使用他的第一项权利禁止第一个参议员的权利。
 * 因此在第二轮只剩下第三个参议员拥有投票的权利,于是他可以宣布胜利
 * <p>
 * 提示：
 * <p>
 * n == senate.length
 * 1 <= n <= 10⁴
 * senate[i] 为 'R' 或 'D'
 *
 * @author weijiaduo
 * @since 2023/10/9
 */
public class PredictPartyVictory {

    /**
     * 思路：贪心+循环队列
     * <p>
     * 两方投票人分别进入两条循环队列，队列存放的是索引
     * <p>
     * 投票时，贪心地将票投给对方队列的队首，以此减少对方的投票人员
     * <p>
     * 其中投票时，索引较小的投票人，可以优先投票
     * <p>
     * 为了构成循环队列，从队列出队后，给索引增加 n 以区分下一轮投票
     * <p>
     * 复杂度：时间 O(n) 空间 O(n)
     * <p>
     * 执行耗时:10 ms,击败了71.78% 的Java用户
     * 内存消耗:43.1 MB,击败了22.10% 的Java用户
     */
    @TestCase(input = {"RD", "RDD"},
            output = {"Radiant", "Dire"})
    public String greedyQueue(String senate) {
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> dq = new LinkedList<>();
        int n = senate.length();
        for (int i = 0; i < n; i++) {
            char ch = senate.charAt(i);
            if (ch == 'R') {
                rq.offer(i);
            } else {
                dq.offer(i);
            }
        }
        // 投票给对方队列的队首，索引小的可以优先投票
        while (!rq.isEmpty() && !dq.isEmpty()) {
            int ri = rq.poll();
            int di = dq.poll();
            if (ri < di) {
                rq.offer(ri + n);
            } else {
                dq.offer(di + n);
            }
        }
        return rq.isEmpty() ? "Dire" : "Radiant";
    }

}
