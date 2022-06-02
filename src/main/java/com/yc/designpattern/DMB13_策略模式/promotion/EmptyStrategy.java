package com.yc.designpattern.DMB13_策略模式.promotion;

/**
 * 无优惠
 */
public class EmptyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("无促销活动");
    }
}
