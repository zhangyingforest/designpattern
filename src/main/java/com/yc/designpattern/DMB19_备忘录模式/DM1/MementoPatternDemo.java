package com.yc.designpattern.DMB19_备忘录模式.DM1;

/**
 * 测试类
 */
public class MementoPatternDemo {
   public static void main(String[] args) {
      //创建发起人（Originator）角色： 生成要保存的备忘的对象
      Originator originator = new Originator();
      //创建管理者（Caretaker）:保存的列表
      CareTaker careTaker = new CareTaker();

      //记录状态
      originator.setState("State #1");  //#1的状态没有保存
      originator.setState("State #2");
      //保存状态
      careTaker.add(   originator.saveStateToMemento());  //只保存了#2状态.
      originator.setState("State #3");
      careTaker.add(originator.saveStateToMemento());
      originator.setState("State #4");
 
      System.out.println("当前状态: " + originator.getState());  //#4

      originator.getStateFromMemento(careTaker.get(0));
      System.out.println("取保存好的第一个状态:  " + originator.getState());  // #2

      originator.getStateFromMemento(careTaker.get(1));
      System.out.println("取保存好的第二个状态: " + originator.getState());  // #3
   }
}