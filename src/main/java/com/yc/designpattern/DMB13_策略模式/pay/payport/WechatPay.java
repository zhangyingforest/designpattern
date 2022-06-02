package com.yc.designpattern.DMB13_策略模式.pay.payport;


public class WechatPay extends Payment {

    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 256;
    }

}
