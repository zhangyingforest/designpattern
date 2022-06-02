package com.yc.designpattern.DMB22_状态模式.DM1;

/**
 * 测试类
 */
public class StatePatternDemo {
   public static void main(String[] args) {

      Context context = new Context();
      //注意比较:  以下状态发生变化时，无须要用  if..else做状态判断.

      //设置状态为开始.
      StartState startState = new StartState();
      startState.doAction(context);
 
      System.out.println(context.getState().toString());

      //修改状态为  stop
      StopState stopState = new StopState();
      stopState.doAction(context);
 
      System.out.println(context.getState().toString());
   }
}