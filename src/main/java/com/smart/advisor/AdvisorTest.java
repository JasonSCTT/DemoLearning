package com.smart.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jason
 */
public class AdvisorTest {
    public static void main(String[] args) {

        String configpath = "/conf/advisor/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configpath);


//        Waiter waiter=(Waiter) ctx.getBean("waiter");
//        Seller seller=(Seller) ctx.getBean("seller");
//
//
//        waiter.greetTo("John");
//        waiter.serveTo("John");
//        seller.greetTo("John");


        //正则匹配增强
        Waiter waiter = (Waiter) ctx.getBean("waiter1");
        waiter.greetTo("John");
        waiter.serveTo("John");


    }


}
