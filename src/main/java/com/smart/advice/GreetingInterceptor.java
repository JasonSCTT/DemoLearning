package com.smart.advice;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @author jason
 */
public class GreetingInterceptor implements org.aopalliance.intercept.MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] args = methodInvocation.getArguments();

        String clientname = (String) args[0];

        System.out.println("how  are you !mr." + clientname);

        Object obj = methodInvocation.proceed();
        System.out.println("Please enjoy yourself!");
        return obj;

    }
}
