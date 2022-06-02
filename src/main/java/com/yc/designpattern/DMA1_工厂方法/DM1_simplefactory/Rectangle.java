package com.yc.designpattern.DMA1_工厂方法.DM1_simplefactory;

public class Rectangle implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}