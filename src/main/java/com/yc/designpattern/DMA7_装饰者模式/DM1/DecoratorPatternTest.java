package com.yc.designpattern.DMA7_装饰者模式.DM1;

/**
 * 测试类
 */
public class DecoratorPatternTest {
   public static void main(String[] args) {

      Shape circle = new Circle();
      //对circle进行装饰
      ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
      ShapeDecorator redRectangle =   new RedShapeDecorator(new Rectangle());
      //Shape redCircle = new RedShapeDecorator(new Circle());
      //Shape redRectangle = new RedShapeDecorator(new Rectangle());
      System.out.println("原始circle");
      circle.draw();

      System.out.println("\n装饰成红色的circle");
      redCircle.draw();

      System.out.println("\n装饰成红色的rectangle");
      redRectangle.draw();
   }
}
