package com.thread;

import java.util.concurrent.Semaphore;

/**
 * @author jason
 */
public class PoolSemaphoreDemo {
    private static final int MAX_AVAILABLE = 5;
    private final Semaphore avaiable = new Semaphore(MAX_AVAILABLE, true);

    public static void main(String[] args) {
        final PoolSemaphoreDemo pool = new PoolSemaphoreDemo();

        Runnable runner = new Runnable() {
            @Override
            public void run() {
                try {
                    Object o;
                    o = pool.getItem();
                    System.out.println(Thread.currentThread().getName() + "acquire" + o);

                    Thread.sleep(1000);
                    pool.putItem(o);
                    System.out.println(Thread.currentThread().getName() + "release" + o);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(runner, "t" + i);
            t.start();
        }
    }


    public Object getItem() throws InterruptedException {
        avaiable.acquire();
        return getNextAvailableItem();
    }

    public void putItem(Object x) {
        if (markAsUnused(x)) {
            avaiable.release();
        }
    }

    protected Object[] items = {"AAA", "BBB", "CCC", "DDD", "EEE"};
    protected boolean[] used = new boolean[MAX_AVAILABLE];

    protected synchronized Object getNextAvailableItem() {
        for (int i = 0; i < MAX_AVAILABLE; ++i) {
            if (!used[i]) {
                used[i] = true;
                return items[i];
            }
        }
        return null;
    }

    protected synchronized boolean markAsUnused(Object item) {
        for (int i = 0; i < MAX_AVAILABLE; ++i) {
            if (item == items[i]) {
                if (used[i]) {
                    used[i] = false;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }


}
