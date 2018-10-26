package com.smart.dynamic;

import org.junit.Test;

import java.lang.reflect.Proxy;

/*
 * jdk动态代理
 *
 *
 * */
public class Demo {
    public void proxy() {
        ServiceImpl target = new ServiceImpl();

        PerformHandler handler = new PerformHandler(target);

        /*
         *
         * 缺点就是只能为接口创建代理实例，动态代理技术黔驴技穷，CGlib作为替代者。填补了空缺
         * */
        Service proxy = (Service) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
        proxy.removeForm(10);
        proxy.removeTopic(1012);
    }

    @Test
    public void cglibProxy() {
        CglibProxy proxy = new CglibProxy();
        ServiceImpl service = (ServiceImpl) proxy.getProxy(ServiceImpl.class);
        service.removeTopic(10);
        service.removeForm(1000);
    }


}
