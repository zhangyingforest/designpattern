package com.yc.designpattern.DMA2_抽象工厂.DM1;

public class Circle implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Inside Circle::draw() method.");
   }
}