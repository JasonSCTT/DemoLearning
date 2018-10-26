package com.netty.nio;

/**
 * @author jason
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 9090;

        MutiplexerTimeServer timeServer = new MutiplexerTimeServer(port);

        new Thread(timeServer, "NIO-MutipleexerTimeServer-001").start();
    }
}
