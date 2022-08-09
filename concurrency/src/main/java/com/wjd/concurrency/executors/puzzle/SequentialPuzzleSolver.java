package com.wjd.concurrency.executors.puzzle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 《并发编程实战》-第八章-线程池的使用
 * 谜题的串行递归
 * @since 2022/5/11
 */
public class SequentialPuzzleSolver<P, M> {

    private final Puzzle<P, M> puzzle;
    private final Set<P> seen = new HashSet<>();

    public SequentialPuzzleSolver(Puzzle<P, M> puzzle) {
        this.puzzle = puzzle;
    }

    public List<M> solve() {
        P pos = puzzle.initialPosition();
        return search(new Node<P, M>(pos, null, null));
    }

    private List<M> search(Node<P,M> node) {
        if (!seen.contains(node.pos)) {
            // 该位置尚未遍历过
            seen.add(node.pos);
            if (puzzle.isGoal(node.pos)) {
                // 找到目标位置
                return node.asMoveList();
            }
            // 遍历下一个位置
            for (M move : puzzle.legalMove(node.pos)) {
                P pos = puzzle.move(node.pos, move);
                Node<P, M> child = new Node<>(pos, move, node);
                List<M> result = search(child);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

}
