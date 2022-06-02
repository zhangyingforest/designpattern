package com.yc.designpattern.DMB17_责任链.DM1;

public abstract class AbstractLogger {
   public static int INFO = 1;
   public static int DEBUG = 2;
   public static int ERROR = 3;

   /**
    *    当前logger的级别: 只有要输出 的信息的级别中于等于level时，当前这个logger才能处理 write()
    *          如果大于此level， 就要通过职责链，去查看是否有更高级别的logger.
    */
   protected int level;  // 1
 
   //责任链中的下一个元素
   protected AbstractLogger nextLogger;
 
   public void setNextLogger(AbstractLogger nextLogger){
      this.nextLogger = nextLogger;
   }

   /**
    *
    * @param level： 信息的级别
    * @param message: 日志信息
    */
   public void logMessage(int level, String message){
      if(this.level <= level){
         write(message);
      }
      //如果message的级别level高于当前这个logger对应的级别，则交给它的下一级进行处理》
      if(nextLogger !=null){
         nextLogger.logMessage(level, message);
      }
   }
 
   abstract protected void write(String message);
   
}