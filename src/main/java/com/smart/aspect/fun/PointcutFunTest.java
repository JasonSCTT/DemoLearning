package com.smart.aspect.fun;

import com.smart.Utils;
import com.smart.aspect.aspectj.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

/**
 * @author jason
 */
public class PointcutFunTest {
    @Test
    public void pointcut() {
        ApplicationContext ctx = Utils.getApplicationContext("/conf/advisor/aspect.xml");

        Waiter waiter = (Waiter) ctx.getBean("naiveWaiter");

        Waiter naughtyWaiter = (Waiter) ctx.getBean("naughtyWaiter");

        waiter.greetTo("John");
        naughtyWaiter.greetTo("Tom");

    }
}
