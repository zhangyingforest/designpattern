package com.yc.designpattern.DMA4_原型模式.DM2_带管理容器的原型模式;

public class Rectangle extends Shape {
 
   public Rectangle(){
     type = "Rectangle";
   }
 
   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}