package com.yc.designpattern.DMA2_抽象工厂.DM1;

public class Green implements Color {
 
   @Override
   public void fill() {
      System.out.println("Inside Green::fill() method.");
   }
}