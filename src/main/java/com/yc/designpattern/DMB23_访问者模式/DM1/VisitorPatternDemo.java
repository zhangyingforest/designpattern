package com.yc.designpattern.DMB23_访问者模式.DM1;

/**
 * 测试类
 */
public class VisitorPatternDemo {
   public static void main(String[] args) {
 
      ComputerPart computer = new Computer();
      computer.accept(new ComputerPartDisplayVisitor());
   }
}