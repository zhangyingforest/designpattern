package com.yc.designpattern.DMA2_抽象工厂.DM1;

public class Rectangle implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}