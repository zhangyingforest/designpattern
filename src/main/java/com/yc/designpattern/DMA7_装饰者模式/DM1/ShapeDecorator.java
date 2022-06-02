package com.yc.designpattern.DMA7_装饰者模式.DM1;


/**
 * 抽象装饰（Decorator）角色：继承抽象构件，并包含具体构件的实例，可以通过其子类扩展具体构件的功能。
 */
public abstract class ShapeDecorator implements Shape {

   protected Shape decoratedShape;
 
   public ShapeDecorator(Shape decoratedShape){
      this.decoratedShape = decoratedShape;
   }
 
   @Override
   public void draw(){
      decoratedShape.draw();
   }  
}