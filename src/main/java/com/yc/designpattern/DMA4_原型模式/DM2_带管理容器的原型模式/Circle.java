package com.yc.designpattern.DMA4_原型模式.DM2_带管理容器的原型模式;

public class Circle extends Shape implements Cloneable{
 
   public Circle(){
     type = "Circle";
   }



   @Override
   public void draw() {
      System.out.println("Inside Circle::draw() method.");
   }
}