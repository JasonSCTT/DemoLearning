package com.smart.schema;

import com.smart.aspect.aspectj.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jason
 */
public class Test {
    @org.junit.Test
    public void Test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/conf/advisor/aop.xml");

        Waiter naiveWaiter = (Waiter) ctx.getBean("naiveWaiter");
        Waiter naughtyWaiter = (Waiter) ctx.getBean("naughtyWaiter");
        naiveWaiter.greetTo("John");
        naughtyWaiter.greetTo("Tom");
    }
}
