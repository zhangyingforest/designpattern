package com.yc.designpattern.DMB14_模板方法.DM1;

/**
 * 测试类
 */
public class TemplatePatternDemo {
   public static void main(String[] args) {


 
      Game game = new Cricket();
      game.play();
      System.out.println();

      game = new Football();
      game.play();      
   }
}