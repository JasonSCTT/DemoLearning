package com.smart.aspect.aspectj;

/**
 * @author jason
 */
public class SmartSeller implements Seller {


    @Override
    public void sell(String goods, String clientName) {
        System.out.println("卖了东西" + goods + "to" + clientName);
    }


    protected int showGoods(String goods) {
        return 0;
    }
}
