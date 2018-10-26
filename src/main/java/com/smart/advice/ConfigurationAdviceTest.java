package com.smart.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jason
 */
public class ConfigurationAdviceTest {
    public static void main(String[] args) {
        String configuration = "classpath:/AdviceBeans.xml";

        ApplicationContext ctx = new ClassPathXmlApplicationContext(configuration);

        ForumService waiter = (ForumService) ctx.getBean("service");
        waiter.removeForm(10);

        waiter.updateForum();


    }
}
