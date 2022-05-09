package com.wjd.concurrency.sync;

import java.util.concurrent.*;

/**
 * @since 2022/4/16
 */
public class Memoizer<K, V> {

    private final ConcurrentHashMap<K, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<K, V> computer;

    public Memoizer(Computable<K, V> c) {
        computer = c;
    }

    public V get(K key) {
        while (true) {
            Future<V> result = cache.get(key);
            if (result == null) {
                FutureTask<V> task = new FutureTask<>(() -> computer.compute(key));
                result = cache.putIfAbsent(key, task);

                // 处理并发访问的情况
                if (result == null) {
                    result = task;
                    new Thread(task).start();
                }
            }

            try {
                // 等待计算完成
                return result.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    interface Computable<K, V> {
        V compute(K key);
    }

}
