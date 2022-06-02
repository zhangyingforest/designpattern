package com.yc.designpattern.DMA1_工厂方法.DM1_simplefactory;

public class Square implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Inside Square::draw() method.");
   }
}