package com.yc.designpattern.DMA2_抽象工厂.DM1;

public class Red implements Color {
 
   @Override
   public void fill() {
      System.out.println("Inside Red::fill() method.");
   }
}