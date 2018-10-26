package com.thread;

import java.util.concurrent.*;

/**
 * @author jason
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;

    private static Semaphore s = new Semaphore(5);

    public static void main(String[] args) {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(2, 10, 1000l, TimeUnit.MINUTES, new LinkedBlockingDeque<Runnable>());

        for (int i = 0; i < THREAD_COUNT; i++) {
            tpe.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(s.availablePermits());
                        s.acquire();
                        System.out.println("save data");

                        s.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        tpe.shutdown();
    }
}