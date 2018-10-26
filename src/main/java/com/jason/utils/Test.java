package com.jason.utils;

import com.jason.pojo.User;

/**
 * Created by shencheng6 on 2018/10/25.
 */
public class Test {
    public static void main(String[] args) {
        User user = new User();


        if ("aaa".equals(user.getLoginname())) {
            System.out.println("13241342");
        } else {
            System.out.println("13241324");
        }

        if (user.getId() < 100000L) {
            System.out.println("134123423");
        }

        System.out.println(user.getId());
    }
}
