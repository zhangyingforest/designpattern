package com.yc.designpattern.DMB13_策略模式.promotion;

/**
 * 返现活动
 */
public class CashbackStrategy implements PromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("返现促销,返回的金额转到支付宝账号");
    }
}
