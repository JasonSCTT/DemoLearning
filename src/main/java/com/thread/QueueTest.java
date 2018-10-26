package com.thread;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jason
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue queue = new LinkedList();

        queue.offer("One");
        queue.offer("Two");
        queue.offer("Three");
        queue.offer("Four");
        System.out.println("Head of queue is : " + queue.poll());

    }
}
