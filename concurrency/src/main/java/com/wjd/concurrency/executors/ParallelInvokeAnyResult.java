package com.wjd.concurrency.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 《并发编程实战》-第八章-线程池的使用
 * 通过invokeAny等待单个结果
 *
 * @since 2022/5/10
 */
public class ParallelInvokeAnyResult {

    public <T> T getParallelResult(List<Node<T>> nodes) throws Exception {
        // 统计所有迭代节点，节点之间相互独立
        List<Node<T>> allNodes = new ArrayList<>();
        for (Node<T> node : nodes) {
            collectAllNodes(node, allNodes);
        }

        // 所有节点的计算任务
        List<Callable<T>> tasks = new ArrayList<>(allNodes.size());
        for (Node<T> node : nodes) {
            tasks.add(node::compute);
        }

        // 并行方式计算
        final ExecutorService exec = Executors.newCachedThreadPool();

        // 注意：返回结果可能为null
        T result = exec.invokeAny(tasks);

        return result;
    }

    /**
     * 收集所有节点
     */
    private <T> void collectAllNodes(Node<T> node, List<Node<T>> allNodes) {
        allNodes.add(node);
        if (node.getChildren() != null) {
            for (Node<T> c : node.getChildren()) {
                collectAllNodes(c, allNodes);
            }
        }
    }

}
