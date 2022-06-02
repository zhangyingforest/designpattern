package com.yc.designpattern.DMA10_桥接模式.DM1;
/**
 * 实现化（Implementor）角色：定义实现化角色的接口，供扩展抽象化角色调用
 * 使用 DrawAPI 接口创建抽象类 Shape
 */
public interface DrawAPI {

   public void drawCircle(int radius, int x, int y);

}