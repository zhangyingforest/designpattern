package com.yc.designpattern.DMB13_策略模式.pay.payport;



public class JDPay extends Payment {

    @Override
    public String getName() {
        return "京东白条";
    }

    @Override
    protected double queryBalance(String uid) {
        return 500;
    }


}
