package com.yc.designpattern.DMA9_外观模式.DM1;

/**
 * 子系统（Sub System）角色
 */
public class Circle implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Circle::draw()");
   }
}