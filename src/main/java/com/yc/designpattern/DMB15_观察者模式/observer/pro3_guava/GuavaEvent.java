package com.yc.designpattern.DMB15_观察者模式.observer.pro3_guava;


import com.google.common.eventbus.Subscribe;

//观察者
public class GuavaEvent {

    //****加入此注解，表明此方法是回调方法    相当于前面的 update().
    @Subscribe  //注册
    public void a(String value){
        System.out.println("执行subscribe方法，传入的参数是：" + value);
    }


    @Subscribe
    public void b(String value){
        System.out.println("只要加了 @Subscribe 注解， 另一个被通知的方法：" + value);
    }

}
