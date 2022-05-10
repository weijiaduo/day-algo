package com.wjd.concurrency.executors;

import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * 《并发编程实战》-第八章-线程池的使用
 * 传入共享参数获取多个结果
 *
 * @since 2022/5/10
 */
public class ParallelParamQueueResults {

    public <T> Collection<T> getParallelResults(List<Node<T>> nodes) throws InterruptedException {
        // 并行方式计算
        final ExecutorService exec = Executors.newCachedThreadPool();
        final Queue<T> resultQueue = new ConcurrentLinkedQueue<>();

        // 递归并行计算结果
        parallelRecursive(exec, nodes, resultQueue);

        // 等待计算结果
        exec.shutdown();
        exec.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);

        return resultQueue;
    }

    /**
     * 并行递归计算
     */
    public <T> void parallelRecursive(final Executor exec, List<Node<T>> nodes, final Collection<T> results) {
        for (Node<T> node : nodes) {
            exec.execute(() -> {
                results.add(node.compute());
            });
            parallelRecursive(exec, node.getChildren(), results);
        }
    }

}
