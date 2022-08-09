package com.wjd.concurrency.cas.random;

/**
 * 《并发编程实战》-第15章
 *  随机数
 * @since 2022/4/27
 */
public class PseudoRandom {

    public int nextInt(int n) {
        return calculateNext(n);
    }

    public int calculateNext(int y) {
        y ^= (y << 6);
        y ^= (y >>> 21);
        y ^= (y << 7);
        return y;
    }

}
