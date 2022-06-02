package com.yc.designpattern.DMA2_抽象工厂.DM1;

public class Blue implements Color {
 
   @Override
   public void fill() {
      System.out.println("Inside Blue::fill() method.");
   }
}