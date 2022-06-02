package com.yc.designpattern.DMB22_状态模式.DM1;

/**
 * 环境类（Context）角色：也称为上下文，它定义了客户端需要的接口，内部维护一个当前状态，并负责具体状态的切换。
 *
 * 状态机
 */
public class Context {
   /**
    *  ******* 状态
    */
   private State state;
 
   public Context(){
      state = null;
   }

   //******状态修改
   public void setState(State state){
      this.state = state;
      //TODO:在这里可以加入 状态修改后的进一步的操作...

      //修改状态  -> 触发事件   -> 消息通知   -> 操作  -> 状态改变.
      //    a   ->  e1       ->    b
      //    b   ->   e2      ->    c


   }
 
   public State getState(){
      return state;
   }
}