package com.smart.aspect.fun;

import com.smart.aspect.anno.NeedTest;
import com.smart.aspect.aspectj.Waiter;

/**
 * @author jason
 */
public class NaughtyWaiter implements Waiter {
    @NeedTest
    @Override
    public void greetTo(String name) {
        System.out.println("NaughtyWaiter:greet to " + name + "...");
    }


    @Override
    public void serveTo(String name) {

    }
}
