package com.thread;

import com.mysql.jdbc.TimeUtil;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author jason
 */
public class FutureTaskDemo {
    public static void main(String[] args) {
        Callable pAccount = new PrivateAccount();

        FutureTask futuretask = new FutureTask(pAccount);

        Thread pAccountThread = new Thread(futuretask);
        System.out.println("future task starts at " + System.nanoTime());

        pAccountThread.start();

        System.out.println("main thread doing something else here.");

        int totalMoney = new Random().nextInt(100000);
        System.out.println(" you have " + totalMoney + " in your other accounts ");
        System.out.println("Waiting for data from Private Account");


        while (!futuretask.isDone()) {
            try {
                System.out.println("还没有执行完毕");
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("future task ends at " + System.nanoTime());


        Integer privateAccountMoney = null;

        try {
            privateAccountMoney = (Integer) futuretask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(" the total money you have is " + totalMoney + "-" + privateAccountMoney.intValue());


    }
}

class PrivateAccount implements Callable {
    Integer totalMoney;

    @Override
    public Object call() throws Exception {
        Thread.sleep(5000);
        totalMoney = new Integer(new Random().nextInt(10000));
        System.out.println(" you  have " + totalMoney + " in your private Account. ");
        return totalMoney;
    }
}
