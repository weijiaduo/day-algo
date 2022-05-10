package com.wjd.concurrency.executors.puzzle;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 《并发编程实战》-第八章-线程池的使用
 * 谜题没有解答的并发递归
 * @since 2022/5/11
 */
public class PuzzleSolver<P, M> extends ConcurrentPuzzleSolver<P, M> {

    private final AtomicInteger taskCount = new AtomicInteger(0);

    public PuzzleSolver(Puzzle<P, M> puzzle, ExecutorService exec, ConcurrentMap<P, Boolean> seen) {
        super(puzzle, exec, seen);
    }

    @Override
    protected Runnable newTask(P pos, M move, Node<P, M> prev) {
        return new CountingSolverTask(pos, move, prev);
    }

    private class CountingSolverTask extends SolverTask {
        public CountingSolverTask(P pos, M move, Node<P, M> prev) {
            super(pos, move, prev);
            taskCount.incrementAndGet();
        }

        @Override
        public void run() {
            try {
                super.run();
            } finally {
                if (taskCount.decrementAndGet() == 0) {
                    // 最后一个任务直接结束
                    solution.setValue(null);
                }
            }
        }
    }
}
