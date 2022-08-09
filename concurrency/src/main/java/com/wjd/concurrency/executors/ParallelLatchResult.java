package com.wjd.concurrency.executors;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 《并发编程实战》-第八章-线程池的使用
 * 传入共享参数获取单个结果
 *
 * @since 2022/5/10
 */
public class ParallelLatchResult {

    public <T> T getParallelResult(List<Node<T>> nodes) throws Exception {
        final ExecutorService exec = Executors.newCachedThreadPool();

        // 递归并行计算结果
        ValueLatch<T> result = new ValueLatch<>();
        parallelRecursive(exec, nodes, result);

        // 等待计算结果
        exec.shutdown();
        exec.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);

        // 注意：可能没有返回结果，导致一直阻塞
        return result.getValue();
    }

    /**
     * 并行递归计算
     */
    public <T> void parallelRecursive(final Executor exec, List<Node<T>> nodes, final ValueLatch<T> valueLatch) {
        for (Node<T> node : nodes) {
            exec.execute(() -> {
                T result = node.compute();
                if (result != null) {
                    // 有可能导致没有返回结果
                    valueLatch.setValue(result);
                }
            });
            parallelRecursive(exec, node.getChildren(), valueLatch);
        }
    }

}
