package com.yc.designpattern.DMB15_观察者模式.DM1;

/**
 * 抽象观察者（Observer）角色：它是一个抽象类或接口，它包含了一个更新自己的抽象方法，
 * 当接到具体主题的更改通知时被调用。
 */
public abstract class Observer {
   /**
    * ***要监听主题
    */
   protected Subject subject;

   //*****回调方法
   public abstract void update();
}