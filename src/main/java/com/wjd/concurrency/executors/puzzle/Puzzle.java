package com.wjd.concurrency.executors.puzzle;

import java.util.Set;

/**
 * 《并发编程实战》-第八章-线程池的使用
 * 谜题
 * @since 2022/5/11
 */
public interface Puzzle<P, M> {
    P initialPosition();
    boolean isGoal(P position);
    Set<M> legalMove(P position);
    P move(P position, M move);
}
