package com.yc.designpattern.DMB13_策略模式.DM1;

public class Context {
   //真实采用的策略
   private Strategy strategy;
 
   public Context(Strategy strategy){
      this.strategy = strategy;
   }
 
   public int executeStrategy(int num1, int num2){

      return strategy.doOperation(num1, num2);
   }


}