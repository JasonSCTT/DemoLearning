package com.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author jason
 */
public class CTMap {
    public static void main(String[] args) {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<String, String>();
        map.put("a", "b");
        System.out.println(map.putIfAbsent("b", "b"));
        System.out.println(map.remove("a", "b"));


    }
}
