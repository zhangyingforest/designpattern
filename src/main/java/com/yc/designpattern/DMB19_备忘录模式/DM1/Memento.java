package com.yc.designpattern.DMB19_备忘录模式.DM1;

/**
 * 备忘录（Memento）角色：负责存储发起人的内部状态，在需要的时候提供这些内部状态给发起人。
 */
public class Memento {
   //TODO:要保存的状态信息
   private String state;
 
   public Memento(String state){
      this.state = state;
   }
 
   public String getState(){
      return state;
   }  
}