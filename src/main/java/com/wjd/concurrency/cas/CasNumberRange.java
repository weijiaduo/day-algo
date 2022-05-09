package com.wjd.concurrency.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 《并发编程实战》-第15章
 *  原子变量 + 不可变对象实现多状态更新
 * @since 2022/4/27
 */
public class CasNumberRange {

    private static class IntPair {
        // 不变性条件：lower <= upper
        final int lower;
        final int upper;

        public IntPair(int lower, int upper) {
            this.lower = lower;
            this.upper = upper;
        }
    }

    private final AtomicReference<IntPair> values = new AtomicReference<>(new IntPair(0, 0));

    public int getLower() {
        return values.get().lower;
    }

    public int getUpper() {
        return values.get().upper;
    }

    public void setLower(int i) {
        while (true) {
            IntPair oldValue = values.get();
            if (i > oldValue.upper) {
                throw new IllegalArgumentException("Can't set lower to " + i + " > upper");
            }
            IntPair newValue = new IntPair(i, oldValue.upper);
            if (values.compareAndSet(oldValue,newValue)) {
                break;
            }
        }
    }

    public void setUpper(int i) {
        while (true) {
            IntPair oldValue = values.get();
            if (i < oldValue.lower) {
                throw new IllegalArgumentException("Can't set upper to " + i + " < lower");
            }
            IntPair newValue = new IntPair(oldValue.lower, i);
            if (values.compareAndSet(oldValue,newValue)) {
                break;
            }
        }
    }

    @Override
    public String toString() {
        IntPair value = values.get();
        return "(" + value.lower + ", " + value.upper + ")";
    }

}
