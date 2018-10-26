package com.jdk;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jason
 */
public class MainThread {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        Thread ab1 = new Thread(new subThread());

        ab1.start();

        Thread ab2 = new Thread(new subThread());
        ab2.start();

        System.out.println("jixu运行");

        long a = 1L;


    }


    static class subThread implements Runnable {
        public subThread() {
        }

        @Override
        public void run() {
            lock.lock();
//                Thread.sleep(1000L);
            System.out.println("子线程开始了。");

            lock.unlock();
        }
    }

    private static void a() {
        System.out.println("asdfasdfasdfsadfsaf");
    }
}
