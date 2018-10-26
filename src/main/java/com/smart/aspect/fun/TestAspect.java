package com.smart.aspect.fun;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author jason
 */
@Aspect
public class TestAspect {

/*    @AfterReturning("@annotation(com.smart.aspect.anno.NeedTest)")
    public void needTestFun(){
        System.out.println("needTestFun() executed");
    }*/

    @After("within(com.smart.*)" + "&& execution(* greetTo(..)))")
    public void greetToFun() {
        System.out.println("--greetToFun() executed!--");
    }

    @Before(" !target(com.smart.aspect.aspectj.Waiter) && execution(* serveTo(..))")
    public void notServeInNaiveWaiter() {
        System.out.println("--notServeInNaiveWaiter() executed!--");
    }

    @AfterReturning("target(com.smart.aspect.aspectj.Waiter) || target(com.smart.aspect.aspectj.Seller)")
    public void waiterOrSeller() {
        System.out.println("--waiterOrSeller() executed!--");
    }


}
