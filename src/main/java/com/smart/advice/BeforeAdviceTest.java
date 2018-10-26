package com.smart.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.testng.annotations.Test;

/**
 * @author jason
 */
public class BeforeAdviceTest {


    @Test
    public void before() {
        Waiter target = new NaiveWaiter();

        BeforeAdvice advice = new GreetingBeforeAdvice();

        ProxyFactory pf = new ProxyFactory();
        //如果指定对接口进行代理，将使用jdk动态代理技术
//       pf.setInterfaces(target.getClass().getInterfaces());

        // 启动优化，则还是会使用cglib代理方式
//        pf.setOptimize(true);

        pf.setTarget(target);

        pf.addAdvice(advice);

        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTt("John");
        proxy.serveTo("Tom");


    }


}
