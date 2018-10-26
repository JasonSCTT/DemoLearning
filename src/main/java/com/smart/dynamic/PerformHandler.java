package com.smart.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformHandler implements InvocationHandler {
    private Object target;

    public PerformHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        PerformMonitor.begin(target.getClass().getName() + "." + method.getName());
        Object obj = method.invoke(target, args);
        PerformMonitor.end();
        return obj;

    }
}
