package com.yc.designpattern.DMA2_抽象工厂.DM1;

public abstract class AbstractFactory {

   public abstract Color getColor(String color);
   public abstract Shape getShape(String shape) ;
}