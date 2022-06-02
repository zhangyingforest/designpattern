package com.yc.designpattern.DMB22_状态模式.DM1;

/**
 * 具体状态（Concrete State）角色：实现抽象状态所对应的行为，并且在需要的情况下进行状态切换。
 * 停止状态
 */
public class StopState implements State {
 
   @Override
   public void doAction(Context context) {
      System.out.println("Player is in stop state");
      //给上下文对象设定对应的状态对象，然后在 context执行对应的操作
      // 这里避免了使用 if...else 这样的判断语句.
      context.setState(this); 
   }
 
   @Override
   public String toString(){
      return "Stop State";
   }
}