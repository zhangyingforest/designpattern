package com.yc.designpattern.DMB22_状态模式.DM4_project2;

/**
 * @program: design-pattern-yc
 * @description: 订单状态枚举
 * @author: zy
 * @create: 2022-05-23 10:22
 */
public enum OrderStatus {
    // 待支付，待发货，待收货，已完成
    WAIT_PAYMENT, WAIT_DELIVER, WAIT_RECEIVE, FINISH;

}