package com.yc.designpattern.DMB23_访问者模式.DM1;

//抽象访问者（Visitor）角色：定义一个访问具体元素的接口，
// 为每个具体元素类对应一个访问操作 visit() ，该操作中的参数类型标识了被访问的具体元素。
public interface ComputerPartVisitor {
   //访问者 处理每个具体的元素。
   public void visit(Computer computer);
   public void visit(Mouse mouse);
   public void visit(Keyboard keyboard);
   public void visit(Monitor monitor);
}