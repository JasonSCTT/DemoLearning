package com.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * @author jason
 */
public class ExchangeDemo {


    public static void main(String[] args) {
        ExchangeDemo et = new ExchangeDemo();
        new Thread(et.new DataProducer()).start();
        new Thread(et.new DataConsumer()).start();
    }

    private static final Exchanger ex = new Exchanger();

    class DataProducer implements Runnable {
        private List list = new ArrayList();

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("生产了一个数据");
                list.add("woshiyige ren " + i);
            }
            try {
                list = (List) ex.exchange(list);

            } catch (Exception e) {
                e.printStackTrace();
            }

            for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
                System.out.println("producer " + iterator.next());
            }


        }


    }

    class DataConsumer implements Runnable {
        private List list = new ArrayList();

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("生产了一个数据");
                list.add("我是一个住 " + i);
            }
            try {
                list = (List) ex.exchange(list);

            } catch (Exception e) {
                e.printStackTrace();
            }

            for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
                System.out.println("consumer " + iterator.next());
            }


        }


    }

}
