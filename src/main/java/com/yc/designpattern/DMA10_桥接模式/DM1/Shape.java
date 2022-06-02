package com.yc.designpattern.DMA10_桥接模式.DM1;

/**
 * 抽象化（Abstraction）角色：定义抽象类，并包含一个对实现化对象的引用
 * 创建桥接实现接口
 */
public abstract class Shape {
   //有一个抽象角色的引用, 实现组合关系.
   protected DrawAPI drawAPI;

   protected Shape(DrawAPI drawAPI){
      this.drawAPI = drawAPI;
   }

   //具体的绘制由子类实现》
   public abstract void draw();  
}