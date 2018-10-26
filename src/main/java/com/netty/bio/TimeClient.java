package com.netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author jason
 */
public class TimeClient {
    public static void main(String[] args) throws IOException {
        int port = 9999;

        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            socket = new Socket("localhost", port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("QUERY TIME ORDER");
            System.out.println("Send order 2 server sujcceed");
            String resp = in.readLine();
            System.out.println("Now is : " + resp);


        } catch (Exception e) {

        } finally {
            if (out != null) {
                out.close();
                out = null;
            }
            if (in != null) {
                in.close();
            }
            in = null;

            if (socket != null) {
                socket.close();
            }
            socket = null;
        }
    }
}
