package com.yc.designpattern.DMA10_桥接模式.DM1;

/**
 * 扩展抽象化（Refined Abstraction）角色：是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法。
 * 实现了 Shape 抽象类的实体类
 */
public class Circle extends Shape {
   private int x, y, radius;
 
   public Circle(int x, int y, int radius, DrawAPI drawAPI) {
      super(drawAPI);
      this.x = x;  
      this.y = y;  
      this.radius = radius;
   }
 
   @Override
   public void draw() {
      drawAPI.drawCircle(radius,x,y);
   }
}