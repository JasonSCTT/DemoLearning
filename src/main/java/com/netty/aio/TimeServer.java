package com.netty.aio;

/**
 * @author jason
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 9500;
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
    }
}
