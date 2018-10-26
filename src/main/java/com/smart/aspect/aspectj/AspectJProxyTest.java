package com.smart.aspect.aspectj;

import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @author jason
 */
public class AspectJProxyTest {

    @Test
    public void a() {


        Waiter target = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();

        factory.setTarget(target);

        factory.addAspect(PreGreetingAspect.class);
        Waiter proxy = factory.getProxy();

        proxy.greetTo("John");
        proxy.serveTo("John");


    }
}
