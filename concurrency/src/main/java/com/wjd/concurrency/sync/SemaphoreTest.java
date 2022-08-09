package com.wjd.concurrency.sync;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * @since 2022/4/16
 */
public class SemaphoreTest {

    class BoundHashSet<T> {
        private final Set<T> set;
        private final Semaphore sem;

        public BoundHashSet(int bound) {
            set = Collections.synchronizedSet(new HashSet<>());
            sem = new Semaphore(bound);
        }

        public boolean add(T o) throws InterruptedException {
            sem.acquire();
            boolean wasAdded = false;
            try {
                wasAdded = set.add(o);
                return wasAdded;
            } finally {
                if (!wasAdded) {
                    sem.release();
                }
            }
        }

        public boolean remove(T o) {
            boolean wasRemoved = set.remove(o);
            if (wasRemoved) {
                sem.release();
            }
            return wasRemoved;
        }
    }

}
