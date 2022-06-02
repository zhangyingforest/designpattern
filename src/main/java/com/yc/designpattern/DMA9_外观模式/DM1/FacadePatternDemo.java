package com.yc.designpattern.DMA9_外观模式.DM1;

/**
 * 测试类
 */
public class FacadePatternDemo {

   public static void main(String[] args) {
      //创建门面类
      ShapeFacade shapeMaker = new ShapeFacade();

      //利用门面对象来进行访问
      shapeMaker.drawCircle();
      shapeMaker.drawRectangle();
      shapeMaker.drawSquare();      
   }

}