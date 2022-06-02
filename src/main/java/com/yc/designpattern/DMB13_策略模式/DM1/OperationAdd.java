package com.yc.designpattern.DMB13_策略模式.DM1;

public class OperationAdd implements Strategy {
   @Override
   public int doOperation(int num1, int num2) {
      return num1 + num2;
   }
}