package com.wjd.concurrency.thread;

/**
 * @since 2022/3/21
 */
public class GroupThreadTest {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new GroupThread("T" + i).start();
        }
    }

    static class GroupThread extends Thread {
        static ThreadGroup group = new ThreadGroup("Group");

        GroupThread(String name) {
            super(group, name);
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(getThreadGroup().getName() + "-" + getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
