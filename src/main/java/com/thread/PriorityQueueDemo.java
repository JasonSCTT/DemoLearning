package com.thread;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jason
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<String>();
        queue.offer("One");
        queue.offer("Two");
        queue.offer("Three");
        queue.offer("Four");
        System.out.println("Head of queue is : " + queue.poll());

    }
}
