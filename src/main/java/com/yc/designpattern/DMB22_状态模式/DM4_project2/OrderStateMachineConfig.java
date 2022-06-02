package com.yc.designpattern.DMB22_状态模式.DM4_project2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import java.util.EnumSet;

/**
 * @program: design-pattern-yc
 * @description: 订单状态机配置类
 * 构造一个状态机有两种方式：
 *      １。使用构造器工具类 StateMachineBuilder.builder()     (构造器模式，硬编码)
 *      ２。＊＊＊使用javaConfig的形式，扩展EnumStateMachineConfigurerAdapter<States, Events>类，并覆盖configure方法完成状态机配置。
 * @author: zy
 * @create: 2022-05-23 10:24
 */
@Configuration
@EnableStateMachine(name = "orderStateMachine")   //启用状态机
public class OrderStateMachineConfig extends StateMachineConfigurerAdapter<OrderStatus, OrderStatusChangeEvent> {

    /**
     * 配置  初始 状态
     * @param states
     * @throws Exception
     */
    @Override
    public void configure(StateMachineStateConfigurer<OrderStatus, OrderStatusChangeEvent> states) throws Exception {
        states
                .withStates()
                .initial(OrderStatus.WAIT_PAYMENT)    //配置初始状态  等待状态
                .states(EnumSet.allOf(OrderStatus.class));
    }

    /**
     * 配置状态转换事件关系
     *
     * @param transitions  转换操作（多个) 要配置每个转换节点的    :  源状态  +事件 +  目标状态
     * @throws Exception
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStatus, OrderStatusChangeEvent> transitions) throws Exception {
        transitions
                //配置从 等待支付态到 等待发货态   并配置转换事件
                .withExternal().source(OrderStatus.WAIT_PAYMENT).target(OrderStatus.WAIT_DELIVER).event(OrderStatusChangeEvent.PAYED)
                .and()
                //配置从 等待发货态  到等待收货态 并配置转换事件
                .withExternal().source(OrderStatus.WAIT_DELIVER).target(OrderStatus.WAIT_RECEIVE).event(OrderStatusChangeEvent.DELIVERY)
                .and()
                //配置从等待收货态到完成态，并配置事件.
                .withExternal().source(OrderStatus.WAIT_RECEIVE).target(OrderStatus.FINISH).event(OrderStatusChangeEvent.RECEIVED);
    }

    /**
     * 持久化配置   由spring托管
     * 实际使用中，可以配合redis等，进行持久化操作
     *
     * @return
     */
    @Bean
    public DefaultStateMachinePersister persister() {
        return new DefaultStateMachinePersister<>(new StateMachinePersist<Object,Object,Order>() {
            @Override
            public void write(StateMachineContext stateMachineContext, Order o) throws Exception {
                //TODO:此处可以对 order对象   进行  redis/数据库  持久化操作

            }

            @Override
            public StateMachineContext read(Order order) throws Exception {

                //TODO: 此处从数据库中读取order的信息，存到  context上下文中.  并绑定下一个要处理的事件.
                return new DefaultStateMachineContext(order.getStatus(), null, null, null);
            }

        });

    }

}

