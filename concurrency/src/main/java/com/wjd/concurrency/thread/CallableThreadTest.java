package com.wjd.concurrency.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @since 2022/3/21
 */
public class CallableThreadTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new CallableThread());
        new Thread(task).start();

        String result = task.get();
        System.out.println(result);
    }

    static class CallableThread implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            return "CallableThread";
        }
    }

}
