package com.yc.designpattern.DMB15_观察者模式.DM1;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象主题（Subject）角色：也叫抽象目标类，
 *  它提供了一个用于保存观察者对象的聚集类和增加、删除观察者对象的方法，以及通知所有观察者的抽象方法。
 */
public class Subject {
   //*****观察者列表： 存所有注册的观察者.
   private List<Observer> observers = new ArrayList<Observer>();

   private int state;  //待观察的状态
 
   public int getState() {
      return state;
   }

   //state发生了变化
   public void setState(int state) {
      this.state = state;  // *****只要状态一变，
      notifyAllObservers();  // **** 则通知所有的观察者.
   }
   //****注册观察者方法
   public void attach(Observer observer){
      observers.add(observer);      
   }

   // 通知观察者方法
   public void notifyAllObservers(){
      //循环观察者列表
      for (Observer observer : observers) {
         observer.update();   //通知.
      }
   }  
}