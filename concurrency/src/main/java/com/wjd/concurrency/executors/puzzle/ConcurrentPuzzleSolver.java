package com.wjd.concurrency.executors.puzzle;

import com.wjd.concurrency.executors.ValueLatch;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;

/**
 * 《并发编程实战》-第八章-线程池的使用
 * 谜题的并发递归
 * @since 2022/5/11
 */
public class ConcurrentPuzzleSolver<P, M> {

    private final Puzzle<P, M> puzzle;
    private final ExecutorService exec;
    private final ConcurrentMap<P, Boolean> seen;
    final ValueLatch<Node<P, M>> solution = new ValueLatch<>();

    public ConcurrentPuzzleSolver(Puzzle<P, M> puzzle, ExecutorService exec, ConcurrentMap<P, Boolean> seen) {
        this.puzzle = puzzle;
        this.exec = exec;
        this.seen = seen;
    }

    public List<M> solve() throws InterruptedException {
        try {
            P pos = puzzle.initialPosition();
            exec.execute(newTask(pos, null, null));
            Node<P, M> result = solution.getValue();
            return (result == null) ? null : result.asMoveList();
        } finally {
            exec.shutdown();
        }
    }

    protected Runnable newTask(P pos, M move, Node<P,M> prev) {
        return new SolverTask(pos, move, prev);
    }

    class SolverTask extends Node<P, M> implements Runnable {

        public SolverTask(P pos, M move, Node<P, M> prev) {
            super(pos, move, prev);
        }

        @Override
        public void run() {
            if (solution.isSet() || seen.putIfAbsent(pos, true) != null) {
                // 已经找到了解答，或者已经遍历了这个位置
                return;
            }
            if (puzzle.isGoal(pos)) {
                // 找到目标位置
                solution.setValue(this);
                return;
            }
            for (M m : puzzle.legalMove(pos)) {
                // 遍历下一个位置
                exec.execute(newTask(puzzle.move(pos, m), m, this));
            }
        }
    }
}
