package com.yc.designpattern.DMB19_备忘录模式.DM1;

/**
 * 发起人（Originator）角色：
 *     记录当前时刻的内部状态信息，提供创建备忘录和恢复备忘录数据的功能，实现其他业务功能，它可以访问备忘录里的所有信息
 */
public class Originator {
   private String state;
 
   public void setState(String state){
      this.state = state;
   }
 
   public String getState(){
      return state;
   }

   /**
    * 生成一个备忘录对象
    * @return
    */
   public Memento saveStateToMemento(){
      //TODO:  .....将状态信息包装进去.
      return new Memento(state);
   }

   /**
    * 恢复关态
    * @param Memento
    */
   public void getStateFromMemento(Memento Memento){
      //TODO:．．．．从memento对象取出所有的状态进行恢复.
      state = Memento.getState();
   }
}