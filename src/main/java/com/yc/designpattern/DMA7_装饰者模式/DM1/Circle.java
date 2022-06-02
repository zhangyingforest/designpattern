package com.yc.designpattern.DMA7_装饰者模式.DM1;

/**
 * 具体构件（ConcreteComponent）角色：实现抽象构件，通过装饰角色为其添加一些职责
 */
public class Circle implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Shape: Circle");
   }
}