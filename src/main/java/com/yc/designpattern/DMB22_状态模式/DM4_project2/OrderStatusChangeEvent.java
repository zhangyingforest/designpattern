package com.yc.designpattern.DMB22_状态模式.DM4_project2;

/**
 * @program: design-pattern-yc
 * @description: 订单状态改变事件枚举
 * @author: zy
 * @create: 2022-05-23 10:23
 */
public enum OrderStatusChangeEvent {
    // 支付，发货，确认收货
    PAYED, DELIVERY, RECEIVED;
}
