package com.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author jason
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 9999;

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("the time server is start in port : " + port);
            Socket socket = null;
            while (true) {
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (server != null) {
                System.out.println("the time server close");
                server.close();
                server = null;
            }
        }
    }
}
