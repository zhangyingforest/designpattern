package com.yc.designpattern.DMB15_观察者模式.DM1;

/**
 * 具体观察者（Concrete Observer）角色：实现抽象观察者中定义的抽象方法，以便在得到目标的更改通知时更新自身的状态
 */
public class BinaryObserver extends Observer {


   public BinaryObserver(Subject subject){
      this.subject = subject;
      //****注册:将自身注册到  subject被观察者的列表
      this.subject.attach(this);
   }
   //****只要被 观察 的对象(主题)状态发生变化 ，则由subject自动调用此方法
   @Override
   public void update() {
      //将主题中变化的状态值(数字)转为二进制.
      System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState() ) );
   }
}