package com.sort;

import java.util.HashSet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jason
 */
public class TestMain {
    public static void main(String[] args) {
        System.out.println(ouput());

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 5, 1000, TimeUnit.MINUTES, new LinkedBlockingDeque<Runnable>());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("i");
            }
        });

    }

    static int ouput() {
        int x = 1;
        try {
            return x;
        } finally {
            ++x;
        }
    }
}
