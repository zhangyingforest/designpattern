package com.yc.designpattern.DMB14_模板方法.DM1;

public class Football extends Game {

   @Override
   void initialize() {
      System.out.println("足球游戏初始化!.");
   }


   @Override
   void startPlay() {
      System.out.println("足球游戏开始!");
   }
 
   @Override
   void endPlay() {
      System.out.println("足球游戏结束!");
   }
 


}