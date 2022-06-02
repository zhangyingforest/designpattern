package com.yc.designpattern.DMB13_策略模式.promotion;

/**
 * 促销活动
 */
public class PromotionActivityTest {

    public static void main(String[] args) {
        //618的活动
        PromotionActivity activity618 = new PromotionActivity(new CouponStrategy());
        // 双11的活动
        PromotionActivity activity1111 = new PromotionActivity(new CashbackStrategy());

        activity618.execute();
        activity1111.execute();
    }

//    public static void main(String[] args) {
//        PromotionActivity promotionActivity = null;
//
//        String promotionKey = "COUPON";
//
//        if(StringUtils.equals(promotionKey,"COUPON")){
//            promotionActivity = new PromotionActivity(new CouponStrategy());
//        }else if(StringUtils.equals(promotionKey,"CASHBACK")){
//            promotionActivity = new PromotionActivity(new CashbackStrategy());
//        }//......
//        promotionActivity.execute();
//    }


//    public static void main(String[] args) {
//        String promotionKey = "GROUPBUY";
//        PromotionActivity promotionActivity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
//        promotionActivity.execute();
//    }

}
