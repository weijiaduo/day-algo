package com.wjd.concurrency.lock;

/**
 * @since 2022/3/21
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        new SynchronizedInstance().syncInMethod();
    }

    static class SynchronizedInstance {

        /**
         * synchronized修饰在实例方法上，等价于synchronized(this)
         */
        public synchronized void syncOnMethod() {
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
            }
        }

        public void syncInMethod() {
            synchronized (this) {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(i);
                }
            }
        }
    }

    static class SynchronizedStatic {

        /**
         * synchronized修饰在静态方法上，等价于synchronized(xx.class)
         */
        public static synchronized void syncOnMethod() {
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
            }
        }

        public static void syncInMethod() {
            synchronized (SynchronizedStatic.class) {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(i);
                }
            }
        }
    }

    static class SynchronizedOtherObject {

        static Object mutex = new Object();

        public void syncInstanceMethod() {
            synchronized (mutex) {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(i);
                }
            }
        }

        public static void syncStaticMethod() {
            synchronized (mutex) {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(i);
                }
            }
        }
    }

}
