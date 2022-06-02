package com.yc.designpattern.DMB13_策略模式.promotion;

/**
 * 拼团优惠
 */
public class GroupbuyStrategy implements PromotionStrategy{

    @Override
    public void doPromotion() {
        System.out.println("拼团，满20人成团，全团享受团购价");
    }
}
