package com.yc.designpattern.DMB13_策略模式.promotion;

/**
 * 优惠券
 */
public class CouponStrategy implements PromotionStrategy {

    @Override
    public void doPromotion() {
        System.out.println("领取优惠券,商品价格直接减优惠券面值抵扣");
    }
}
