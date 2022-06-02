package com.yc.designpattern.DMB22_状态模式.DM4_project2;

import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;


/**
 * @program: design-pattern-yc
 * @description: 订单状态监听器, 一旦状态发生变化，则触发对应的事件处理  ( 观察者模式 )
 * @author: zy
 * @create: 2022-05-23 10:35
 */
@Component("orderStateListener")
@WithStateMachine(name = "orderStateMachine")  //绑定待监听的状态机
public class OrderStateListenerImpl {

    //状态转换 回调方法
    @OnTransition(source = "WAIT_PAYMENT", target = "WAIT_DELIVER")
    public boolean payTransition(Message message) {
        //***获取消息, 消息从哪里来???   注意业务类
        Order order = (Order) message.getHeaders().get("order");
        order.setStatus(OrderStatus.WAIT_DELIVER);
        System.out.println("支付，状态机反馈信息：" + message.getHeaders().toString());
        return true;
    }

    @OnTransition(source = "WAIT_DELIVER", target = "WAIT_RECEIVE")
    public boolean deliverTransition(Message message) {
        Order order = (Order) message.getHeaders().get("order");
        order.setStatus(OrderStatus.WAIT_RECEIVE);
        System.out.println("发货，状态机反馈信息：" + message.getHeaders().toString());
        return true;

    }

    @OnTransition(source = "WAIT_RECEIVE", target = "FINISH")
    public boolean receiveTransition(Message message) {
        Order order = (Order) message.getHeaders().get("order");
        order.setStatus(OrderStatus.FINISH);
        System.out.println("收货，状态机反馈信息：" + message.getHeaders().toString());
        return true;
    }

}
