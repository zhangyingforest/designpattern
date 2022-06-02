package com.yc.designpattern.DMA9_外观模式.DM1;

/**
 * 外观（Facade）角色：为多个子系统对外提供一个共同的接口
 */
public class ShapeFacade {
   //各子系统
   private Shape circle;
   private Shape rectangle;
   private Shape square;
 
   public ShapeFacade() {
      circle = new Circle();
      rectangle = new Rectangle();
      square = new Square();
   }
 
   public void drawCircle(){
      circle.draw();
   }
   public void drawRectangle(){
      rectangle.draw();
   }
   public void drawSquare(){
      square.draw();
   }
}