package com.yc.designpattern.DMB22_状态模式.DM4_project2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: design-pattern-yc
 * @description:  订单的业务类: 结合状态机来完成.
 * @author: zy
 * @create: 2022-05-23 10:38
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired //状态机对象     相当于  context 上下文
    private StateMachine orderStateMachine;
    @Autowired   //持久化器
    private StateMachinePersister persister;

    private int id = 1;
    //此处将来可以用  redis代替, 表示 下的order
    private Map orders = new HashMap<>();

    @Override
    public Order create() {
        Order order = new Order();
        //已下单(临时单)，等待支付状态
        order.setStatus(OrderStatus.WAIT_PAYMENT);
        order.setId(id++);
        orders.put(order.getId(), order);
        return order;
    }

    @Override
    public Order pay(int id) {
        //查到待支付的临时单号
        Order order = (Order) orders.get(id);
        System.out.println("线程名称：" + Thread.currentThread().getName() + " 尝试支付，订单号：" + id);
        //构造一条消息出来.     构造器模式.
        // 流程: 支付过程：创建一条消息，传到状态机  -》状态机收到此消息，触发对应的事件，完成处理
        Message message = MessageBuilder.withPayload(OrderStatusChangeEvent.PAYED)
                .setHeader("order", order).build();
        if (!sendEvent(message, order)) {
            System.out.println("线程名称：" + Thread.currentThread().getName() + " 支付失败, 状态异常，订单号：" + id);
        }
        return (Order) orders.get(id);
    }

    @Override
    public Order deliver(int id) {
        Order order = (Order) orders.get(id);
        System.out.println("线程名称：" + Thread.currentThread().getName() + " 尝试发货，订单号：" + id);
        if (!sendEvent(MessageBuilder.withPayload(OrderStatusChangeEvent.DELIVERY)
                .setHeader("order", order).build(), (Order) orders.get(id))) {
            System.out.println("线程名称：" + Thread.currentThread().getName() + " 发货失败，状态异常，订单号：" + id);
        }
        return (Order) orders.get(id);

    }

    @Override
    public Order receive(int id) {
        Order order = (Order) orders.get(id);
        System.out.println("线程名称：" + Thread.currentThread().getName() + " 尝试收货，订单号：" + id);
        if (!sendEvent(MessageBuilder.withPayload(OrderStatusChangeEvent.RECEIVED).setHeader("order", order).build(), (Order) orders.get(id))) {
            System.out.println("线程名称：" + Thread.currentThread().getName() + " 收货失败，状态异常，订单号：" + id);
        }
        return (Order) orders.get(id);
    }

    @Override
    public Map getOrders() {
        return orders;
    }

    /**
     * 发送订单状态转换事件
     *
     * @param message
     * @param order
     * @return
     */
    private synchronized boolean sendEvent(Message message, Order order) {
        boolean result = false;
        try {
            orderStateMachine.start();
            //尝试恢复状态机状态
            persister.restore(orderStateMachine, order);
            //添加延迟用于线程安全测试
            Thread.sleep(1000);
            result = orderStateMachine.sendEvent(message);
            //持久化状态机状态
            persister.persist(orderStateMachine, order);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            orderStateMachine.stop();
        }
        return result;
    }

}

