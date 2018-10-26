package com.smart.aspect.aspectj;


/**
 * @author jason
 */
public class NaiveWaiter implements Waiter {
    @Override
    public void greetTo(String name) {
        System.out.println("naiveWaiter:greet to " + name + "...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("naiveWaiter:serve to " + name + "...");
    }

    public void smile(String clientName, int times) {
        System.out.println(clientName + "smile" + times + "次");
    }
}
