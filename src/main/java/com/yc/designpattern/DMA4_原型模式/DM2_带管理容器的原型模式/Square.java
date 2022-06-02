package com.yc.designpattern.DMA4_原型模式.DM2_带管理容器的原型模式;

public class Square extends Shape {
 
   public Square(){
     type = "Square";
   }
 
   @Override
   public void draw() {
      System.out.println("Inside Square::draw() method.");
   }
}