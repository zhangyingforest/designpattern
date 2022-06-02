package com.yc.designpattern.DMA7_装饰者模式.DM1;

/**
 * 具体要装饰的功能
 * 具体装饰（ConcreteDecorator）角色：实现抽象装饰的相关方法，并给具体构件对象添加附加的责任。
 */
public class RedShapeDecorator extends ShapeDecorator {
 
   public RedShapeDecorator(Shape decoratedShape) {
      super(decoratedShape);     
   }
 
   @Override
   public void draw() {
      decoratedShape.draw();      //腺对象的方法
      setRedBorder(decoratedShape);   //再加入装饰功能.
   }

   //具体要加入的装饰功能
   private void setRedBorder(Shape decoratedShape){

      System.out.println("Border Color: Red");
   }
}