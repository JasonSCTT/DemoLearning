package com.jdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author administrator
 */
public class VolatileTest {
    public static void main(String[] args) {
        new VolatileTest().a();

    }

    private void a() {
        new Thread(new SetRunnable1()).start();
        new Thread(new SetRunnable2()).start();
        new Thread(new SetRunnable3()).start();
        new Thread(new SetRunnable4()).start();
        new Thread(new SetRunnable5()).start();
        new Thread(new ReadRunnable()).start();

    }

    int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    class SetRunnable1 implements Runnable {
        public SetRunnable1() {
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "启动了");
            setValue(1);
            System.out.println(Thread.currentThread().getName() + "--------1");
        }
    }

    class SetRunnable2 implements Runnable {
        public SetRunnable2() {
        }

        @Override
        public void run() {
            setValue(2);
            System.out.println(Thread.currentThread().getName() + "--------2");
        }
    }

    class SetRunnable3 implements Runnable {
        public SetRunnable3() {
        }

        @Override
        public void run() {
            setValue(3);
            System.out.println(Thread.currentThread().getName() + "--------3");
        }
    }

    class SetRunnable4 implements Runnable {
        public SetRunnable4() {
        }

        @Override
        public void run() {
            setValue(4);
            System.out.println(Thread.currentThread().getName() + "--------4");
        }
    }

    class SetRunnable5 implements Runnable {
        public SetRunnable5() {
        }

        @Override
        public void run() {
            setValue(5);
            System.out.println(Thread.currentThread().getName() + "--------5");
        }
    }

    class ReadRunnable implements Runnable {
        public ReadRunnable() {
        }

        @Override
        public void run() {
            System.out.println(value);
        }
    }
}

