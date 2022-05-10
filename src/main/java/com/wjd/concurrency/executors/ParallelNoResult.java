package com.wjd.concurrency.executors;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 《并发编程实战》-第八章-线程池的使用
 * 传入共享参数无结果的处理
 *
 * @since 2022/5/10
 */
public class ParallelNoResult {

    public <T> T getParallelResult(List<Node<T>> nodes) throws Exception {
        final ExecutorService exec = Executors.newCachedThreadPool();
        final AtomicInteger countTask = new AtomicInteger(0);

        // 递归并行计算结果
        ValueLatch<T> result = new ValueLatch<>();
        parallelRecursive(exec, nodes, result, countTask);

        // 等待计算结果
        exec.shutdown();
        exec.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);

        return result.getValue();
    }

    /**
     * 并行递归计算
     */
    public <T> void parallelRecursive(final Executor exec, List<Node<T>> nodes, final ValueLatch<T> valueLatch,
                                      final AtomicInteger countTask) {
        for (Node<T> node : nodes) {
            exec.execute(() -> {
                try {
                    // 统计任务的数量
                    countTask.incrementAndGet();
                    T result = node.compute();
                    if (result != null) {
                        // 有可能导致没有返回结果
                        valueLatch.setValue(result);
                    }
                } finally {
                    if (countTask.decrementAndGet() == 0) {
                        // 最后一个任务结束时，返回 null
                        valueLatch.setValue(null);
                    }
                }
            });
            parallelRecursive(exec, node.getChildren(), valueLatch, countTask);
        }
    }

}
