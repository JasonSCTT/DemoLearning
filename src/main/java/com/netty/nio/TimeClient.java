package com.netty.nio;

/**
 * @author jason
 */
public class TimeClient {
    static int port = 9090;

    public static void main(String[] args) {
        new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-001").start();
    }
}
