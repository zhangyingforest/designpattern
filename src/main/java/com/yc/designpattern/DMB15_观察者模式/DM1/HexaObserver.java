package com.yc.designpattern.DMB15_观察者模式.DM1;

/**
 * 具体观察者（Concrete Observer）角色：实现抽象观察者中定义的抽象方法，以便在得到目标的更改通知时更新自身的状态
 */
public class HexaObserver extends Observer {
 
   public HexaObserver(Subject subject){
      this.subject = subject;
      //将自身注册到主题
      this.subject.attach(this);
   }
 
   @Override
   public void update() {
      System.out.println( "Hex String: " + Integer.toHexString( subject.getState() ).toUpperCase() );
   }
}