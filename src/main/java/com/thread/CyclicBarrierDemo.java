package com.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jason
 */
public class CyclicBarrierDemo {
    //徒步需要的时间
    private static int[] timeForWalk = {5, 8, 15};
    //自驾游
    private static int[] timeForSelf = {1, 3, 4};
    //旅游大巴
    private static int[] timeForBus = {2, 4, 6};

    static String nowTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }

    public static void main(String[] args) {
        Runnable runner = new Runnable() {
            @Override
            public void run() {
                System.out.println("we all are here");
            }
        };

        CyclicBarrier barrier = new CyclicBarrier(3, runner);

        ExecutorService exec = Executors.newFixedThreadPool(3);
        exec.submit(new Tour(barrier, "WalkTour", timeForWalk));
        exec.submit(new Tour(barrier, "SelfTour", timeForSelf));
        exec.submit(new Tour(barrier, "BusTour", timeForBus));
    }


    static class Tour implements Runnable {
        private int[] timeForUse;
        private CyclicBarrier barrier;
        private String tourName;

        public Tour(CyclicBarrier barrier, String tourName, int[] timeForUs) {
            this.timeForUse = timeForUs;
            this.barrier = barrier;
            this.tourName = tourName;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(timeForUse[0] * 1000);
                System.out.println(nowTime() + " " + timeForUse[0] + " " + tourName + " ReachedShenzhen");
                barrier.await();
                Thread.sleep(timeForUse[1] + 1000);
                System.out.println(nowTime() + " " + timeForUse[1] + " " + tourName + " ReachedGuangzhou");
                barrier.await();
                Thread.sleep(timeForUse[2] * 1000);
                System.out.println(nowTime() + " " + timeForUse[2] + " " + tourName + " ReachedChongqing");


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
