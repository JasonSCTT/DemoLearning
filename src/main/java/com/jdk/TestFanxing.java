package com.jdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author jason
 */
public class TestFanxing {
    public static void main(String[] args) {
        List<String> a = new ArrayList();
        a.add("a");
        a.add("b");

        Map<String, String> map = new HashMap<>();
        map.put("jason", "a");
        map.put("jason", "b");

        System.out.println(a(a));


    }


    public static String a(List<String> a) {
        System.out.println("list string");
        return "adsf";
    }

    public String a(String a, String b, String c) {
        return a + b + c;
    }

//    public static  int a(List<Integer> a){
//        System.out.println("list integer");
//        return 1;
//    }

}
