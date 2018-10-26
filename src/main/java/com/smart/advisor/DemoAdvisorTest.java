package com.smart.advisor;

import com.smart.Utils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jason
 */
public class DemoAdvisorTest {

    public void dynamic() {
        ApplicationContext ctx = Utils.getApplicationContext("/conf/advisor/beans.xml");
        /*spring会在创建代理切面时候，对于目标类中的素有方法进行静态切点检查*/
        Waiter waiter = (Waiter) ctx.getBean("waiter2");
        waiter.serveTo("Peter");
        waiter.greetTo("Peter");

        waiter.greetTo("John");
    }

    @Test
    public void Flow() {
        ApplicationContext ctx = Utils.getApplicationContext("/conf/advisor/beans.xml");

        Waiter waiter = (Waiter) ctx.getBean("waiter3");

        WaiterDelegate wd = new WaiterDelegate();

        wd.setWaiter(waiter);

        waiter.serveTo("Peter");
        waiter.greetTo("Peter");
        wd.service("Peter");
    }


    @Test
    public void Interseaction() {
        ApplicationContext ctx = Utils.getApplicationContext("/conf/advisor/beans.xml");

        Waiter waiter = (Waiter) ctx.getBean("waiter4");

        WaiterDelegate wd = new WaiterDelegate();

        wd.setWaiter(waiter);

        waiter.serveTo("Peter");
        waiter.greetTo("Peter");
        wd.service("Peter");
    }

    @Test
    public void GreetToInfo() {
        ApplicationContext ctx = Utils.getApplicationContext("/conf/advisor/beans.xml");

        Waiter waiter = (Waiter) ctx.getBean("waiterbak");
        Seller seller = (Seller) ctx.getBean("sellerbak");
        waiter.greetTo("John");
        seller.greetTo("Tom");
    }
}