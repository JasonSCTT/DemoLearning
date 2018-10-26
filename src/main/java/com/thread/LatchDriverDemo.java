package com.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author jason
 */
public class LatchDriverDemo {
    public static final int N = 5;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignla = new CountDownLatch(N);

        for (int i = 0; i < N; ++i) {
            new Thread(new LatchWorker(startSignal, doneSignla), "t" + i).start();
        }
        long start = System.nanoTime();
        startSignal.countDown();
        doneSignla.await();
        long end = System.nanoTime();
        System.out.println("all worker take time (ms) :" + (end - start) / 1000000);
    }
}

class LatchWorker implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    LatchWorker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            startSignal.await();
            doWork();
            doneSignal.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void doWork() {
        System.out.println(Thread.currentThread().getName() + " is working...");
        int sum = 0;
        for (int i = 0; i < 10000000; i++) {
            sum += i;
        }


    }
}


