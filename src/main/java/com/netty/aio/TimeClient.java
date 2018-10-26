package com.netty.aio;

/**
 * @author jason
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 9500;

        new Thread(new AsyncTimeClientHandler("127.0.0.1", port), "AIO-AsyncTimeClientHandler-001").start();
        ;
    }
}
