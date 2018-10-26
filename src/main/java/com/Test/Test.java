package com.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jason
 */
public class Test {
    public static void changeStr(String str) {
        str = "all";
    }

    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger();
        integer.set(0);
        System.out.println(integer.compareAndSet(0, 3));
        System.out.println(integer.get());


        CountDownLatch cdl = new CountDownLatch(5);
        try {
            while (true) {
                cdl.countDown();
                cdl.await();
                break;
            }
            System.out.println("asdfadsfasd");
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
