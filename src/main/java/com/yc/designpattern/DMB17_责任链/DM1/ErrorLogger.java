package com.yc.designpattern.DMB17_责任链.DM1;

/**
 *
 */
public class ErrorLogger extends AbstractLogger {
 
   public ErrorLogger(int level){
      this.level = level;
   }
 
   @Override
   protected void write(String message) {    
      System.out.println("Error Logger: " + message);
   }
}