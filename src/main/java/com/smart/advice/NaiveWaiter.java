package com.smart.advice;

/**
 * @author jason
 */
public class NaiveWaiter implements Waiter {
    @Override
    public void greetTt(String name) {
        System.out.println("greet to " + name + "...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serving " + name + "...");
    }
}
