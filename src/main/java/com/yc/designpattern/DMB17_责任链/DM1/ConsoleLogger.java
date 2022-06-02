package com.yc.designpattern.DMB17_责任链.DM1;

public class ConsoleLogger extends AbstractLogger {
 
   public ConsoleLogger(int level){
      this.level = level;
   }
 
   @Override
   protected void write(String message) {    

      System.out.println("Standard Console::Logger: " + message);
   }
}