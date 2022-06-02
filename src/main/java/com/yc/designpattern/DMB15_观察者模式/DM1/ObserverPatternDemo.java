package com.yc.designpattern.DMB15_观察者模式.DM1;

/**
 * 测试类
 */
public class ObserverPatternDemo {
   public static void main(String[] args) {

      Subject subject = new Subject();  //抽象主题（Subject）角色：也叫抽象目标类，它保存观察者对象
      //1. 将观察者注册到注册上.
      new HexaObserver(subject);
      new OctalObserver(subject);
      new BinaryObserver(subject);

      //2. 状态修改，发出通知.
      System.out.println("修改状态值: 15");
      subject.setState(15);  //只要subject状态一变，则发出通知



//      System.out.println("第二次修改状态值: 10");
//      subject.setState(10);
   }
}