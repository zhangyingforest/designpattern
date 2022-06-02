package com.yc.designpattern.DMB22_状态模式.DM4_project2;

import java.util.Map;

/**
 * @program: design-pattern-yc
 * @description: 订单业务类
 * @author: zy
 * @create: 2022-05-23 10:37
 */
public interface OrderService {
    //创建订单
    Order create();
    //发起支付
    Order pay(int id);
    //订单发货
    Order deliver(int id);
    //订单收货
    Order receive(int id);


    //获取所有订单信息
    Map getOrders();
}

