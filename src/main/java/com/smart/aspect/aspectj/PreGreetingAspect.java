package com.smart.aspect.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author jason
 */


@Aspect
public class PreGreetingAspect {

    @Before("execution(* greetTo(..))")
    public void beforeGreeting() {
        System.out.println("How are you ");
    }
}
