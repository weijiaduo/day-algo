package com.wjd.concurrency.thread;

/**
 * @since 2022/3/20
 */
public class StopThreadTest {

    private static User user = new User();

    public static void main(String[] args) throws InterruptedException {
        // 调用Thread.stop()方法
        // testThreadStop();
        // 通知Thread自己结束
        testSelfStop();
    }

    /**
     * 调用Thread.stop()方法
     */
    public static void testThreadStop() throws InterruptedException {
        new ReadObjectThread().start();
        for (int i = 0; i < 100; i++) {
            Thread t = new WriteObjectThread();
            t.start();
            Thread.sleep(100);
            t.stop();
        }
    }

    /**
     * 通知Thread自己结束
     */
    public static void testSelfStop () throws InterruptedException {
        new ReadObjectThread().start();
        for (int i = 0; i < 100; i++) {
            WriteObjectThread t = new WriteObjectThread();
            t.start();
            Thread.sleep(100);
            t.stopMe();
        }
    }

    static class User {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    static class WriteObjectThread extends Thread {

        volatile boolean stoped = false;

        public void stopMe() {
            stoped = true;
        }

        @Override
        public void run() {
            while(true) {
                if (stoped) {
                    System.out.println("exit by stop");
                    break;
                }
                synchronized (user) {
                    int v = (int) (System.currentTimeMillis() / 1000);
                    user.setId(v);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }

    static class ReadObjectThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (user) {
                    if (user.getName() != null && user.getId() != Integer.parseInt(user.getName())) {
                        System.out.println(user);
                    }
                }
                Thread.yield();
            }
        }
    }

}


