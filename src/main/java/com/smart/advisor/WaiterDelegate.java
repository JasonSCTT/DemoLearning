package com.smart.advisor;

/**
 * @author jason
 */
public class WaiterDelegate {
    private Waiter waiter;

    public void service(String clientName) {
        waiter.greetTo(clientName);
        waiter.serveTo(clientName);
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

}
