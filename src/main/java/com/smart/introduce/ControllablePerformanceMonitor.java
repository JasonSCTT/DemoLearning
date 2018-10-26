package com.smart.introduce;

import com.smart.dynamic.PerformMonitor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * @author jason
 */
public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor implements Monitorable {
    private ThreadLocal<Boolean> MonitorStatusMap = new ThreadLocal<Boolean>();

    @Override
    public void setMonitorActive(boolean active) {
        MonitorStatusMap.set(active);
    }


    /*拦截方法*/
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object obj = null;
        /*对于支持性能见识可控代理，通过判断其状态决定是否开启性能监控功能*/
        if (MonitorStatusMap.get() != null && MonitorStatusMap.get()) {
            PerformMonitor.begin(mi.getClass().getName() + "." + mi.getMethod().getName());
            obj = super.invoke(mi);
            PerformMonitor.end();
        } else {
            obj = super.invoke(mi);
        }
        return obj;
    }
}
