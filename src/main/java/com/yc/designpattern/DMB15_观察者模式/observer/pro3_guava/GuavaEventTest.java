package com.yc.designpattern.DMB15_观察者模式.observer.pro3_guava;


import com.google.common.eventbus.EventBus;

public class GuavaEventTest {

    public static void main(String[] args) {
        //***消息总线   相当于前面的 :　主题/被观察的对象
        EventBus eventBus = new EventBus();

        //观察者.
        GuavaEvent guavaEvent = new GuavaEvent();

        eventBus.register(guavaEvent);   //将观察者注册到主题中


        //  post()是变更状态的方法
        eventBus.post(   "股价下跌了10元");   //发布新的状态, 由 eventBus消息总线通知所有的观察者.

        //从Struts到SpringMVC的升级
        //因为Struts面向的类，而SpringMVC面向的是方法

        //前面两者面向的是类，Guava面向是方法

        //能够轻松落地观察模式的一种解决方案
        //MQ
    }
}
