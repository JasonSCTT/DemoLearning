package com.smart.aspect.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jason
 */
public class DeclaredParentsTest {
    public static void main(String[] args) {

        /*在EnableSellerAspect切面中，通过@DeclareParents为NaiveWaiter添加了一个需要实现的Seller接口，并制定了默认实现类为SmartSeller*/
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/conf/advisor/aspect.xml");

        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("John");
        Seller seller = (Seller) waiter;
        seller.sell("beer", "jason");
    }
}
