package com.yc.designpattern.DMA10_桥接模式.DM1;

/**
 * 测试类
 * 使用 Shape 和 DrawAPI 类画出不同颜色的圆
 */
public class BridgePatternDemo {

   public static void main(String[] args) {

      Shape redCircle = new Circle(100,100, 10, new RedDraw());
      Shape greenCircle = new Circle(100,100, 10, new GreenDraw());
 
      redCircle.draw();
      greenCircle.draw();
   }
}